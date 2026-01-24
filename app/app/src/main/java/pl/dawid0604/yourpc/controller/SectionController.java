/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.controller;

import static lombok.AccessLevel.PACKAGE;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import pl.dawid0604.yourpc.structure.adapter.in.dto.SectionDTO;
import pl.dawid0604.yourpc.structure.application.SectionFasade;

@Controller
@RequiredArgsConstructor(access = PACKAGE)
class SectionController {
    private final SectionFasade sectionFasade;

    @GetMapping("/")
    String index(final Model model) {
        final List<SectionDTO> sections = sectionFasade.findSections();

        model.addAttribute("sections", sections);
        return "index";
    }
}
