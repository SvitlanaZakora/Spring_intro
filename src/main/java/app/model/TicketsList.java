package app.model;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter
@XmlRootElement(name = "tickets")
public class TicketsList {

    @XmlElement(name = "ticket")
    private List<Ticket> tickets = null;
}
