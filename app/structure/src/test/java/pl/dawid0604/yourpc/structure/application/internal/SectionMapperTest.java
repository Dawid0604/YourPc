/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.application.internal;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.lang.reflect.Modifier;
import java.util.Objects;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import net.datafaker.Faker;
import pl.dawid0604.yourpc.structure.adapter.in.dto.SectionDTO;
import pl.dawid0604.yourpc.structure.domain.section.Section;

@ExtendWith(MockitoExtension.class)
@DisplayName("SectionMapper tests")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SectionMapperTest {
    private static final Faker FAKER = new Faker();

    @Test
    void should_have_private_constructor() {
        // Given
        final var constructors = SectionMapper.class.getDeclaredConstructors();

        // When
        // Then
        Assertions.assertThat(constructors)
                .as("Class should contain exactly one constructor")
                .hasSize(1);

        Assertions.assertThat(Modifier.isPrivate(constructors[0].getModifiers()))
                .as("Constructor should be private")
                .isTrue();
    }

    @RepeatedTest(20)
    void should_map_section_successfully() {
        // Given
        final Section sectionMock = mock(Section.class);
        final String name = FAKER.commerce().productName();
        final String slug = FAKER.internet().slug();
        final String description = FAKER.options().option(FAKER.lorem().sentence(), null);
        final String thumbnail = FAKER.options().option(FAKER.internet().image(), null);

        given(sectionMock.getName()).willReturn(name);

        given(sectionMock.getSlug()).willReturn(slug);

        given(sectionMock.getDescription()).willReturn(description);

        given(sectionMock.getThumbnail()).willReturn(thumbnail);

        // When
        final SectionDTO result = SectionMapper.toDto(sectionMock);

        // Then
        verify(sectionMock).getParent();

        Assertions.assertThat(result)
                .isNotNull()
                .matches(r -> Objects.equals(r.name(), name), "Names should be equal")
                .matches(r -> Objects.equals(r.slug(), slug), "Slugs should be equal")
                .matches(
                        r -> Objects.equals(r.description(), description),
                        "Descriptions should be equal")
                .matches(
                        r -> Objects.equals(r.thumbnail(), thumbnail),
                        "Thumbnails should be equal");
    }

    @RepeatedTest(20)
    void should_map_section_with_parent() {
        // Given
        final Section parentSectionMock = mock(Section.class);
        final String parentName = FAKER.commerce().productName();
        final String parentSlug = FAKER.internet().slug();
        final String parentDescription = FAKER.options().option(FAKER.lorem().sentence(), null);
        final String parentThumbnail = FAKER.options().option(FAKER.internet().image(), null);

        given(parentSectionMock.getName()).willReturn(parentName);
        given(parentSectionMock.getSlug()).willReturn(parentSlug);
        given(parentSectionMock.getDescription()).willReturn(parentDescription);
        given(parentSectionMock.getThumbnail()).willReturn(parentThumbnail);

        final Section sectionMock = mock(Section.class);
        final String name = FAKER.commerce().productName();
        final String slug = FAKER.internet().slug();
        final String description = FAKER.options().option(FAKER.lorem().sentence(), null);
        final String thumbnail = FAKER.options().option(FAKER.internet().image(), null);

        given(sectionMock.getName()).willReturn(name);
        given(sectionMock.getSlug()).willReturn(slug);
        given(sectionMock.getDescription()).willReturn(description);
        given(sectionMock.getThumbnail()).willReturn(thumbnail);
        given(sectionMock.getParent()).willReturn(parentSectionMock);

        // When
        final SectionDTO result = SectionMapper.toDto(sectionMock);

        // Then
        Assertions.assertThat(result)
                .isNotNull()
                .satisfies(
                        r -> {
                            Assertions.assertThat(r.parent())
                                    .as("Parent should be present")
                                    .isNotNull();

                            Assertions.assertThat(r.name())
                                    .as("Names should be equal")
                                    .isEqualTo(name);

                            Assertions.assertThat(r.slug())
                                    .as("Slugs should be equal")
                                    .isEqualTo(slug);

                            Assertions.assertThat(r.description())
                                    .as("Descriptions should be equal")
                                    .isEqualTo(description);

                            Assertions.assertThat(r.thumbnail())
                                    .as("Thumbnails should be equal")
                                    .isEqualTo(thumbnail);
                        })
                .satisfies(
                        r -> {
                            final SectionDTO parent = r.parent();

                            Assertions.assertThat(parent.parent())
                                    .as("Parent of parent should be null")
                                    .isNull();

                            Assertions.assertThat(parent.name())
                                    .as("Parent names should be equal")
                                    .isEqualTo(parentName);

                            Assertions.assertThat(parent.slug())
                                    .as("Parent slugs should be equal")
                                    .isEqualTo(parentSlug);

                            Assertions.assertThat(parent.description())
                                    .as("Parent descriptions should be equal")
                                    .isEqualTo(parentDescription);

                            Assertions.assertThat(parent.thumbnail())
                                    .as("Parent thumbnails should be equal")
                                    .isEqualTo(parentThumbnail);
                        });
    }
}
