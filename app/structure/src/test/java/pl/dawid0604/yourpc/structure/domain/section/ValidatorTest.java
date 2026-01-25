/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.domain.section;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import net.datafaker.Faker;

@DisplayName("Section/Validator tests")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ValidatorTest {
    private static final Faker FAKER = new Faker();

    @ParameterizedTest
    @CsvSource({"1,", ",1", ",", "2,5"})
    void should_validate_parent_successfully(final Long id, final Long parentId) {
        // Given
        // When
        // Then
        Assertions.assertThatCode(() -> Validator.requireValidParent(id, parentId))
                .doesNotThrowAnyException();
    }

    @Test
    void should_throw_exception_while_parent_validation_when_ids_are_same() {
        // Given
        final Long id = 2L;

        // When
        // Then
        Assertions.assertThatThrownBy(() -> Validator.requireValidParent(id, id))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @RepeatedTest(20)
    void should_validate_name_successfully() {
        // Given
        final String name = FAKER.lorem().word();

        // When
        // Then
        Assertions.assertThatCode(() -> Validator.requireNotBlankName(name))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @NullAndEmptySource
    void should_throw_exception_while_name_validation(final String name) {
        // Given
        // When
        // Then
        Assertions.assertThatThrownBy(() -> Validator.requireNotBlankName(name))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @RepeatedTest(20)
    void should_validate_positive_id_successfully_when_id_is_present() {
        // Given
        final long id = FAKER.number().positive();

        // When
        // Then
        Assertions.assertThatCode(() -> Validator.requirePositiveId(id)).doesNotThrowAnyException();
    }

    @Test
    void should_validate_positive_id_successfully_when_id_is_null() {
        // Given
        // When
        // Then
        Assertions.assertThatCode(() -> Validator.requirePositiveId(null))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(longs = {0, -1, -100})
    void should_throw_exception_while_id_validation(final Long id) {
        // Given
        // When
        // Then
        Assertions.assertThatThrownBy(() -> Validator.requirePositiveId(id))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
