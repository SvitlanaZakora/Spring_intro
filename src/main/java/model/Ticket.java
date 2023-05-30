package model;

import lombok.*;

/**
 * Created by maksym_govorischev.
 */
@Getter
@Setter
@Builder
public class Ticket {

    public enum Category {STANDARD, PREMIUM, BAR}

    private long id;
    private long eventId;
    private long userId;
    private Category category;
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