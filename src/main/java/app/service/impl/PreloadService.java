package app.service.impl;

import app.model.Ticket;
import app.model.TicketsList;
import app.repository.TicketRepository;
import app.repository.impl.TicketRepositoryImpl;
import app.util.Writter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class PreloadService {

//    @Autowired
//    private PlatformTransactionManager platformTransactionManager;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    @Qualifier(value = "jaxb2Marshaller")
    private Jaxb2Marshaller marshaller;

    @Transactional
    public void preloadTickets(){
//        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
//        definition.setIsolationLevel(TransactionDefinition.ISOLATION_REPEATABLE_READ);
//        definition.setTimeout(3);
//
//        TransactionStatus status = platformTransactionManager.getTransaction(definition);

        try(FileInputStream is = new FileInputStream("D:/Spring Intro/src/main/resources/tickets.xml")) {
            TicketsList ticketsList = (TicketsList) this.marshaller.unmarshal((new StreamSource(is)));

            Map<String, Ticket> map = new HashMap<>();

            for (Ticket t : ticketsList.getTickets()) {
                map.put(String.valueOf(t.getId()),t);
            }

            ticketRepository.setTickets(map);
//            platformTransactionManager.commit(status);
            log.info("Transaction was committed");
        } catch (Exception e) {
//            platformTransactionManager.rollback(status);
           log.error("Transaction was aborted");
        }
    }
}
