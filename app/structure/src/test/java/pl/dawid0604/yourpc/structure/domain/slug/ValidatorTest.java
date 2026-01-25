/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.domain.slug;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import net.datafaker.Faker;

@DisplayName("Slug/Validator tests")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ValidatorTest {
    private static final Faker FAKER = new Faker();

    @RepeatedTest(20)
    void should_validate_successfully() {
        // Given
        final String slug = FAKER.internet().slug();

        // When
        // Then
        Assertions.assertThatCode(() -> Validator.requireValidSlug(slug))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(
            strings = {
                "Slug",
                "UPPERCASE",
                "slug with space",
                " slug",
                "slug.dot",
                "slug/slash",
                "slug@mail",
                "żółć",
                "slug\nline"
            })
    void should_throw_exception_while_validation_when_slug_is_invalid(final String slug) {
        // Given
        // When
        // Then
        Assertions.assertThatThrownBy(() -> Validator.requireValidSlug(slug))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void should_validate_name_successfully() {
        // Given
        final String name = FAKER.lorem().sentence();

        // When
        // Then
        Assertions.assertThatCode(() -> Validator.requireNotBlankName(name))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @NullAndEmptySource
    void should_throw_exception_when_name_is_blank(final String value) {
        // Given
        // When
        // Then
        Assertions.assertThatThrownBy(() -> Validator.requireNotBlankName(value))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
