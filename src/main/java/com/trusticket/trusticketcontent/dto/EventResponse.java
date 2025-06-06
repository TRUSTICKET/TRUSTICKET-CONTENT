package com.trusticket.trusticketcontent.dto;

import com.trusticket.trusticketcontent.model.EventDocument;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventResponse {

    @Schema(description = "이벤트 ID", example = "1234")
    private String id; // 이벤트 ID

    @Schema(description = "이벤트 제목", example = "뉴진스 콘서트")
    private String title; // 이벤트 제목

    @Schema(description = "이벤트 기간 (소개용)", example = "7월 22일 금요일")
    private String schedule; // 이벤트 기간

    @Schema(description = "이벤트 장소 ", example = "서울")
    private String place; // 이벤트 장소

    @Schema(description = "썸네일 이미지 URL", example = "http://localhost:8080/image/1")
    private String thumbnailImage; // 썸네일 이미지

    @Schema(description = "예매 시작시간", example = "2000-05-20 10:00")
    private LocalDateTime startDate; // 예매 시작시간

    @Schema(description = "예매 종료시간", example = "2000-05-20 11:00")
    private LocalDateTime endDate; // 예매 종료시간

    public static EventResponse parseDocument(EventDocument doc){
        return EventResponse.builder()
                .id(doc.getId())
                .title(doc.getTitle())
                .schedule(doc.getSchedule())
                .place(doc.getPlace())
                .thumbnailImage(doc.getThumbnailImage())
                .startDate(doc.getStartDate())
                .endDate(doc.getEndDate())
                .build();
    }
}
