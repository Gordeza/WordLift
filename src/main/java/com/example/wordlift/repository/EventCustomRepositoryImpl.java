package com.example.wordlift.repository;

import com.example.wordlift.model.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class EventCustomRepositoryImpl implements EventCustomRepository {
    private final R2dbcEntityTemplate entityTemplate;

    public Flux<Event> findEventsCustom(List<String> url,
                               LocalDateTime dateGreaterThan,
                               LocalDateTime dateLessThan,
                               Long cursor,
                               Integer limit) {
        Criteria criteria = Criteria.empty();
        if(url != null && url.size() != 0) criteria = criteria.and("url").in(url);
        if(dateGreaterThan != null) criteria = criteria.and("recorded_at").greaterThan(dateGreaterThan);
        if(dateLessThan != null) criteria = criteria.and("recorded_at").lessThan(dateLessThan);
        if(cursor != null) criteria = criteria.and("id").greaterThanOrEquals(cursor);
        Query query = Query.query(criteria);
        if(limit != null) query = query.limit(limit);

        return entityTemplate.select(query, Event.class);
    }
}
