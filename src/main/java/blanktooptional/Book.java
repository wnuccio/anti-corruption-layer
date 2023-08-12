package blanktooptional;

import java.util.Optional;

public class Book {
    String title;
    String author;

    private Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    static Book createBook(String title, String author) {
        if (author != null && author.isBlank()) {
            author = null;
        }

        return new Book(title, author);
    }

    public Optional<String> author() {
        return Optional.ofNullable(author);
    }
}
