/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.application.command;

import pl.dawid0604.yourpc.structure.domain.slug.Slug;

public record FindSubSectionsCommand(Slug slug) {

    public FindSubSectionsCommand {
        if (slug == null) {
            throw new IllegalArgumentException("Slug cannot be null or blank");
        }
    }
}
