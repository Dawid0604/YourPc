SET search_path TO yourpc_schema;

CREATE TABLE sections(
    id BIGSERIAL PRIMARY KEY,
    parent_id BIGINT,
    name VARCHAR(256) NOT NULL,
    slug VARCHAR(256) NOT NULL,
    description VARCHAR(1024),
    thumbnail VARCHAR(512),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT uk_sections_slug_name UNIQUE (slug, name),

    CONSTRAINT fk_sections_parent
    FOREIGN KEY (parent_id)
    REFERENCES sections(id)
    ON DELETE SET NULL
);

CREATE INDEX idx_sections_parent_id ON sections(parent_id);
CREATE INDEX idx_sections_name ON sections(name);

COMMENT ON TABLE sections IS 'Hierarchiczna struktura sekcji';
COMMENT ON COLUMN sections.parent_id IS 'Odniesienie do sekcji nadrzędnej (self-referencing)';
COMMENT ON COLUMN sections.slug IS 'Unikalny identyfikator tekstowy używany w URL';