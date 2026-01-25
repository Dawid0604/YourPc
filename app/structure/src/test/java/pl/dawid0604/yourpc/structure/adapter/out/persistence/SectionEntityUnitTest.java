/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.adapter.out.persistence;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import net.datafaker.Faker;

@DisplayName("SectionEntity unit tests")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class SectionEntityUnitTest {
    private static final Faker FAKER = new Faker();

    @Nested
    @DisplayName("EqualsAndHasCode tests")
    class EqualsAndHashCodeTests {

        @Test
        void should_be_equal_when_ids_are_same() {
            // Given
            final SectionEntity sectionEntity =
                    SectionEntity.builder()
                            .id(1L)
                            .name(FAKER.lorem().word())
                            .slug(FAKER.internet().slug())
                            .description(FAKER.lorem().sentence())
                            .build();

            final SectionEntity secondSectionEntity =
                    SectionEntity.builder()
                            .id(sectionEntity.getId())
                            .name(FAKER.lorem().word())
                            .slug(FAKER.internet().slug())
                            .description(FAKER.lorem().sentence())
                            .build();

            // Then
            Assertions.assertThat(secondSectionEntity).isEqualTo(sectionEntity);
            Assertions.assertThat(secondSectionEntity.hashCode()).hasSameHashCodeAs(sectionEntity);
        }

        @Test
        void should_not_be_equal_when_ids_are_different() {
            // Given
            final SectionEntity sectionEntity =
                    SectionEntity.builder()
                            .id(1L)
                            .name(FAKER.lorem().word())
                            .slug(FAKER.internet().slug())
                            .description(FAKER.lorem().sentence())
                            .build();

            final SectionEntity secondSectionEntity =
                    SectionEntity.builder()
                            .id(5L)
                            .name(FAKER.lorem().word())
                            .slug(FAKER.internet().slug())
                            .description(FAKER.lorem().sentence())
                            .build();

            // Then
            Assertions.assertThat(secondSectionEntity).isNotEqualTo(sectionEntity);
            Assertions.assertThat(secondSectionEntity.hashCode())
                    .isNotEqualTo(sectionEntity.hashCode());
        }
    }
}
