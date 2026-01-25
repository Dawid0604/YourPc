/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.adapter.out.persistence;

import static org.mockito.ArgumentMatchers.any;
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
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import net.datafaker.Faker;
import pl.dawid0604.yourpc.structure.domain.section.Section;

@ExtendWith(MockitoExtension.class)
@DisplayName("SectionRepositoryAdapter tests")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SectionRepositoryAdapterTest {
    private static final Faker FAKER = new Faker();

    @Mock private SectionEntityRepository repository;
    @InjectMocks private SectionRepositoryAdapter adapter;

    @Test
    void should_return_sections_by_slug() {
        // Given
        final String slug = FAKER.internet().slug();
        final List<SectionEntity> foundSections =
                List.of(mock(SectionEntity.class), mock(SectionEntity.class));

        given(repository.findAllByParentSlug(slug)).willReturn(foundSections);
        final List<Section> result;

        try (final MockedStatic<SectionEntityMapper> entityMapperMock =
                Mockito.mockStatic(SectionEntityMapper.class)) {

            entityMapperMock
                    .when(() -> SectionEntityMapper.toDomain(any()))
                    .thenReturn(mock(Section.class));

            // When
            result = adapter.findAll(slug);
        }

        // Then
        Assertions.assertThat(result).isNotNull().hasSize(foundSections.size());
    }

    @Test
    void should_return_sections() {
        // Given
        final List<SectionEntity> foundSections =
                List.of(mock(SectionEntity.class), mock(SectionEntity.class));

        given(repository.findAllWithNullableParent()).willReturn(foundSections);
        final List<Section> result;

        try (final MockedStatic<SectionEntityMapper> entityMapperMock =
                Mockito.mockStatic(SectionEntityMapper.class)) {

            entityMapperMock
                    .when(() -> SectionEntityMapper.toDomain(any()))
                    .thenReturn(mock(Section.class));

            // When
            result = adapter.findAll();
        }

        // Then
        Assertions.assertThat(result).isNotNull().hasSize(foundSections.size());
    }
}
