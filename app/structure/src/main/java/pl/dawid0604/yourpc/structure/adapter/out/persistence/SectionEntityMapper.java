/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.adapter.out.persistence;

import jakarta.annotation.Nullable;

import pl.dawid0604.yourpc.structure.domain.section.Section;
import pl.dawid0604.yourpc.structure.domain.slug.Slug;

final class SectionEntityMapper {
    private SectionEntityMapper() {}

    @Nullable public static SectionEntity toEntity(final Section section) {
        if (section == null) {
            return null;
        }

        return SectionEntity.builder()
                .id(section.getId())
                .parent(toEntity(section.getParent()))
                .name(section.getName())
                .slug(section.getSlugValue())
                .description(section.getDescription())
                .thumbnail(section.getThumbnail())
                .build();
    }

    @Nullable public static Section toDomain(final SectionEntity entity) {
        if (entity == null) {
            return null;
        }

        return Section.builder()
                .id(entity.getId())
                .parent(toDomain(entity.getParent()))
                .name(entity.getName())
                .slug(Slug.of(entity.getSlug()))
                .description(entity.getDescription())
                .thumbnail(entity.getThumbnail())
                .build();
    }
}
