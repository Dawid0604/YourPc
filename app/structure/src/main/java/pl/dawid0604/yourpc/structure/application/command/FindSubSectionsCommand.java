/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.application.command;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record FindSubSectionsCommand(String parentSlug) {

    public FindSubSectionsCommand {
        if (isBlank(parentSlug)) {
            throw new IllegalArgumentException("ParentSlug cannot be null or blank");
        }
    }
}
