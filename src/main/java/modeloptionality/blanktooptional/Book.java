package modeloptionality.blanktooptional;

import java.util.Optional;

public class Book {
    String title;
    String publisher;

    private Book(String title, String publisher) {
        this.title = title;
        this.publisher = publisher;
    }

    static Book createBook(String title, String publisher) {
        if (publisher != null && publisher.isBlank()) {
            publisher = null;
        }

        return new Book(title, publisher);
    }

    public Optional<String> publisher() {
        return Optional.ofNullable(publisher);
    }
}
