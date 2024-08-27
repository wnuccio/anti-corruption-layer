package finalexample.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class BookBundle {
    private final List<Book> books;

    public BookBundle(List<Book> books) {
        this.books = books;
    }

    public Optional<Book> find(Isbn isbn) {
        return books.stream()
                .filter(b -> b.hasIsbn(isbn))
                .findFirst();
    }

    public Optional<Book> cheapestBook() {
        return books.stream()
                .min(Comparator.comparing(Book::price));
    }

    public List<Book> booksLessExpensiveThan(Price price) {
        return books.stream()
                .filter(book -> book.price().isLowerThan(price))
                .collect(toList());
    }

    public List<Book> booksPublishedAfter(int year) {
        return books.stream()
                .filter(book -> book.publishedAfter(year))
                .collect(toList());
    }

    public List<String> publishersOf(String title) {
        return books.stream()
                .filter(book -> book.hasTitle(title))
                .map(Book::publisherName)
                .collect(toList());
    }

    @Override
    public String toString() {
        return "BookBundle{" +
                "books=" + books +
                '}';
    }
}
