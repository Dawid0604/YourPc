/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.adapter.in.dto;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Builder;
import pl.dawid0604.yourpc.structure.adapter.in.view.SectionResponseView;

@Builder
public record SectionDTO(
        @JsonView(SectionResponseView.Common.class) String slug,
        @JsonView(SectionResponseView.Common.class) String name,
        @JsonView(SectionResponseView.Common.class) String description,
        @JsonView(SectionResponseView.Common.class) String thumbnail,
        @JsonView(SectionResponseView.Details.class) SectionDTO parent,
        @JsonView(SectionResponseView.Common.class) long topicsCount,
        @JsonView(SectionResponseView.Common.class) long postsCount,
        @JsonView(SectionResponseView.Common.class) Object lastPost) {}
