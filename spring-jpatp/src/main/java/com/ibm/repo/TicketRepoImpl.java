package com.ibm.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ibm.entity.Passenger;
import com.ibm.entity.Ticket;

@Repository
public class TicketRepoImpl implements TicketRepo {
	@PersistenceContext
	private EntityManager em;

	@Transactional
	@Override
	public int createTicket(Ticket t) {
		em.persist(t);
		return t.getPnr();
	}

	@Transactional
	@Override
	public int savePassenger(Passenger p, int pnr) {
		Ticket t = em.find(Ticket.class, pnr);
		p.setTicket(t);
		em.persist(p);
		return p.getPid();
	}

	@Transactional
	@Override
	public boolean removeTicket(int pnr) {
		Ticket t = em.find(Ticket.class, pnr);
		em.remove(t);
		return true;
	}

	@Transactional
	@Override
	public boolean removePassenger(int pid) {
		Passenger p = em.find(Passenger.class, pid);
		em.remove(p);
		return true;
	}

	@Transactional
	@Override
	public boolean updateTicket(Ticket t) {
		em.merge(t);
		return true;
	}

	@Transactional
	@Override
	public boolean updatePassenger(Passenger p) {
		em.merge(p);
		return true;
	}

	@Override
	public List<Ticket> fetchAll() {
		Query sql = em.createQuery("from Ticket");
		return sql.getResultList();
	}

	@Override
	public Ticket fetchByPnr(int pnr) {
		Ticket d = em.find(Ticket.class, pnr);
		return d;
	}

}
