package transformresponse.responsetooptionalclass;

import java.util.Date;
import java.util.Optional;

class BookAvailability {
    Book book;
    Availability availability;

    public Optional<Availability> availability() {
        return Optional.ofNullable(availability);
    }

    boolean isAvailable() {
        return availability().isPresent();
    }
}

class Book {
    String title;
    String author;
}

class Availability {
    int price;
    Date availabilityDate;
}

