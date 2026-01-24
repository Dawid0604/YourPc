/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.application.internal;

import static java.util.Objects.requireNonNull;
import static lombok.AccessLevel.PACKAGE;

import java.util.List;

import jakarta.annotation.Nonnull;

import lombok.RequiredArgsConstructor;
import pl.dawid0604.yourpc.structure.adapter.config.Fasade;
import pl.dawid0604.yourpc.structure.adapter.in.dto.SectionDTO;
import pl.dawid0604.yourpc.structure.application.SectionFasade;
import pl.dawid0604.yourpc.structure.application.command.FindSubSectionsCommand;
import pl.dawid0604.yourpc.structure.domain.section.Section;

@Fasade
@RequiredArgsConstructor(access = PACKAGE)
class SectionFasadeImpl implements SectionFasade {
    private final FindSectionsUseCase findSectionsUseCase;

    @Nonnull
    @Override
    public List<SectionDTO> findSections() {
        final List<Section> sections = findSectionsUseCase.execute();
        return SectionMapper.toDtoList(sections);
    }

    @Nonnull
    @Override
    public List<SectionDTO> findSubSections(final FindSubSectionsCommand command) {
        requireNonNull(command, "Command cannot be null");

        final List<Section> sections = findSectionsUseCase.execute(command.parentSlug());
        return SectionMapper.toDtoList(sections);
    }
}
