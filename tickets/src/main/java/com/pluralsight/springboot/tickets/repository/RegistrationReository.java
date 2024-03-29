package com.pluralsight.springboot.tickets.repository;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.pluralsight.springboot.tickets.registration.Registration;

@Repository
public class RegistrationReository {

	//used for generating Id
	private static final AtomicInteger ID_GENERATOR = new AtomicInteger();
	
	private final Map<String, Registration> registrationByTicketCode = new ConcurrentHashMap<>();
	
	
	public Registration createRegistration(Registration registration)
	{//create a Registration entry
		
		int id = ID_GENERATOR.incrementAndGet();
		String ticketCode= UUID.randomUUID().toString();
		
		var saved = new Registration(id, registration.productId(), ticketCode, registration.attendeeName());
		//moving it to above Map
		registrationByTicketCode.put(ticketCode, saved);
		
		return saved;		
	}
	
	
	
	public Optional<Registration> findByTicketCode(String ticketCode)
	{//get registration By TicketCode
		
		return Optional.ofNullable(registrationByTicketCode.get(ticketCode));
	}
	
	
	public Registration updateRegistration(Registration  registration)
	{//Update a Registration entry
		
		String ticketCode = registration.ticketCode();
		
		var opt = findByTicketCode(ticketCode);
		
		if(opt.isPresent())
		{
			var existing = opt.get();
			var saved = new Registration(existing.id(), existing.productId(), existing.ticketCode(), registration.attendeeName());
			//storing it in MaP
			registrationByTicketCode.put(ticketCode, saved);
			return saved;
			
		}else {
			throw new NoSuchElementException("Registration with ticket coe " +ticketCode+" Not found ");
		}
	}
	
	public void deleteByTicketCode(String ticketCode)
	{//Delete a registrationByticketCode
		
		registrationByTicketCode.remove(ticketCode);
	}
	
}
