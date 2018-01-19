package ua.epam.spring.hometask.service.discount;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class BirthdayDiscountStrategy implements DiscountStrategy {
    public static final int FIVE_DAYS = 5;
    public static final int ZERO_DISCOUNT = 0;
    public static final int BIRTHDAY_DISCOUNT = 5;

    @Override
    public byte calculateDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets) {
        LocalDateTime userBirthDay = user.getBirthDay();
        long difference = ChronoUnit.DAYS.between(userBirthDay, airDateTime);

        if (difference > FIVE_DAYS || difference < 0) {
            return ZERO_DISCOUNT;
        } else {
            return BIRTHDAY_DISCOUNT;
        }
    }
}
