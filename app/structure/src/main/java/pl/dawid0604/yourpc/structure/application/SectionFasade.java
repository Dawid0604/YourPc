/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.application;

import java.util.List;

import pl.dawid0604.yourpc.structure.adapter.in.dto.SectionDTO;
import pl.dawid0604.yourpc.structure.application.command.FindSubSectionsCommand;

public interface SectionFasade {

    List<SectionDTO> findSections();

    List<SectionDTO> findSubSections(FindSubSectionsCommand command);
}
