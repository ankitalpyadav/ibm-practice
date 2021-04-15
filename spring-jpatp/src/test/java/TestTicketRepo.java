import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ibm.entity.Passenger;
import com.ibm.entity.Ticket;
import com.ibm.repo.TicketRepo;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:appctx.xml")
public class TestTicketRepo {
	
	@Autowired
	private TicketRepo trepo;
	
	@Test
	public void testAddTicket() {
		Ticket t = new Ticket(101, LocalDate.now(), 1000);
		assertNotNull(trepo.createTicket(t));
	}
	
	@Test
	public void testAddPassenger() {
		Passenger p = new Passenger(3, "Kelly", 23, "Female");
		assertNotNull(trepo.savePassenger(p,101));
	}
	
	@Test
	public void testFindTicket() {
		List<Ticket> t = trepo.fetchAll();
		assertNotNull(t);
		System.out.println(trepo.fetchAll());
	}
	
	@Test
	public void testFindPnr() {
		Ticket t = trepo.fetchByPnr(101);
		assertNotNull(t);
		t.getPsngr().forEach(System.out::println);
	}
	
	@Test
	public void testRemoveTicket() {
		assertTrue(trepo.removeTicket(101));
	}
	
	

}
