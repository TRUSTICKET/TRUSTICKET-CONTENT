package com.trusticket.trusticketcontent.service;

import com.trusticket.trusticketcontent.common.ErrorDefineCode;
import com.trusticket.trusticketcontent.common.exception.custom.exception.NoSuchElementFoundException404;
import com.trusticket.trusticketcontent.common.kafka.KafkaProducer;
import com.trusticket.trusticketcontent.common.util.DatetimeUtil;
import com.trusticket.trusticketcontent.dto.*;
import com.trusticket.trusticketcontent.model.EventDocument;
import com.trusticket.trusticketcontent.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final KafkaProducer kafkaProducer;

    @Transactional
    public EventResponse saveEvent(EventRequest request) {
        EventDocument document = EventDocument.parseReqeust(request);

        document = eventRepository.save(document);
        kafkaProducer.sendEventData(
                "event-create",
                EventData.builder()
                        .maxStock(document.getMax_stock())
                        .stock(document.getMax_stock())
                        .eventId(document.getId())
                        .price(document.getPrice())
                        .startDate(DatetimeUtil.parseDatetimeToString(document.getStartDate()))
                        .endDate(DatetimeUtil.parseDatetimeToString(document.getEndDate()))
                        .build());
        EventResponse response = EventResponse.parseDocument(document);
        return response;
    }

    public List<EventResponse> searchEventsByTitle(String partialTitle) {
        List<EventDocument> documents = eventRepository.findByTitle(partialTitle);
        List<EventResponse> result = documents.stream().map(x -> EventResponse.parseDocument(x)).toList();
        return result;
    }

    @Cacheable(value = "eventsByTitle", key = "#partialTitle + ':' + #pageable.pageNumber + ':' + #pageable.pageSize")
    public EventListResponse searchEventsByTitleWithPage(String partialTitle, Pageable pageable) {
        Page<EventDocument> data = eventRepository.findByTitle(partialTitle, pageable);
        List<EventDocument> documents = data.getContent();

        PageInfoResponse pageInfo = PageInfoResponse.builder()
                .totalPages(data.getTotalPages())
                .totalElements(data.getTotalElements())
                .haveNext(data.hasNext())
                .build();

        List<EventResponse> list = documents.stream().map(x -> EventResponse.parseDocument(x)).toList();

        EventListResponse response = EventListResponse.builder()
                .pageInfo(pageInfo)
                .data(list)
                .build();

        return response;
    }

    public EventDetailResponse searchEventById(String id) {
        EventDocument document = eventRepository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementFoundException404(ErrorDefineCode.DUPLICATE_EXAMPLE_NAME));

        EventDetailResponse result = EventDetailResponse.parseDocument(document);
        return result;
    }
}