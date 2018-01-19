package ua.epam.spring.hometask.service.discount;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;

public class TenTicketDiscountStrategy implements DiscountStrategy {

    @Override
    public byte calculateDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets) {
        if (isNewUserBoughtTenTickets(user, numberOfTickets) || isTenthTicketForUser(user)) {
            return 50;
        } else {
            return 0;
        }
    }

    private boolean isTenthTicketForUser(User user) {
        return user != null && user.getTickets().size() % 10 == 0 && user.getTickets().size() != 0;
    }

    private boolean isNewUserBoughtTenTickets(User user, long numberOfTickets) {
        return user == null && numberOfTickets >= 10;
    }
}
