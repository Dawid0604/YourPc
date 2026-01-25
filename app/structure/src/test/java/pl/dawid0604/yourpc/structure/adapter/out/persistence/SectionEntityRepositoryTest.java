/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.adapter.out.persistence;

import java.util.List;

import jakarta.persistence.PersistenceUnitUtil;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;

import net.datafaker.Faker;
import pl.dawid0604.yourpc.structure.adapter.IntegrationTestContext;

@DataJpaTest
@IntegrationTestContext
@DisplayName("SectionEntityRepository tests")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SectionEntityRepositoryTest {
    private static final Faker FAKER = new Faker();

    @Autowired private SectionEntityRepository repository;
    @Autowired private TestEntityManager entityManager;

    @BeforeEach
    void clearContext() {
        repository.deleteAll();
        entityManager.clear();
    }

    @Nested
    @DisplayName("findAllByParentSlug() tests")
    class FindAllByParentSlugTests {

        @Test
        void should_return_sections_with_parent_slug() {
            // Given
            final SectionEntity parentSection =
                    SectionEntity.builder()
                            .name(FAKER.lorem().word())
                            .slug(FAKER.internet().slug())
                            .description(FAKER.lorem().sentence())
                            .thumbnail(FAKER.internet().image())
                            .build();

            final SectionEntity childSection =
                    SectionEntity.builder()
                            .name(FAKER.lorem().word())
                            .slug(FAKER.internet().slug())
                            .description(FAKER.lorem().sentence())
                            .thumbnail(FAKER.internet().image())
                            .parent(parentSection)
                            .build();

            entityManager.persistAndFlush(parentSection);
            final SectionEntity savedChildSection = entityManager.persistAndFlush(childSection);

            // When
            final List<SectionEntity> result =
                    repository.findAllByParentSlug(parentSection.getSlug());

            // Then
            Assertions.assertThat(result).isNotNull().hasSize(1).containsExactly(savedChildSection);

            final PersistenceUnitUtil persistenceUnit =
                    entityManager
                            .getEntityManager()
                            .getEntityManagerFactory()
                            .getPersistenceUnitUtil();

            Assertions.assertThat(persistenceUnit.isLoaded(result.getFirst(), "parent")).isTrue();
        }
    }

    @Test
    void should_return_sections_with_parent_slug_and_when_there_is_more_than_one_section() {
        // Given
        final SectionEntity parentSection =
                SectionEntity.builder()
                        .name(FAKER.lorem().word())
                        .slug(FAKER.internet().slug())
                        .description(FAKER.lorem().sentence())
                        .thumbnail(FAKER.internet().image())
                        .build();

        final SectionEntity childSection =
                SectionEntity.builder()
                        .name(FAKER.lorem().word())
                        .slug(FAKER.internet().slug())
                        .description(FAKER.lorem().sentence())
                        .thumbnail(FAKER.internet().image())
                        .parent(parentSection)
                        .build();

        final SectionEntity secondParentSection =
                SectionEntity.builder()
                        .name(FAKER.lorem().word())
                        .slug(FAKER.internet().slug())
                        .description(FAKER.lorem().sentence())
                        .thumbnail(FAKER.internet().image())
                        .build();

        final SectionEntity secondChildSection =
                SectionEntity.builder()
                        .name(FAKER.lorem().word())
                        .slug(FAKER.internet().slug())
                        .description(FAKER.lorem().sentence())
                        .thumbnail(FAKER.internet().image())
                        .parent(secondParentSection)
                        .build();

        entityManager.persistAndFlush(parentSection);
        entityManager.persistAndFlush(secondParentSection);
        entityManager.persistAndFlush(secondChildSection);
        final SectionEntity savedChildSection = entityManager.persistAndFlush(childSection);

        // When
        final List<SectionEntity> result = repository.findAllByParentSlug(parentSection.getSlug());

        // Then
        Assertions.assertThat(result).isNotNull().hasSize(1).containsExactly(savedChildSection);

        final PersistenceUnitUtil persistenceUnit =
                entityManager.getEntityManager().getEntityManagerFactory().getPersistenceUnitUtil();

        Assertions.assertThat(persistenceUnit.isLoaded(result.getFirst(), "parent")).isTrue();
    }

    @Nested
    @DisplayName("findAllWithNullableParentTests() tests")
    class FindAllWithNullableParentTests {

        @Test
        void should_return_sections_with_null_parent() {
            // Given
            final SectionEntity section =
                    SectionEntity.builder()
                            .name(FAKER.lorem().word())
                            .slug(FAKER.internet().slug())
                            .description(FAKER.lorem().sentence())
                            .thumbnail(FAKER.internet().image())
                            .build();

            final SectionEntity secondSection =
                    SectionEntity.builder()
                            .name(FAKER.lorem().word())
                            .slug(FAKER.internet().slug())
                            .description(FAKER.lorem().sentence())
                            .thumbnail(FAKER.internet().image())
                            .build();

            final SectionEntity secondSectionChild =
                    SectionEntity.builder()
                            .name(FAKER.lorem().word())
                            .slug(FAKER.internet().slug())
                            .description(FAKER.lorem().sentence())
                            .thumbnail(FAKER.internet().image())
                            .parent(secondSection)
                            .build();

            final SectionEntity savedSection = entityManager.persistAndFlush(section);
            final SectionEntity secondSavedSection = entityManager.persistAndFlush(secondSection);
            entityManager.persistAndFlush(secondSectionChild);

            // When
            final List<SectionEntity> result = repository.findAllWithNullableParent();

            // Then
            Assertions.assertThat(result)
                    .isNotNull()
                    .hasSize(2)
                    .containsExactly(savedSection, secondSavedSection);

            final PersistenceUnitUtil persistenceUnit =
                    entityManager
                            .getEntityManager()
                            .getEntityManagerFactory()
                            .getPersistenceUnitUtil();

            Assertions.assertThat(persistenceUnit.isLoaded(result.getFirst(), "parent")).isTrue();
            Assertions.assertThat(persistenceUnit.isLoaded(result.getLast(), "parent")).isTrue();
        }
    }
}
