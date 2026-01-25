/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.domain.slug;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.commons.lang3.StringUtils.trimToNull;
import static org.mockito.ArgumentMatchers.anyString;

import java.util.Objects;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import net.datafaker.Faker;

@DisplayName("Slug tests")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SlugTest {
    private static final Faker FAKER = new Faker();

    @RepeatedTest(20)
    void should_create_successfully_with_slug() {
        // Given
        final String slug = FAKER.internet().slug();

        try (final MockedStatic<Validator> validatorMock = Mockito.mockStatic(Validator.class)) {
            validatorMock
                    .when(() -> Validator.requireValidSlug(anyString()))
                    .thenAnswer(inv -> inv);

            // When
            final Slug result = Slug.of(slug);

            // Then
            Assertions.assertThat(result)
                    .isNotNull()
                    .matches(s -> isNotBlank(s.getValue()))
                    .matches(s -> Objects.equals(s.getValue(), slug));
        }
    }

    @Test
    void should_create_successfully_from_slug_and_normalize() {
        // Given
        final String slug = " anySlug_xyz  ";
        final String trimmedSlug = trimToNull(slug);

        try (final MockedStatic<Validator> validatorMock = Mockito.mockStatic(Validator.class)) {
            validatorMock
                    .when(() -> Validator.requireValidSlug(anyString()))
                    .thenAnswer(inv -> inv);

            // When
            final Slug result = Slug.of(slug);

            // Then
            Assertions.assertThat(result)
                    .isNotNull()
                    .matches(s -> isNotBlank(s.getValue()))
                    .matches(s -> Objects.equals(s.getValue(), trimmedSlug));
        }
    }

    @Test
    void should_throw_exception_from_slug_when_slug_is_invalid() {
        // Given
        try (final MockedStatic<Validator> validatorMock = Mockito.mockStatic(Validator.class)) {
            validatorMock
                    .when(() -> Validator.requireValidSlug(anyString()))
                    .thenThrow(IllegalArgumentException.class);

            // When
            // Then
            Assertions.assertThatThrownBy(() -> Slug.of(EMPTY))
                    .isExactlyInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void should_create_successfully_from_name_slug_and_normalize() {
        // Given
        final String name = " anyName ";
        final String trimmedName = trimToNull(name);
        final String generatedSlug = FAKER.internet().slug();

        try (final MockedStatic<Validator> validatorMock = Mockito.mockStatic(Validator.class);
                final MockedStatic<SlugGenerator> slugGeneratorMock =
                        Mockito.mockStatic(SlugGenerator.class)) {

            validatorMock
                    .when(() -> Validator.requireNotBlankName(anyString()))
                    .thenAnswer(inv -> inv);

            slugGeneratorMock
                    .when(() -> SlugGenerator.generate(trimmedName))
                    .thenReturn(generatedSlug);

            // When
            final Slug result = Slug.fromName(name);

            // Then
            Assertions.assertThat(result).isNotNull().matches(s -> isNotBlank(s.getValue()));
        }
    }
}
