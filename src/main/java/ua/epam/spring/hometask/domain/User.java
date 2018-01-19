package ua.epam.spring.hometask.domain;

import java.time.LocalDateTime;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * @author Yuriy_Tkach
 */
public class User extends DomainObject {

    private String firstName;

    private String lastName;

    private String email;

    private LocalDateTime birthDay;

    private NavigableSet<Ticket> tickets = new TreeSet<>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public NavigableSet<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(NavigableSet<Ticket> tickets) {
        this.tickets = tickets;
    }

    public LocalDateTime getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDateTime birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (birthDay != null ? !birthDay.equals(user.birthDay) : user.birthDay != null) return false;
        return tickets != null ? tickets.equals(user.tickets) : user.tickets == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (birthDay != null ? birthDay.hashCode() : 0);
        result = 31 * result + (tickets != null ? tickets.hashCode() : 0);
        return result;
    }
}
