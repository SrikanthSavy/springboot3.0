package com.pluralsight.springboot.tickets.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pluralsight.springboot.tickets.events.Organizer;

//Inherits @Component annotation

@Repository
public class OrganizerRepository {

	private final List<Organizer> organizers = List.of(
			new Organizer(101, "NFL", "National FoodBall Legue"),
			new Organizer(102, "CPL", "Cricket Premier Legue")			
			);
	
	
	public List<Organizer> findAll()
	{
		return organizers;
	}
			
}
