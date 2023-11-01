import app.Application;
import app.model.Ticket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import app.service.TicketService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TicketServiceAppContextIntegrationTest {

    @Autowired
    private TicketService ticketService;

    @Test
    public void whenContextLoads_thenServiceISNotNull() {
        Ticket ticket = ticketService.bookTicket(4, 1, 1, "Place", Ticket.Category.STANDARD);
        assertNotNull(ticketService);
        assertNotNull(ticket);
    }
}
