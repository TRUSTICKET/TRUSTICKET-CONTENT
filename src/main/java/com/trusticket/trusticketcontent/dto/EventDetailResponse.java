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
public class EventDetailResponse {

    @Schema(description = "이벤트 ID", example = "1234")
    private String id; // 이벤트 ID

    @Schema(description = "이벤트 제목", example = "뉴진스 콘서트")
    private String title; // 이벤트 제목

    @Schema(description = "이벤트 내용", example = "초대합니다")
    private String content; // 이벤트 내용

    @Schema(description = "이벤트 기간 (소개용)", example = "7월 22일 금요일")
    private String schedule; // 이벤트 기간

    @Schema(description = "이벤트 장소 ", example = "서울")
    private String place; // 이벤트 장소

    @Schema(description = "메인 이미지 URL", example = "http://localhost:8080/image/1")
    private String mainImage; // 메인 이미지

    @Schema(description = "썸네일 이미지 URL", example = "http://localhost:8080/image/1")
    private String thumbnailImage; // 썸네일 이미지

    @Schema(description = "가격", example = "20000")
    private Integer price; // 가격

    @Schema(description = "티켓 판매량", example = "1000")
    private Integer max_stock; // 판매 티켓량

    @Schema(description = "예매 시작시간", example = "2000-05-20 10:00")
    private LocalDateTime startDate; // 예매 시작시간

    @Schema(description = "예매 종료시간", example = "2000-05-20 11:00")
    private LocalDateTime endDate; // 예매 종료시간

    public static EventDetailResponse parseDocument(EventDocument doc){
        return EventDetailResponse.builder()
                .id(doc.getId())
                .title(doc.getTitle())
                .content(doc.getContent())
                .schedule(doc.getSchedule())
                .place(doc.getPlace())
                .mainImage(doc.getMainImage())
                .thumbnailImage(doc.getThumbnailImage())
                .price(doc.getPrice())
                .max_stock(doc.getMax_stock())
                .startDate(doc.getStartDate())
                .endDate(doc.getEndDate())
                .build();
    }
}
