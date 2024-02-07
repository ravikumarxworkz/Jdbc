package com.xworkz.ticketbooking.runner;

import com.xworkz.tickerBook.constants.ConnectionData;
import com.xworkz.tickerBook.dto.TicketBookDto;
import com.xworkz.tickerBook.service.TicketBookService;
import com.xworkz.tickerBook.service.TicketBookServiceImpl;

public class Ticket {

	public static void main(String[] args) {

		ConnectionData.URL.setData("jdbc:mysql://localhost:3306/ticket");
		ConnectionData.USERNAME.setData("root");
		ConnectionData.PASSWORD.setData("123456789");

		TicketBookService service = new TicketBookServiceImpl();

		TicketBookDto dto = new TicketBookDto("ramya p", "rampya@gmail.com", 500, "bengalurur", "davangere");

		service.validateSave(dto);
	}

}
