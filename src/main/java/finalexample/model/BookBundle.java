package finalexample.model;

import java.util.List;

public class BookBundle {
    private final List<PublishedBook> publishedBooks;

    public BookBundle(PublishedBook... publishedBook) {
        this.publishedBooks = List.of(publishedBook);
    }

    public Edition editionOf(String isbn) {
        PublishedBook publishedBook = publishedBooks.stream()
                .filter(book -> book.hasIsbn(isbn))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));

        return new Edition(
                publishedBook.title(),
                publishedBook.publisherName(),
                publishedBook.year(),
                publishedBook.price());
    }
}
