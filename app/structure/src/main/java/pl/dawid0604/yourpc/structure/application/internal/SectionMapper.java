/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.application.internal;

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
                .slug(section.getSlug())
                .description(section.getDescription())
                .thumbnail(section.getThumbnail())
                .build();
    }
}
