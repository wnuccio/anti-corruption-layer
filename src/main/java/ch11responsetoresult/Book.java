package ch11responsetoresult;

import java.util.Date;
import java.util.Optional;

class BookAvailability {
    Book book;
    Optional<Availability> availability;

    boolean isAvailable() {
        return availability.isPresent();
    }
}

class Book {
    String title;
    String publisher;
    String author;
}

class Availability {
    int price;
    Date availabilityDate;
}

