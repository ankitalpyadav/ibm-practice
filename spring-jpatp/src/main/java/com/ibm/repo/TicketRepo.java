package com.ibm.repo;

import java.util.List;

import com.ibm.entity.Passenger;
import com.ibm.entity.Ticket;

public interface TicketRepo {
	
	int createTicket(Ticket t);
	int savePassenger(Passenger p, int pnr);
	
	boolean removeTicket(int pnr);
	boolean removePassenger(int pid);
	
	boolean updateTicket(Ticket t);
	boolean updatePassenger(Passenger p);
	
	List<Ticket> fetchAll();
	Ticket fetchByPnr(int pnr);
}
