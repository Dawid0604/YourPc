/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.application.internal;

import static java.util.Objects.requireNonNull;
import static lombok.AccessLevel.PACKAGE;

import java.util.List;

import jakarta.annotation.Nonnull;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import pl.dawid0604.yourpc.structure.adapter.in.dto.SectionDTO;
import pl.dawid0604.yourpc.structure.application.SectionFasade;
import pl.dawid0604.yourpc.structure.application.command.FindSubSectionsCommand;
import pl.dawid0604.yourpc.structure.domain.section.Section;

@Component
@RequiredArgsConstructor(access = PACKAGE)
class SectionFasadeImpl implements SectionFasade {
    private final FindSectionsUseCase findSectionsUseCase;
    private final FindSubSectionsUseCase findSubSectionsUseCase;

    @Nonnull
    @Override
    public List<SectionDTO> findSections() {
        final List<Section> sections = findSectionsUseCase.execute();
        return sections.stream().map(SectionMapper::toDto).toList();
    }

    @Nonnull
    @Override
    public List<SectionDTO> findSubSections(final FindSubSectionsCommand command) {
        requireNonNull(command, "Command cannot be null");

        final List<Section> sections = findSubSectionsUseCase.execute(command.slug());
        return sections.stream().map(SectionMapper::toDto).toList();
    }
}
