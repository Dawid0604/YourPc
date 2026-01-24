/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.adapter.out.persistence;

import static lombok.AccessLevel.PACKAGE;

import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import pl.dawid0604.yourpc.structure.domain.port.SectionRepository;
import pl.dawid0604.yourpc.structure.domain.section.Section;

@Component
@RequiredArgsConstructor(access = PACKAGE)
class SectionRepositoryAdapter implements SectionRepository {
    private final SectionEntityRepository repository;

    @Nonnull
    @Override
    public List<Section> findAll(@Nullable final String slug) {
        return repository.findAllByParentSlug(slug).stream()
                .map(SectionEntityMapper::toDomain)
                .toList();
    }

    @Nonnull
    @Override
    public List<Section> findAll() {
        return repository.findAllWithNullableParent().stream()
                .map(SectionEntityMapper::toDomain)
                .toList();
    }
}
