package com.trusticket.trusticketcontent.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class EventListResponse {
    @Schema(description = "조회 데이터")
    private List<EventResponse> data;

    @Schema(description = "페이지 정보 데이터")
    private PageInfoResponse pageInfo;
}
