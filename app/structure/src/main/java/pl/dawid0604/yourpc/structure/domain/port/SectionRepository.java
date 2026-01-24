/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.domain.port;

import java.util.List;

import pl.dawid0604.yourpc.structure.domain.section.Section;

public interface SectionRepository {

    List<Section> findAll(String parentSlug);

    List<Section> findAll();
}
