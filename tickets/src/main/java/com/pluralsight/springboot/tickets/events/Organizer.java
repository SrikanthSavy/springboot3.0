package com.pluralsight.springboot.tickets.events;

/* records are concise way of create immutable class
 * new java concept
 */


//Organizer who is conducting an Event
public record Organizer(
		int id,
		String name,
		String description){
	
	//Empty record	
}
