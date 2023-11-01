package app.util;

import lombok.extern.slf4j.Slf4j;
import app.model.Event;
import app.model.Ticket;
import app.model.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Long.parseLong;

@Slf4j
public class Writter {
    public static Map<String, Ticket> ticketsFromTextFile()
    {
        BufferedReader br = null;
        Map<String, Ticket> map = new HashMap<>();
        try {
            br = new BufferedReader(new FileReader("D:/Spring Intro/src/main/resources/tickets.txt"));
            String line = null;

            while ((line = br.readLine()) != null) {

                List<String> data = Arrays.stream(line.split("\\|")).collect(Collectors.toList());

                String id = data.get(0);
                Ticket ticket = Ticket.builder()
                        .id(parseLong(id))
                        .eventId(parseLong(data.get(1)))
                        .userId(parseLong(data.get(2)))
                        .category(Ticket.Category.valueOf(data.get(3)))
                        .place(data.get(4))
                        .build();

                if (!id.isEmpty() && ticket !=null)
                    map.put(id, ticket);
            }
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }
        finally {
            if (br != null) {
                try {
                    br.close();
                }
                catch (Exception e) {
                    log.warn(e.getMessage());
                }
            }
        }

        return map;
    }

    public static Map<String, User> usersFromTextFile()
    {
        BufferedReader br = null;
        Map<String, User> map = new HashMap<>();
        try {
            br = new BufferedReader(new FileReader("D:/Spring Intro/src/main/resources/users.txt"));
            String line = null;

            while ((line = br.readLine()) != null) {

                List<String> data = Arrays.stream(line.split("\\|")).collect(Collectors.toList());

                String id = data.get(0);
                User user = User.builder()
                        .id(parseLong(id))
                        .name(data.get(1))
                        .email(data.get(2))
                        .build();

                if (!id.isEmpty() && user !=null)
                    map.put(id, user);
            }
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }
        finally {
            if (br != null) {
                try {
                    br.close();
                }
                catch (Exception e) {
                    log.warn(e.getMessage());
                }
            }
        }

        return map;
    }

    public static Map<String, Event> eventsFromTextFile()
    {
        BufferedReader br = null;
        Map<String, Event> map = new HashMap<>();
        try {
            br = new BufferedReader(new FileReader("D:/Spring Intro/src/main/resources/events.txt"));
            String line = null;

            while ((line = br.readLine()) != null) {

                List<String> data = Arrays.stream(line.split("\\|")).collect(Collectors.toList());

                String id = data.get(0);
                Event event = Event.builder()
                        .id(parseLong(id))
                        .title(data.get(1))
                        .date(LocalDate.parse(data.get(2)))
                        .build();

                if (!id.isEmpty() && event !=null)
                    map.put(id, event);
            }
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }
        finally {
            if (br != null) {
                try {
                    br.close();
                }
                catch (Exception e) {
                    log.warn(e.getMessage());
                }
            }
        }

        return map;
    }
}
