/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.application.internal;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import pl.dawid0604.yourpc.structure.domain.port.SectionRepository;
import pl.dawid0604.yourpc.structure.domain.section.Section;

@ExtendWith(MockitoExtension.class)
@DisplayName("FindSectionsUseCase tests")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class FindSectionsUseCaseTest {

    @Mock private SectionRepository sectionRepository;
    @InjectMocks private FindSectionsUseCase useCase;

    @Test
    void should_execute_successfully() {
        // Given
        final List<Section> foundSections = List.of(mock(Section.class), mock(Section.class));

        given(sectionRepository.findAll()).willReturn(foundSections);

        // When
        final List<Section> result = useCase.execute();

        // Then
        Assertions.assertThat(result).isNotNull().hasSize(foundSections.size());
    }
}
