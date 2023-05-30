package config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import repository.EventRepository;
import repository.TicketRepository;
import repository.UserRepository;
import util.Writter;

public class TicketsPostProcessor implements BeanPostProcessor {

    @Autowired
    private Writter writter;

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if (bean instanceof TicketRepository) {
            ((TicketRepository) bean).setTickets(writter.ticketsFromTextFile());
        }
        if (bean instanceof UserRepository) {
            ((UserRepository) bean).setUsers(writter.usersFromTextFile());
        }
        if (bean instanceof EventRepository) {
            ((EventRepository) bean).setEvents(writter.eventsFromTextFile());
        }

        System.out.println(
                "postProcessBeforeInitialization() is called for " + beanName);

        return bean;
    }
}
