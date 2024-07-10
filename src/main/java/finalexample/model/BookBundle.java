package finalexample.model;

import java.util.List;
import java.util.Objects;

public class BookBundle {
    private final List<PublishedBook> publishedBooks;

    public BookBundle(PublishedBook... publishedBook) {
        this.publishedBooks = List.of(publishedBook);
    }

    public BookBundle(List<PublishedBook> publishedBooks) {
        this.publishedBooks = publishedBooks;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookBundle bundle = (BookBundle) o;
        return Objects.equals(publishedBooks, bundle.publishedBooks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publishedBooks);
    }

    @Override
    public String toString() {
        return "BookBundle{" +
                "publishedBooks=" + publishedBooks +
                '}';
    }
}
