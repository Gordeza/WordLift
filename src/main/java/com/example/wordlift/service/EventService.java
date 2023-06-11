package com.example.wordlift.service;

import com.example.wordlift.model.Event;
import com.example.wordlift.model.EventRequestDTO;
import com.example.wordlift.model.FilterDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EventService {
    Mono<Event> saveEvent(Event e);
    Mono<Event> saveEvent(EventRequestDTO e);

    Flux<Event> getEvents(FilterDTO filterDTO);

    Mono<Event> findById(Long id);
}
