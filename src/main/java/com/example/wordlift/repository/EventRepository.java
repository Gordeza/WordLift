package com.example.wordlift.repository;

import com.example.wordlift.model.Event;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends ReactiveCrudRepository<Event, Long>, EventCustomRepository { }
