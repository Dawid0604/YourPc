/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.domain.section;

import static org.apache.commons.lang3.StringUtils.isBlank;

final class Validator {
    private Validator() {}

    static void requireValidParent(final Long id, final Long parentId) {
        if (parentId == null) {
            return;
        }

        final boolean isSame = id != null && id.equals(parentId);

        if (isSame) {
            throw new IllegalArgumentException("Section cannot be its own parent");
        }
    }

    static void requireNotBlankName(final String name) {
        if (isBlank(name)) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
    }

    static void requirePositiveId(final Long id) {
        if (id != null && id < 1) {
            throw new IllegalArgumentException("Id cannot must be positive");
        }
    }
}
