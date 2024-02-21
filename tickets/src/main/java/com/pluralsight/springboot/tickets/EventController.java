package com.pluralsight.springboot.tickets;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pluralsight.springboot.tickets.events.Event;
import com.pluralsight.springboot.tickets.events.Organizer;
import com.pluralsight.springboot.tickets.events.Product;
import com.pluralsight.springboot.tickets.repository.EventRepository;
import com.pluralsight.springboot.tickets.repository.OrganizerRepository;
import com.pluralsight.springboot.tickets.repository.ProductRepository;


@RestController
public class EventController {
	
	//Define all the 3 repository objects
	private final OrganizerRepository organizerRepository;
	private final EventRepository eventRepository;
	private final ProductRepository productRepository;
	
  // Defining parameter constructor
	public EventController(OrganizerRepository organizerRepository,
			EventRepository eventRepository,ProductRepository productRepository) {
		this.organizerRepository = organizerRepository;
		this.productRepository = productRepository;
		this.eventRepository = eventRepository;
	}
	
	//@RequestMapping(method=RequestMethod.GET, path="/organizers")	
	@GetMapping("/organizers")	
	public List<Organizer> getOrganizers()
	{// Get all the Organizer list
		return organizerRepository.findAll();
	}
	
	
	@GetMapping("/events")	
	public List<Event> getEventsByOrganizer(@RequestParam("organizerId") int organizerId)
	{//Get Event By OrganizerId   //http://.com/events?organizerId=101
		return eventRepository.findByOrganizerId(organizerId);
	}
	
	@GetMapping("events/{id}")
	public Event getEventById(@PathVariable("id") int eventId)
	{//Get Event By Id
		return eventRepository.findById(eventId)
				.orElseThrow(() -> new NoSuchElementException("Event with Id"+eventId+" not found"));
	}
	
	@GetMapping("/products")
	public List<Product> getProductsByEvent(@RequestParam("eventId") int eventId)
	{//GEt products tickets by EventId
		return productRepository.findByEventId(eventId);
	}
	
}
