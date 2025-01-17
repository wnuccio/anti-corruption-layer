package modelrelationships.relatedfieldstoclass;

import java.time.LocalDateTime;
import java.util.List;
import java.util.TimeZone;


class DeliveredBooks {
    List<Book> books;
}

class Book {
    String title;
    Price price;
    Time deliveryTime;
}

class Price {
    enum Currency { EUR, USD }

    Double amount;
    Currency currency;

    boolean isGreaterThan(Price other) {
        // ... logic to compare different currency
        return true;
    }
}

class Time {
    TimeZone timeZone;
    LocalDateTime time;
}

