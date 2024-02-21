package com.pluralsight.springboot.tickets.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.pluralsight.springboot.tickets.events.Event;
import com.pluralsight.springboot.tickets.events.Organizer;
import com.pluralsight.springboot.tickets.events.Venue;

@Repository
public class EventRepository {

	 private final List<Event> events = List.of(
	            new Event(501, "NFL Tech Conference",
	                    new Organizer(101, "NFL", "National Foodball League"),
	                    new Venue(201, "NFL Main Office", "Fremont", "SFO", "USA"),
	                    LocalDate.of(2023, 10, 2), LocalDate.of(2023, 10, 4)),
	            new Event(502, "NFL Developer Day",
	                    new Organizer(101, "NFL", "NFL Technology Corporation"),
	                    new Venue(201, "NFL Main Office", "Fremont", "SFO", "USA"),
	                    LocalDate.of(2024, 1, 10), LocalDate.of(2024, 1, 10)),
	            new Event(503, "Carved Rock New Products Day",
	                    new Organizer(102, "Carved Rock", "Carved Rock Sports Equipment"),
	                    new Venue(202, "Sea View Hotel", "Beach Boulevard 863", "Los Angeles", "USA"),
	                    LocalDate.of(2024, 2, 29), LocalDate.of(2024, 2, 29)));

	    public List<Event> findByOrganizerId(int organizerId) {
	        return events.stream().filter(event -> event.organizer().id() == organizerId).toList();
	    }

	    public Optional<Event> findById(int id) {
	        return events.stream().filter(event -> event.id() == id).findAny();
	    }
	
}