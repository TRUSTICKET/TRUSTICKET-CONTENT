package com.trusticket.trusticketcontent.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageInfoResponse {

    @Schema(description = "총 데이터 수", example = "55")
    private long totalElements;

    @Schema(description = "총 페이지 수", example = "6")
    private long totalPages;

    @Schema(description = "다음 페이지 존재여부", example = "true")
    private Boolean haveNext;
}
