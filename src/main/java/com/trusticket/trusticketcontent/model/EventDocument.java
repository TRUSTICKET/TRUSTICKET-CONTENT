package com.trusticket.trusticketcontent.model;

import com.trusticket.trusticketcontent.dto.EventRequest;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.time.LocalDateTime;

@Getter
@Document(indexName = "event")
@Setting(settingPath = "elasticsearch/setting/event-setting.json")
@AllArgsConstructor
@Builder
public class EventDocument {
    @Id
    @Field(type = FieldType.Keyword)
    private String id;

    @Field(type = FieldType.Text, analyzer = "korean")
    private String title; // 이벤트 제목

    @Field(type = FieldType.Text, analyzer = "korean")
    private String content; // 이벤트 내용

    @Field(type = FieldType.Text)
    private String schedule; // 이벤트 기간

    @Field(type = FieldType.Text)
    private String place; // 이벤트 장소

    @Field(type = FieldType.Text)
    private String mainImage; // 메인 이미지

    @Field(type = FieldType.Text)
    private String thumbnailImage; // 썸네일 이미지

    @Field(type = FieldType.Integer)
    private Integer price; // 가격

    @Field(type = FieldType.Integer)
    private Integer max_stock; // 판매 티켓량


    @Field(type = FieldType.Date, format = {DateFormat.date_hour_minute_second_millis, DateFormat.epoch_millis})
    private LocalDateTime startDate; // 예매 시작시간

    @Field(type = FieldType.Date, format = {DateFormat.date_hour_minute_second_millis, DateFormat.epoch_millis})
    private LocalDateTime endDate; // 예매 종료시간

    public static EventDocument parseReqeust(EventRequest request){
        return EventDocument.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .schedule(request.getSchedule())
                .place(request.getPlace())
                .mainImage(request.getMainImage())
                .thumbnailImage(request.getThumbnailImage())
                .price(request.getPrice())
                .max_stock(request.getMax_stock())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .build();
    }


}