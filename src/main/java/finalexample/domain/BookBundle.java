package finalexample.domain;

import java.util.List;
import java.util.Objects;

public class BookBundle {
    private final List<Book> books;

    public BookBundle(Book... book) {
        this.books = List.of(book);
    }

    public BookBundle(List<Book> books) {
        this.books = books;
    }

    public Edition editionOf(Isbn isbn) {
        Book book = books.stream()
                .filter(b -> b.hasIsbn(isbn))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));

        return new Edition(
                book.title(),
                book.publisherName(),
                book.year(),
                book.price().euros());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookBundle bundle = (BookBundle) o;
        return Objects.equals(books, bundle.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books);
    }

    @Override
    public String toString() {
        return "BookBundle{" +
                "publishedBooks=" + books +
                '}';
    }
}
