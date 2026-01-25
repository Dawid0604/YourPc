/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.domain.slug;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import net.datafaker.Faker;

@DisplayName("SlugGenerator tests")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SlugGeneratorTest {
    private static final Faker FAKER = new Faker();

    @RepeatedTest(20)
    void should_generate_successfully() {
        // Given
        final String name = FAKER.lorem().word();

        // When
        final String result = SlugGenerator.generate(name);

        // Then
        Assertions.assertThat(result).isNotNull().isNotBlank();
    }

    @ParameterizedTest
    @NullAndEmptySource
    void should_throw_exception_when_name_is_invalid(final String name) {
        // Given
        // When
        // Then
        Assertions.assertThatThrownBy(() -> SlugGenerator.generate(name))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
