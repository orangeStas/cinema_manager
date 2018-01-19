package ua.epam.spring.hometask.service.impl;

import ua.epam.spring.hometask.domain.*;
import ua.epam.spring.hometask.service.BookingService;
import ua.epam.spring.hometask.service.DiscountService;
import ua.epam.spring.hometask.service.TicketService;
import ua.epam.spring.hometask.service.UserService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.Set;

public class BookingServiceImpl implements BookingService {

    private DiscountService discountService;
    private TicketService ticketService;
    private UserService userService;

    @Override
    public double getTicketsPrice(@Nonnull Event event, @Nonnull LocalDateTime dateTime, @Nullable User user, @Nonnull Set<Long> seats) {
        byte discount = discountService.getDiscount(user, event, dateTime, seats.size());
        EventRating rating = event.getRating();
        double basePrice = event.getBasePrice();
        Auditorium auditorium = event.getAuditoriums().get(dateTime);

        double finalPrice = basePrice;
        finalPrice += calculatePriceDifferenceByRating(basePrice, rating);
        finalPrice *= seats.size();

        for (Long seat: seats) {
            finalPrice += calculatePriceDifferenceByVipSeats(auditorium, seat, basePrice);
        }

        return finalPrice;
    }

    private double calculatePriceDifferenceByRating(double basePrice, EventRating rating) {
        double calculatedPrice = basePrice;

        switch (rating) {
            case HIGH: calculatedPrice = basePrice * 1.2; break;
            case LOW: calculatedPrice = basePrice * 0.8; break;
            default: calculatedPrice = basePrice;
        }

        return calculatedPrice - basePrice;
    }

    private double calculatePriceDifferenceByVipSeats(Auditorium auditorium, Long seatNumber, double basePrice) {
          if (auditorium.getVipSeats().contains(seatNumber)) {
              return basePrice;
          } else {
              return 0;
          }
    }

    @Override
    public void bookTickets(@Nonnull Set<Ticket> tickets) {
        tickets.forEach(ticket -> {
            if (checkTicket(ticket)) {
                ticketService.save(ticket);
                if (ticket.getUser() != null) {
                    User user = ticket.getUser();
                    user.getTickets().add(ticket);
                    userService.update(user);
                }
            } else {
                //TODO: throw/log exception
            }
        });
    }

    private boolean checkTicket(Ticket ticket) {
        if (ticket.getEvent() == null) {
            return false;
        }
        if (ticket.getDateTime() == null) {
            return false;
        }
        if (ticket.getSeat() < 0) {
            return false;
        }

        return true;
    }

    @Nonnull
    @Override
    public Set<Ticket> getPurchasedTicketsForEvent(@Nonnull Event event, @Nonnull LocalDateTime dateTime) {
        return ticketService.findTicketsByEventAndDate(event, dateTime);
    }
}
