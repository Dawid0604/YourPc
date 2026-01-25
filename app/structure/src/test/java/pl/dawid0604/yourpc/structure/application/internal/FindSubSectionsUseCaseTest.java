/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.application.internal;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoInteractions;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import net.datafaker.Faker;
import pl.dawid0604.yourpc.structure.domain.port.SectionRepository;
import pl.dawid0604.yourpc.structure.domain.section.Section;
import pl.dawid0604.yourpc.structure.domain.slug.Slug;

@ExtendWith(MockitoExtension.class)
@DisplayName("FindSubSectionsUseCase tests")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class FindSubSectionsUseCaseTest {
    private static final Faker FAKER = new Faker();

    @Mock private SectionRepository sectionRepository;
    @InjectMocks private FindSubSectionsUseCase useCase;

    @RepeatedTest(20)
    void should_execute_successfully() {
        // Given
        final List<Section> foundSections = List.of(mock(Section.class), mock(Section.class));

        final String slugValue = FAKER.internet().slug();
        final Slug slug = mock(Slug.class);

        given(slug.getValue()).willReturn(slugValue);

        given(sectionRepository.findAll(slugValue)).willReturn(foundSections);

        // When
        final List<Section> result = useCase.execute(slug);

        // Then
        Assertions.assertThat(result).isNotNull().hasSize(foundSections.size());
    }

    @Test
    void should_throw_exception_when_slug_is_null() {
        // Given
        // When
        // Then
        Assertions.assertThatThrownBy(() -> useCase.execute(null))
                .isExactlyInstanceOf(NullPointerException.class);

        verifyNoInteractions(sectionRepository);
    }
}
