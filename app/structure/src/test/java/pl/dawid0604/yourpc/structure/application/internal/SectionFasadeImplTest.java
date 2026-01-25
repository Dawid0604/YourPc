/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.application.internal;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import pl.dawid0604.yourpc.structure.adapter.in.dto.SectionDTO;
import pl.dawid0604.yourpc.structure.application.command.FindSubSectionsCommand;
import pl.dawid0604.yourpc.structure.domain.slug.Slug;

@ExtendWith(MockitoExtension.class)
@DisplayName("SectionFasadeImpl tests")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SectionFasadeImplTest {
    @Mock private FindSectionsUseCase findSectionsUseCase;
    @Mock private FindSubSectionsUseCase findSubSectionsUseCase;
    @InjectMocks private SectionFasadeImpl sectionFasade;

    @Nested
    @DisplayName("findSections() tests")
    class FindSectionsTests {

        @Test
        void should_find_successfully() {
            // Given
            // When
            final List<SectionDTO> result = sectionFasade.findSections();

            // Then
            verify(findSectionsUseCase).execute();
            verifyNoInteractions(findSubSectionsUseCase);
            Assertions.assertThat(result).isNotNull().isEmpty();
        }
    }

    @Nested
    @DisplayName("findSubSections() tests")
    class FindSubSectionsTests {

        @Test
        void should_find_successfully() {
            // Given
            final FindSubSectionsCommand commandMock = mock(FindSubSectionsCommand.class);
            final Slug slugMock = mock(Slug.class);

            given(commandMock.slug()).willReturn(slugMock);

            // When
            final List<SectionDTO> result = sectionFasade.findSubSections(commandMock);

            // Then
            verifyNoInteractions(findSectionsUseCase);
            verify(findSubSectionsUseCase).execute(slugMock);
            Assertions.assertThat(result).isNotNull().isEmpty();
        }

        @Test
        void should_throw_exception_when_command_is_null() {
            // Given
            // When
            // Then
            Assertions.assertThatThrownBy(() -> sectionFasade.findSubSections(null))
                    .isExactlyInstanceOf(NullPointerException.class);

            verifyNoInteractions(findSectionsUseCase, findSubSectionsUseCase);
        }
    }
}
