package com.trusticket.trusticketcontent.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
public class EventData {

    private String eventId;

    private Integer price;

    private Integer stock; // 판매 티켓량

    private Integer maxStock; // 판매 티켓량

    private String startDate; // 예매 시작시간

    private String endDate; // 예매 종료시간
}
