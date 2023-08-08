package ch12responsetoexception;

class BookAvailability {
    Book book;
    boolean isAvailable;
}

class Book {
    String title;
    String publisher;
    String author;
}

class BookAvailabilityException extends RuntimeException {
    String message;
}

