package model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

/**
 * Created by maksym_govorischev.
 */
@Getter
@Setter
@Builder
@ToString
public class Event {

    private long id;
    private String title;
    private LocalDate date;
}
