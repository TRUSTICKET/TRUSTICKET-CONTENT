package com.trusticket.trusticketcontent.repository;


import com.trusticket.trusticketcontent.model.EventDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface EventRepository extends ElasticsearchRepository<EventDocument, String> {

    List<EventDocument> findByTitle(String title);

    Page<EventDocument> findByTitle(String title, Pageable pageable);

}

