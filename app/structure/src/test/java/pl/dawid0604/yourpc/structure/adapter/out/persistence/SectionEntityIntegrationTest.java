/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.adapter.out.persistence;

import java.time.LocalDateTime;

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
@DisplayName("SectionEntity integration tests")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SectionEntityIntegrationTest {
    private static final Faker FAKER = new Faker();

    @Autowired private TestEntityManager entityManager;

    @BeforeEach
    void clearContext() {
        entityManager.clear();
    }

    @Nested
    @DisplayName("PrePersist tests")
    class PrePersistTests {

        @Test
        void should_set_timestamps_on_save() {
            // Given
            final SectionEntity sectionEntity =
                    SectionEntity.builder()
                            .name(FAKER.lorem().word())
                            .slug(FAKER.internet().slug())
                            .description(FAKER.lorem().sentence())
                            .build();

            Assertions.assertThat(sectionEntity.getCreatedAt())
                    .as("CreatedAt must be null before save")
                    .isNull();

            Assertions.assertThat(sectionEntity.getUpdatedAt())
                    .as("UpdatedAt must be null before save")
                    .isNull();

            // When
            final SectionEntity entity = entityManager.persistAndFlush(sectionEntity);

            // Then
            Assertions.assertThat(entity.getCreatedAt()).isNotNull();
            Assertions.assertThat(entity.getUpdatedAt()).isNotNull();

            Assertions.assertThat(entity.getCreatedAt())
                    .as("CreatedAt must be equal to UpdatedAt after save")
                    .isEqualTo(entity.getUpdatedAt());
        }
    }

    @Nested
    @DisplayName("PreUpdate tests")
    class PreUpdateTests {

        @Test
        void should_update_updatedAt_on_update() throws InterruptedException {
            // Given
            final SectionEntity sectionEntity =
                    SectionEntity.builder()
                            .name(FAKER.lorem().word())
                            .slug(FAKER.internet().slug())
                            .description(FAKER.lorem().sentence())
                            .build();

            // When
            final SectionEntity savedSectionEntity = entityManager.persistAndFlush(sectionEntity);
            final LocalDateTime updatedAtBeforeUpdate = savedSectionEntity.getUpdatedAt();

            // Dates must be different
            Thread.sleep(1000);

            // Update name
            savedSectionEntity.setName(FAKER.lorem().word());

            // When
            entityManager.flush();

            // Then
            Assertions.assertThat(savedSectionEntity.getUpdatedAt()).isAfter(updatedAtBeforeUpdate);
        }

        @Test
        void should_not_update_createdAt_on_update() throws InterruptedException {
            // Given
            final SectionEntity sectionEntity =
                    SectionEntity.builder()
                            .name(FAKER.lorem().word())
                            .slug(FAKER.internet().slug())
                            .description(FAKER.lorem().sentence())
                            .build();

            // When
            final SectionEntity savedSectionEntity = entityManager.persistAndFlush(sectionEntity);
            final LocalDateTime createdAtBeforeUpdate = savedSectionEntity.getCreatedAt();

            // Dates must be different
            Thread.sleep(1000);

            // Update name
            savedSectionEntity.setName(FAKER.lorem().word());

            // When
            entityManager.flush();

            // Then
            Assertions.assertThat(savedSectionEntity.getCreatedAt())
                    .isEqualTo(createdAtBeforeUpdate);
        }
    }

    @Nested
    @DisplayName("Parent-child relationship tests")
    class RelationshipTests {

        @Test
        void should_persist_section_without_parent() {
            // Given
            final SectionEntity sectionEntity =
                    SectionEntity.builder()
                            .name(FAKER.lorem().word())
                            .slug(FAKER.internet().slug())
                            .description(FAKER.lorem().sentence())
                            .build();

            // When
            final SectionEntity savedSectionEntity = entityManager.persistAndFlush(sectionEntity);

            // Then
            Assertions.assertThat(savedSectionEntity.getParent()).isNull();
        }

        @Test
        void should_persist_section_with_parent() {
            // Given
            final SectionEntity parent =
                    SectionEntity.builder()
                            .name(FAKER.lorem().word())
                            .slug(FAKER.internet().slug())
                            .description(FAKER.lorem().sentence())
                            .build();

            final SectionEntity child =
                    SectionEntity.builder()
                            .name(FAKER.lorem().word())
                            .slug(FAKER.internet().slug())
                            .description(FAKER.lorem().sentence())
                            .parent(parent)
                            .build();

            // When
            final SectionEntity savedParent = entityManager.persistAndFlush(parent);
            final SectionEntity savedChild = entityManager.persistAndFlush(child);

            // Then
            Assertions.assertThat(savedChild.getParent()).isEqualTo(savedParent);
            Assertions.assertThat(savedParent.getParent()).isNull();
        }
    }
}
