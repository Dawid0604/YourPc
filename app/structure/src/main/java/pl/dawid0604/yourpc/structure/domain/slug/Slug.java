/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.domain.slug;

import static lombok.AccessLevel.PRIVATE;
import static org.apache.commons.lang3.StringUtils.trimToNull;

import java.util.Locale;

import jakarta.annotation.Nullable;

import com.github.slugify.Slugify;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor(access = PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public final class Slug {
    private static final Slugify SLUGIFY =
            Slugify.builder().locale(Locale.forLanguageTag("pl")).build();

    @Getter @EqualsAndHashCode.Include private final String value;

    public static Slug of(final String slug) {
        Validator.requireValidSlug(slug);
        return new Slug(normalize(slug));
    }

    public static Slug fromName(final String name) {
        Validator.requireNotBlankName(name);

        final String normalizedName = normalize(name);
        return new Slug(SLUGIFY.slugify(normalizedName));
    }

    @Nullable private static String normalize(final String value) {
        return trimToNull(value);
    }
}
