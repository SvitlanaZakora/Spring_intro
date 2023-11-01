package app.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by maksym_govorischev on 14/03/14.
 */
@Getter
@Setter
@Builder
@ToString
public class User {
    private long id;
    private String name;
    private String email;
}
