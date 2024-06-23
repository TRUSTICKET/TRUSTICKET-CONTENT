package com.trusticket.trusticketcontent.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest {

    @Schema(description = "이벤트 제목", example = "뉴진스 콘서트")
    @NotBlank(message = "이벤트 제목을 입력하세요")
    private String title; // 이벤트 제목

    @Schema(description = "이벤트 내용", example = "초대합니다")
    @NotBlank(message = "이벤트 내용을 입력하세요")
    private String content; // 이벤트 내용

    @Schema(description = "이벤트 기간 (소개용)", example = "7월 22일 금요일")
    @NotBlank(message = "이벤트 기간을 입력하세요")
    private String schedule; // 이벤트 기간

    @Schema(description = "이벤트 장소 ", example = "서울")
    @NotBlank(message = "이벤트 장소를 입력하세요")
    private String place; // 이벤트 장소

    @Schema(description = "메인 이미지 URL", example = "http://localhost:8080/image/1")
    private String mainImage; // 메인 이미지

    @Schema(description = "썸네일 이미지 URL", example = "http://localhost:8080/image/1")
    private String thumbnailImage; // 썸네일 이미지

    @Schema(description = "가격", example = "20000")
    @NotBlank(message = "가격을 입력하세요")
    private Integer price; // 가격

    @Schema(description = "티켓 판매량", example = "1000")
    @NotBlank(message = "티켓 판매량을 입력하세요")
    private Integer max_stock; // 판매 티켓량


    @Schema(description = "예매 시작시간", example = "2000-05-20 10:00")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @NotBlank(message = "예매 시작시간을 입력하세요")
    private LocalDateTime startDate; // 예매 시작시간

    @Schema(description = "예매 종료시간", example = "2000-05-20 11:00")
    @NotBlank(message = "예매 종료시간을 입력하세요")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime endDate; // 예매 종료시간
}
