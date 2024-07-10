package finalexample.dtos;

import finalexample.model.ValidationException;

public class Isbn {
    private final String isbn;

    private Isbn(String isbn) {
        this.isbn = isbn;
    }

    public static Isbn validate(String isbn) {
        if (isbn == null || !isbn.matches("^[0-9]{3}-[0-9]{10}$")) {
            throw new ValidationException("ISBN is not valid: " + isbn);
        }
        return new Isbn(isbn);
    }

    public String isbn() {
        return isbn;
    }
}
