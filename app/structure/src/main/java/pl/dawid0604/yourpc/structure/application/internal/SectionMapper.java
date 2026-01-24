/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.application.internal;

import static java.util.Collections.emptyList;

import java.util.List;
import java.util.Optional;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

import pl.dawid0604.yourpc.structure.adapter.in.dto.SectionDTO;
import pl.dawid0604.yourpc.structure.domain.section.Section;

final class SectionMapper {
    private SectionMapper() {}

    @Nullable static SectionDTO toDto(final Section section) {
        if (section == null) {
            return null;
        }

        return SectionDTO.builder()
                .name(section.getName())
                .parent(toDto(section.getParent()))
                .slug(section.getSlugValue())
                .description(section.getDescription())
                .thumbnail(section.getThumbnail())
                .build();
    }

    @Nonnull
    static List<SectionDTO> toDtoList(final List<Section> sections) {
        return Optional.ofNullable(sections).orElse(emptyList()).stream()
                .map(SectionMapper::toDto)
                .toList();
    }
}
