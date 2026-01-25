/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.domain.section;

import static lombok.AccessLevel.NONE;
import static org.apache.commons.lang3.StringUtils.trimToNull;

import lombok.Builder;
import lombok.Getter;
import pl.dawid0604.yourpc.structure.domain.slug.Slug;

@Getter
@Builder(toBuilder = true)
public final class Section {
    private final Long id;
    private Section parent;
    private String name;
    private String description;
    private String thumbnail;

    @Getter(NONE)
    private Slug slug;

    @Builder
    private Section(
            final Long id,
            final Section parent,
            final String name,
            final String description,
            final String thumbnail,
            final Slug slug) {

        Validator.requirePositiveId(id);
        Validator.requireNotBlankName(name);

        if (parent != null) {
            Validator.requireValidParent(id, parent.id);
        }

        this.id = id;
        this.parent = parent;
        this.name = trimToNull(name);
        this.thumbnail = trimToNull(thumbnail);
        this.description = trimToNull(description);
        this.slug = slug;
    }

    public String getSlug() {
        return slug.getValue();
    }
}
