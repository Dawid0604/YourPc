/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.domain.section;

import static org.apache.commons.lang3.StringUtils.trimToNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;

import java.util.Objects;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import net.datafaker.Faker;
import pl.dawid0604.yourpc.structure.domain.slug.Slug;

@ExtendWith(MockitoExtension.class)
@DisplayName("Section tests")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SectionTest {
    private static final Faker FAKER = new Faker();

    @Test
    void should_assign_values_properly() {
        // Given
        final Long id = (long) FAKER.number().positive();
        final Section mockParent = mock(Section.class);
        final String name = FAKER.name().name();
        final String description = FAKER.lorem().sentence();
        final String thumbnail = FAKER.internet().image();
        final Slug mockSlug = mock(Slug.class);

        try (final MockedStatic<Validator> validatorMock = Mockito.mockStatic(Validator.class)) {
            validatorMock.when(() -> Validator.requirePositiveId(anyLong())).thenAnswer(inv -> inv);

            validatorMock
                    .when(() -> Validator.requireNotBlankName(anyString()))
                    .thenAnswer(inv -> inv);

            validatorMock
                    .when(() -> Validator.requireValidParent(anyLong(), anyLong()))
                    .thenAnswer(inv -> inv);

            // When
            final Section result =
                    Section.builder()
                            .id(id)
                            .parent(mockParent)
                            .name(name)
                            .description(description)
                            .thumbnail(thumbnail)
                            .slug(mockSlug)
                            .build();

            // Then
            Assertions.assertThat(result)
                    .isNotNull()
                    .matches(r -> Objects.equals(r.getId(), id), "Id should be same")
                    .matches(
                            r -> Objects.equals(r.getParent(), mockParent),
                            "Parents should be same")
                    .matches(r -> Objects.equals(r.getName(), name), "Names should be same")
                    .matches(
                            r -> Objects.equals(r.getDescription(), description),
                            "Descriptions should be same")
                    .matches(
                            r -> Objects.equals(r.getThumbnail(), thumbnail),
                            "Thumbnails should be same")
                    .matches(
                            r -> Objects.equals(r.getSlug(), mockSlug.getValue()),
                            "Slugs should be same");
        }
    }

    @Test
    void should_trim_values_properly() {
        // Given
        final Long id = (long) FAKER.number().positive();
        final Section mockParent = mock(Section.class);

        final String name = FAKER.name().name() + "  ";
        final String trimmedName = trimToNull(name);

        final String description = "  " + FAKER.lorem().sentence();
        final String trimmedDescription = trimToNull(description);

        final String thumbnail = FAKER.internet().image() + " ";
        final String trimmedThumbnail = trimToNull(thumbnail);

        final Slug mockSlug = mock(Slug.class);

        try (final MockedStatic<Validator> validatorMock = Mockito.mockStatic(Validator.class)) {
            validatorMock.when(() -> Validator.requirePositiveId(anyLong())).thenAnswer(inv -> inv);

            validatorMock
                    .when(() -> Validator.requireNotBlankName(anyString()))
                    .thenAnswer(inv -> inv);

            validatorMock
                    .when(() -> Validator.requireValidParent(anyLong(), anyLong()))
                    .thenAnswer(inv -> inv);

            // When
            final Section result =
                    Section.builder()
                            .id(id)
                            .parent(mockParent)
                            .name(name)
                            .description(description)
                            .thumbnail(thumbnail)
                            .slug(mockSlug)
                            .build();

            // Then
            Assertions.assertThat(result)
                    .isNotNull()
                    .matches(r -> Objects.equals(r.getId(), id), "Id should be same")
                    .matches(
                            r -> Objects.equals(r.getParent(), mockParent),
                            "Parents should be same")
                    .matches(r -> Objects.equals(r.getName(), trimmedName), "Names should be same")
                    .matches(
                            r -> Objects.equals(r.getDescription(), trimmedDescription),
                            "Descriptions should be same")
                    .matches(
                            r -> Objects.equals(r.getThumbnail(), trimmedThumbnail),
                            "Thumbnails should be same")
                    .matches(
                            r -> Objects.equals(r.getSlug(), mockSlug.getValue()),
                            "Slugs should be same");
        }
    }

    @Test
    void should_validate_parent() {
        // Given
        final Long id = (long) FAKER.number().positive();
        final Section mockParent = mock(Section.class);
        final String name = FAKER.name().name();
        final String description = FAKER.lorem().sentence();
        final String thumbnail = FAKER.internet().image();
        final Slug slug = mock(Slug.class);

        try (final MockedStatic<Validator> validatorMock = Mockito.mockStatic(Validator.class)) {
            validatorMock.when(() -> Validator.requirePositiveId(anyLong())).thenAnswer(inv -> inv);

            validatorMock
                    .when(() -> Validator.requireNotBlankName(anyString()))
                    .thenAnswer(inv -> inv);

            validatorMock
                    .when(() -> Validator.requireValidParent(anyLong(), anyLong()))
                    .thenAnswer(inv -> inv);

            // When
            final Section result =
                    Section.builder()
                            .id(id)
                            .parent(mockParent)
                            .name(name)
                            .description(description)
                            .thumbnail(thumbnail)
                            .slug(slug)
                            .build();

            // Then
            Assertions.assertThat(result).isNotNull();
        }
    }

    @Test
    void should_not_validate_parent() {
        // Given
        final Long id = (long) FAKER.number().positive();
        final String name = FAKER.name().name();
        final String description = FAKER.lorem().sentence();
        final String thumbnail = FAKER.internet().image();
        final Slug slug = mock(Slug.class);

        try (final MockedStatic<Validator> validatorMock = Mockito.mockStatic(Validator.class)) {
            validatorMock.when(() -> Validator.requirePositiveId(anyLong())).thenAnswer(inv -> inv);

            validatorMock
                    .when(() -> Validator.requireNotBlankName(anyString()))
                    .thenAnswer(inv -> inv);

            validatorMock.verify(() -> Validator.requireValidParent(anyLong(), anyLong()), never());

            // When
            final Section result =
                    Section.builder()
                            .id(id)
                            .name(name)
                            .description(description)
                            .thumbnail(thumbnail)
                            .slug(slug)
                            .build();

            // Then
            Assertions.assertThat(result).isNotNull();
        }
    }
}
