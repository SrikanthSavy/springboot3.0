package com.pluralsight.springboot.tickets.events;

import java.math.BigDecimal;

//Type of TIckets Users can buy to attend the Event
public record Product(
		int id,
		int eventId,
		String name,
		String description,
		BigDecimal price		
		) {

}
