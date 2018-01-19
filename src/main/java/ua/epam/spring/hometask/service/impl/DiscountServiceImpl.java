package ua.epam.spring.hometask.service.impl;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.service.DiscountService;
import ua.epam.spring.hometask.service.discount.DiscountStrategy;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiscountServiceImpl implements DiscountService {

    private List<DiscountStrategy> discountStrategies;

    @Override
    public byte getDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets) {
        List<Byte> calculatedDiscounts = new ArrayList<>(discountStrategies.size());

        discountStrategies.forEach(discountStrategy ->
                calculatedDiscounts.add(discountStrategy.calculateDiscount(user, event, airDateTime, numberOfTickets)));

        return Collections.max(calculatedDiscounts);
    }
}
