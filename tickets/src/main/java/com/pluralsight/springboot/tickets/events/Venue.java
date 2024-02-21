package com.pluralsight.springboot.tickets.events;

// Events are help at a place, Lets create a Venue address

public record Venue(
		int id,
		String name,
		String street,
		String city,
		String country		
		) {

}
