package app.model;

import lombok.*;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by maksym_govorischev.
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "ticket")
public class Ticket {

    @XmlEnum
    public enum Category {
        @XmlEnumValue("STANDART") STANDARD,
        @XmlEnumValue("PREMIUM") PREMIUM,
        @XmlEnumValue("BAR") BAR
    }
    @XmlAttribute
    private long id;
    @XmlAttribute
    private long eventId;
    @XmlAttribute
    private long userId;
    @XmlAttribute
    private Category category;
    @XmlAttribute
    private String place;

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", eventId=" + eventId +
                ", userId=" + userId +
                ", category=" + category +
                ", place=" + place +
                '}';
    }

}