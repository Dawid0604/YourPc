/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.application.internal;

import static java.util.Objects.requireNonNull;
import static lombok.AccessLevel.PACKAGE;

import java.util.List;

import jakarta.annotation.Nonnull;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import pl.dawid0604.yourpc.structure.domain.port.SectionRepository;
import pl.dawid0604.yourpc.structure.domain.section.Section;
import pl.dawid0604.yourpc.structure.domain.slug.Slug;

@Component
@RequiredArgsConstructor(access = PACKAGE)
class FindSubSectionsUseCase {
    private final SectionRepository sectionRepository;

    @Nonnull
    List<Section> execute(final Slug slug) {
        requireNonNull(slug, "Slug cannot be null");
        return sectionRepository.findAll(slug.getValue());
    }
}
