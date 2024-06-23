package com.trusticket.trusticketcontent.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Document(indexName = "content")

@Setting(settingPath = "config/elasticsearch/setting/content-setting.json")
@AllArgsConstructor
@Builder
public class ContentDocument{
    @Id
    @Field(type = FieldType.Keyword)
    private Long id;

    @Field(type = FieldType.Text)
    private String title; // 이벤트 제목

    @Field(type = FieldType.Text)
    private String contnet; // 이벤트 내용

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


}