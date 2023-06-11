package com.example.wordlift.repository;

import com.example.wordlift.model.Event;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.List;

public interface EventCustomRepository {
    Flux<Event> findEventsCustom(List<String> url,
                               LocalDateTime dateGreaterThan,
                               LocalDateTime dateLessThan,
                               Long cursor,
                               Integer limit);
}
