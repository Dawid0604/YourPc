/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.adapter.out.persistence;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import net.datafaker.Faker;
import pl.dawid0604.yourpc.structure.domain.section.Section;

@ExtendWith(MockitoExtension.class)
@DisplayName("SectionEntityMapper tests")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SectionEntityMapperTest {
    private static final Faker FAKER = new Faker();

    @Nested
    @DisplayName("toEntity tests")
    class ToEntityTests {

        @Test
        void should_return_null_when_section_is_null() {
            // Given
            // When
            // Then
            Assertions.assertThat(SectionEntityMapper.toEntity(null)).isNull();
        }

        @Test
        void should_map_successfully_without_parent() {
            // Given
            final Section mockSection = mock(Section.class);
            final Long id = (long) FAKER.number().positive();
            final String name = FAKER.name().name();
            final String slug = FAKER.internet().slug();
            final String description = FAKER.lorem().sentence();
            final String thumbnail = FAKER.internet().image();

            given(mockSection.getId()).willReturn(id);
            given(mockSection.getName()).willReturn(name);
            given(mockSection.getSlug()).willReturn(slug);
            given(mockSection.getDescription()).willReturn(description);
            given(mockSection.getThumbnail()).willReturn(thumbnail);

            // When
            final SectionEntity result = SectionEntityMapper.toEntity(mockSection);

            // Then
            Assertions.assertThat(result).isNotNull();
            Assertions.assertThat(result.getId()).isEqualTo(id);
            Assertions.assertThat(result.getName()).isEqualTo(name);
            Assertions.assertThat(result.getSlug()).isEqualTo(slug);
            Assertions.assertThat(result.getDescription()).isEqualTo(description);
            Assertions.assertThat(result.getThumbnail()).isEqualTo(thumbnail);
            Assertions.assertThat(result.getParent()).isNull();

            verify(mockSection).getParent();
        }

        @Test
        void should_map_successfully_with_parent() {
            // Given
            final Section mockSection = mock(Section.class);
            final Section mockParentSection = mock(Section.class);

            final Long id = (long) FAKER.number().positive();
            final String name = FAKER.name().name();
            final String slug = FAKER.internet().slug();
            final String description = FAKER.lorem().sentence();
            final String thumbnail = FAKER.internet().image();

            final Long parentId = (long) FAKER.number().positive();
            final String parentName = FAKER.name().name();
            final String parentSlug = FAKER.internet().slug();
            final String parentDescription = FAKER.lorem().sentence();
            final String parentThumbnail = FAKER.internet().image();

            given(mockSection.getId()).willReturn(id);
            given(mockSection.getName()).willReturn(name);
            given(mockSection.getSlug()).willReturn(slug);
            given(mockSection.getDescription()).willReturn(description);
            given(mockSection.getThumbnail()).willReturn(thumbnail);
            given(mockSection.getParent()).willReturn(mockParentSection);

            given(mockParentSection.getId()).willReturn(parentId);
            given(mockParentSection.getName()).willReturn(parentName);
            given(mockParentSection.getSlug()).willReturn(parentSlug);
            given(mockParentSection.getDescription()).willReturn(parentDescription);
            given(mockParentSection.getThumbnail()).willReturn(parentThumbnail);

            // When
            final SectionEntity result = SectionEntityMapper.toEntity(mockSection);

            // Then
            Assertions.assertThat(result).isNotNull();
            Assertions.assertThat(result.getId()).isEqualTo(id);
            Assertions.assertThat(result.getName()).isEqualTo(name);
            Assertions.assertThat(result.getSlug()).isEqualTo(slug);
            Assertions.assertThat(result.getDescription()).isEqualTo(description);
            Assertions.assertThat(result.getThumbnail()).isEqualTo(thumbnail);

            Assertions.assertThat(result.getParent()).isNotNull();
            Assertions.assertThat(result.getParent().getId()).isEqualTo(parentId);
            Assertions.assertThat(result.getParent().getName()).isEqualTo(parentName);
            Assertions.assertThat(result.getParent().getSlug()).isEqualTo(parentSlug);
            Assertions.assertThat(result.getParent().getDescription()).isEqualTo(parentDescription);
            Assertions.assertThat(result.getParent().getThumbnail()).isEqualTo(parentThumbnail);
            Assertions.assertThat(result.getParent().getParent()).isNull();

            verify(mockParentSection).getParent();
        }
    }

    @Nested
    @DisplayName("toDomain tests")
    class ToDomainTests {

        @Test
        void should_return_null_when_entity_is_null() {
            // Given
            // When
            // Then
            Assertions.assertThat(SectionEntityMapper.toDomain(null)).isNull();
        }

        @Test
        void should_map_successfully_without_parent() {
            // Given
            final SectionEntity mockSection = mock(SectionEntity.class);
            final Long id = (long) FAKER.number().positive();
            final String name = FAKER.name().name();
            final String slug = FAKER.internet().slug();
            final String description = FAKER.lorem().sentence();
            final String thumbnail = FAKER.internet().image();

            given(mockSection.getId()).willReturn(id);
            given(mockSection.getName()).willReturn(name);
            given(mockSection.getSlug()).willReturn(slug);
            given(mockSection.getDescription()).willReturn(description);
            given(mockSection.getThumbnail()).willReturn(thumbnail);

            // When
            final Section result = SectionEntityMapper.toDomain(mockSection);

            // Then
            Assertions.assertThat(result).isNotNull();
            Assertions.assertThat(result.getId()).isEqualTo(id);
            Assertions.assertThat(result.getName()).isEqualTo(name);
            Assertions.assertThat(result.getSlug()).isEqualTo(slug);
            Assertions.assertThat(result.getDescription()).isEqualTo(description);
            Assertions.assertThat(result.getThumbnail()).isEqualTo(thumbnail);
            Assertions.assertThat(result.getParent()).isNull();

            verify(mockSection).getParent();
        }

        @Test
        void should_map_successfully_with_parent() {
            // Given
            final SectionEntity mockSection = mock(SectionEntity.class);
            final SectionEntity mockParentSection = mock(SectionEntity.class);

            final Long id = (long) FAKER.number().positive();
            final String name = FAKER.name().name();
            final String slug = FAKER.internet().slug();
            final String description = FAKER.lorem().sentence();
            final String thumbnail = FAKER.internet().image();

            final Long parentId = (long) FAKER.number().positive();
            final String parentName = FAKER.name().name();
            final String parentSlug = FAKER.internet().slug();
            final String parentDescription = FAKER.lorem().sentence();
            final String parentThumbnail = FAKER.internet().image();

            given(mockSection.getId()).willReturn(id);
            given(mockSection.getName()).willReturn(name);
            given(mockSection.getSlug()).willReturn(slug);
            given(mockSection.getDescription()).willReturn(description);
            given(mockSection.getThumbnail()).willReturn(thumbnail);
            given(mockSection.getParent()).willReturn(mockParentSection);

            given(mockParentSection.getId()).willReturn(parentId);
            given(mockParentSection.getName()).willReturn(parentName);
            given(mockParentSection.getSlug()).willReturn(parentSlug);
            given(mockParentSection.getDescription()).willReturn(parentDescription);
            given(mockParentSection.getThumbnail()).willReturn(parentThumbnail);

            // When
            final Section result = SectionEntityMapper.toDomain(mockSection);

            // Then
            Assertions.assertThat(result).isNotNull();
            Assertions.assertThat(result.getId()).isEqualTo(id);
            Assertions.assertThat(result.getName()).isEqualTo(name);
            Assertions.assertThat(result.getSlug()).isEqualTo(slug);
            Assertions.assertThat(result.getDescription()).isEqualTo(description);
            Assertions.assertThat(result.getThumbnail()).isEqualTo(thumbnail);

            Assertions.assertThat(result.getParent()).isNotNull();
            Assertions.assertThat(result.getParent().getId()).isEqualTo(parentId);
            Assertions.assertThat(result.getParent().getName()).isEqualTo(parentName);
            Assertions.assertThat(result.getParent().getSlug()).isEqualTo(parentSlug);
            Assertions.assertThat(result.getParent().getDescription()).isEqualTo(parentDescription);
            Assertions.assertThat(result.getParent().getThumbnail()).isEqualTo(parentThumbnail);
            Assertions.assertThat(result.getParent().getParent()).isNull();

            verify(mockParentSection).getParent();
        }
    }
}
