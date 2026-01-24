/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.application.internal;

import static lombok.AccessLevel.PACKAGE;

import java.util.List;

import jakarta.annotation.Nonnull;

import lombok.RequiredArgsConstructor;
import pl.dawid0604.yourpc.structure.adapter.config.UseCase;
import pl.dawid0604.yourpc.structure.domain.port.SectionRepository;
import pl.dawid0604.yourpc.structure.domain.section.Section;
import pl.dawid0604.yourpc.structure.domain.slug.Slug;

@UseCase
@RequiredArgsConstructor(access = PACKAGE)
class FindSectionsUseCase {
    private final SectionRepository sectionRepository;

    @Nonnull
    List<Section> execute(final String parentSlug) {
        final Slug slug = Slug.of(parentSlug);
        return sectionRepository.findAll(slug.getValue());
    }

    @Nonnull
    List<Section> execute() {
        return sectionRepository.findAll();
    }
}
