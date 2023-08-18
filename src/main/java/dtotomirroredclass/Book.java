package dtotomirroredclass;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class Book {
    String title;
    String publisher;
    String genre;
    LocalDateTime deliveryTime;
    String isbn;
}

class Time {
    ZonedDateTime time;

    boolean isAfter(Time other) {
        // ... logic to compare different timezone
        return true;
    }
}

