package com.example.java.epam.brayan.data.repositories;

import com.example.java.epam.brayan.data.entities.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
}
