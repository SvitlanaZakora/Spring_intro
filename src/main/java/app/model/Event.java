package app.model;

import lombok.*;

import java.time.LocalDate;

/**
 * Created by maksym_govorischev.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Event {

    private long id;
    private String title;
    private LocalDate date;
}
