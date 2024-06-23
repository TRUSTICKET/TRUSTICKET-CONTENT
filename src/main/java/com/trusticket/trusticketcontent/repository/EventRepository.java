package com.trusticket.trusticketcontent.repository;


import com.trusticket.trusticketcontent.model.EventDocument;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface EventRepository extends ElasticsearchRepository<EventDocument, Long> {
    
    List<EventDocument> findByTitle(String title);

}

