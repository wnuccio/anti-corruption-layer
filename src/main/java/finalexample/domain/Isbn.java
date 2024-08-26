package finalexample.domain;

import java.util.Objects;

public class Isbn {
    private final String isbn;

    private Isbn(String isbn) {
        this.isbn = isbn;
    }

    public static Isbn validate(String isbn) {
        if (isbn == null || !isbn.matches("^[0-9]{3}-[0-9]{10}$"))
            throw new ValidationException("ISBN is not valid: " + isbn);

        return new Isbn(isbn);
    }

    public boolean hasValue(String isbn) {
        return this.isbn.equals(isbn);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Isbn isbn1 = (Isbn) o;
        return Objects.equals(isbn, isbn1.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return "Isbn{" +
                "isbn='" + isbn + '\'' +
                '}';
    }
}
