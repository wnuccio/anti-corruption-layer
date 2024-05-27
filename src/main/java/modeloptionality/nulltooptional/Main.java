package modeloptionality.nulltooptional;

import java.util.Optional;

public class Main {
    private static class BookDto2 {
        public String publisher;
    }

    public static void main(String[] args) {
        Book book = new Book();
        book.title = "Java 8 in Action";
        book.publisher = "Manning";

        Optional<String> publisher = book.publisher()
                .map(String::toUpperCase);

        BookDto2 someDto = new BookDto2();

        someDto.publisher = book.publisher().orElse(null);
    }
}
