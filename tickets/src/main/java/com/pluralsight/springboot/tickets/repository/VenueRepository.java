package com.pluralsight.springboot.tickets.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.pluralsight.springboot.tickets.events.Venue;

@Repository
public class VenueRepository {

	private final List<Venue> venues = List.of(
			new Venue(201, "NFL Main Office", "Fremont", "SFO", "USA"),
			new Venue(202, "Cricket Main Office", "San Jose", "SFO", "USA")
			);
	
	public Optional<Venue> findById(int id){
		return venues.stream().filter(venue -> venue.id() ==id).findAny();
	}
	
}
