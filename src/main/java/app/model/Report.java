package app.model;

import lombok.Data;

import java.util.List;

@Data
public class Report {

    private List<Long> tickets;
    private List<Long> events;
    private List<Long> users;
    private List<String> categories;
    private List<String> places;
}
