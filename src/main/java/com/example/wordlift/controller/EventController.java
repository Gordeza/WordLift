package com.example.wordlift.controller;

import com.example.wordlift.model.Event;
import com.example.wordlift.model.EventRequestDTO;
import com.example.wordlift.model.FilterDTO;
import com.example.wordlift.service.EventService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;


    @GetMapping("")
    @Operation(summary = "list events based on filter", tags = {"events"})
    public Flux<Event> list(FilterDTO filterDTO) {
        return eventService.getEvents(filterDTO);
    }

    @GetMapping("/{id}")
    public Mono<Event> getById(@PathVariable Long id) {
        return eventService.findById(id);
    }

    @PostMapping("")
    @Operation(summary = "create event")
    public Mono<Event> create(@Valid @RequestBody EventRequestDTO e) {
        return eventService.saveEvent(e);
    }

}
