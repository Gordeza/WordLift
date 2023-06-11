package com.example.wordlift.service;

import com.example.wordlift.model.Event;
import com.example.wordlift.model.EventRequestDTO;
import com.example.wordlift.model.FilterDTO;
import com.example.wordlift.repository.EventRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.r2dbc.postgresql.codec.Json;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService{
    private final EventRepository eventRepository;
    private final ObjectMapper objectMapper;



    @Override
    public Mono<Event> saveEvent(Event e) {
        return eventRepository.save(e);
    }

    @Override
    public Mono<Event> saveEvent(EventRequestDTO e) {
        Event event = new Event(e);
        return eventRepository.save(event);
    }

    @Override
    public Flux<Event> getEvents(FilterDTO filterDTO) {
//        return null;
//        return eventRepository.findEventCustom(filterDTO.getUrl());
        return eventRepository.findEventsCustom(
                filterDTO.getUrl(),
                filterDTO.getDateGreaterThan(),
                filterDTO.getDateLessThan(),
                filterDTO.getCursor(),
                filterDTO.getLimit()
        );

//        List<String> urls = new ArrayList<>(filterDTO.getUrl());
//        if(urls.size() > 1) urls.replaceAll(s -> "'" + s + "'");
//
//        return eventRepository.findEventsByParameters(
//                urls.size() != 0 ? String.join(", ", urls) : "",
//                filterDTO.getDateGreaterThan(),
//                filterDTO.getDateLessThan(),
//                filterDTO.getCursor(),
//                filterDTO.getLimit()
//                );

    }

    @Override
    public Mono<Event> findById(Long id) {
        return eventRepository.findById(id);
    }
}
