/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.domain.slug;

import static org.apache.commons.lang3.StringUtils.isBlank;

import java.util.regex.Pattern;

final class Validator {
    private static final Pattern VALID_SLUG_PATTERN = Pattern.compile("^[a-z0-9-_]+$");

    private Validator() {}

    static void requireValidSlug(final String slug) {
        if (isBlank(slug) || !VALID_SLUG_PATTERN.matcher(slug).matches()) {
            throw new IllegalArgumentException(
                    "Invalid slug format: value=%s, expectedFormat=%s"
                            .formatted(slug, VALID_SLUG_PATTERN.pattern()));
        }
    }

    static void requireNotBlankName(final String name) {
        if (isBlank(name)) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
    }
}
