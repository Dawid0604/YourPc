/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.domain.slug;

import java.util.Locale;

import com.github.slugify.Slugify;

final class SlugGenerator {
    private static final Slugify SLUGIFY =
            Slugify.builder().locale(Locale.forLanguageTag("pl")).build();

    private SlugGenerator() {}

    static String generate(final String name) {
        Validator.requireNotBlankName(name);
        return SLUGIFY.slugify(name);
    }
}
