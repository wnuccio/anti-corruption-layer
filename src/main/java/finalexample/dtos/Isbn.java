package finalexample.dtos;

public class Isbn {
    private final String isbn;

    private Isbn(String isbn) {
        this.isbn = isbn;
    }

    public static Isbn validate(String isbn) {
        // some validation logic here
        return new Isbn(isbn);
    }

    public String isbn() {
        return isbn;
    }
}
