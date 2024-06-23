package com.trusticket.trusticketcontent.service;

import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.trusticket.trusticketcontent.dto.EventRequest;
import com.trusticket.trusticketcontent.dto.EventResponse;
import com.trusticket.trusticketcontent.model.EventDocument;
import com.trusticket.trusticketcontent.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    @Transactional
    public EventResponse saveEvent(EventRequest request) {
        EventDocument document = EventDocument.parseReqeust(request);
        document = eventRepository.save(document);
        EventResponse response = EventResponse.parseDocument(document);
        return response;
    }

    public List<EventResponse> searchEventsByTitle(String partialTitle) {
        List<EventDocument> documents = eventRepository.findByTitle(partialTitle);
        List<EventResponse> result = documents.stream().map(x -> EventResponse.parseDocument(x)).toList();
        return result;
    }
}