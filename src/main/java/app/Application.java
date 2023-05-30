package app;

import facade.BookingFacade;
import lombok.extern.slf4j.Slf4j;
import model.Event;
import model.Ticket;
import model.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
@ImportResource({"classpath:applicationContext.xml"})
@Slf4j
public class Application {

    private BookingFacade bookingFacade;

    public static void main(String[] args) {

        ApplicationContext context = new FileSystemXmlApplicationContext
                ("D:/Spring Intro/src/main/resources/applicationContext.xml");

        BookingFacade bookingFacade = (BookingFacade) context.getBean("bookingFacade");

        checkUserWork(bookingFacade);
        checkTicketWork(bookingFacade);
        checkEventWork(bookingFacade);

    }

    private static void checkTicketWork(final BookingFacade bookingFacade) {
        log.info("Cancel ticket - " + bookingFacade.cancelTicket(1));
        log.info("Book ticket - " + bookingFacade.bookTicket(4L, 1L, 1L, "Main Hall", Ticket.Category.BAR));
    }

    private static void checkUserWork(final BookingFacade bookingFacade) {
        log.info("Delete user - " + bookingFacade.deleteUser(2));
        log.info("Create user - " + bookingFacade.createUser(User.builder().id(5).name("test").email("test@").build()));
        log.info("Get users by name - " + bookingFacade.getUsersByName("John"));
    }

    private static void checkEventWork(final BookingFacade bookingFacade) {
        log.info("Delete event - " + bookingFacade.deleteEvent(1));
        log.info("Create event - " + bookingFacade.createEvent(Event.builder().id(4).title("Event").date(LocalDate.now()).build()));
        log.info("Get events by name - " + bookingFacade.getEventsByTitle("Event"));
    }
}
