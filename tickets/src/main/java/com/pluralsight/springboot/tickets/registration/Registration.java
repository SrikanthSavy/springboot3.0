package com.pluralsight.springboot.tickets.registration;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//People registration record
//ticketcode is the unique barcode id for ticket
public record Registration(
		Integer id,
		@NotNull(message ="ValidationERROR: ProductId is Required" ) Integer productId,
		String ticketCode,
		@NotBlank ( message= "Attendee Name Cannot be blanck") String attendeeName
		) {

}
