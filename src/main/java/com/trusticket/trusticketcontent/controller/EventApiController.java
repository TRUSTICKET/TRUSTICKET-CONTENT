package com.trusticket.trusticketcontent.controller;

import com.trusticket.trusticketcontent.common.response.CommonResponse;
import com.trusticket.trusticketcontent.dto.EventListResponse;
import com.trusticket.trusticketcontent.dto.EventRequest;
import com.trusticket.trusticketcontent.dto.EventResponse;
import com.trusticket.trusticketcontent.service.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/content")
@Tag(name = "CONTENT API")
@RequiredArgsConstructor
public class EventApiController {

    private final EventService eventService;

    @PostMapping("")
    @Operation(summary = "이벤트 데이터 추가")
    public CommonResponse<EventResponse> createContent(
            @RequestBody EventRequest contentDocument) {
        EventResponse result = eventService.saveEvent(contentDocument);
        return new CommonResponse(
                true, HttpStatus.OK, "등록이 완료되었습니다.", result
        );
    }

    @GetMapping("/title/{partialTitle}")
    @Operation(summary = "제목으로 이벤트 검색")
    public CommonResponse<EventListResponse> queryListByTitle(
            @PathVariable String partialTitle,
            @RequestParam int page,
            @RequestParam int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        EventListResponse result = eventService.searchEventsByTitleWithPage(partialTitle, pageable);
        return new CommonResponse(
                true, HttpStatus.OK, "조회가 완료되었습니다.", result
        );
    }

    @GetMapping("/{id}")
    @Operation(summary = "ID로 이벤트 검색")
    public CommonResponse<EventResponse> queryOneById(
            @PathVariable String id
    ) {
        EventResponse result = eventService.searchEventById(id);
        return new CommonResponse(
                true, HttpStatus.OK, "조회가 완료되었습니다.", result
        );
    }
}