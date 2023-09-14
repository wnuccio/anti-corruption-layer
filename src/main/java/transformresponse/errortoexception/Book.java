package transformresponse.errortoexception;

class BookAvailability {
    Book book;
    boolean isAvailable;
}

class Book {
    String title;
    String author;
}

class BookAvailabilityException
        extends RuntimeException {
    String message;
}

