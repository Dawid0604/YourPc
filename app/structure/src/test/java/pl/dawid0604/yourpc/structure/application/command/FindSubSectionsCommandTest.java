/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.application.command;

import static org.mockito.Mockito.mock;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import pl.dawid0604.yourpc.structure.domain.slug.Slug;

@ExtendWith(MockitoExtension.class)
@DisplayName("FindSubSectionsCommand tests")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class FindSubSectionsCommandTest {

    @Test
    void should_throw_exception_when_parentSlug_is_invalid() {
        // Given
        // When
        // Then
        Assertions.assertThatThrownBy(() -> new FindSubSectionsCommand(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @RepeatedTest(20)
    void should_create_successfully() {
        // Given
        final Slug slug = mock(Slug.class);

        // When
        final FindSubSectionsCommand command = new FindSubSectionsCommand(slug);

        // Then
        Assertions.assertThat(command).isNotNull();
    }
}
