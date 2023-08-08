package ch10relatedfieldstoclass;

import java.time.ZonedDateTime;

public class Book {
    String title;
    Price price;
    Time deliveryTime;
}

class Price {
    enum Currency { EUR, USD }

    Double value;
    Currency currency;

    boolean isGreaterThan(Price other) {
        // ... logic to compare different currency
        return true;
    }
}

class Time {
    ZonedDateTime time;

    boolean isAfter(Time other) {
        // ... logic to compare different timezone
        return true;
    }
}

