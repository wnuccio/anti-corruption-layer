package transformresponse.responsetohierarchy;

import java.util.Date;

class BookAvailability {
    Book book;
    Availability availability;
}

class Book {
    String title;
    String author;
}

interface Availability {

    class Available implements Availability {
        Date deliveryDate;
    }

    class NotAvailable implements Availability {
        Date dateToRetry;
    }

    class Error implements Availability {
        String message;
    }
}



