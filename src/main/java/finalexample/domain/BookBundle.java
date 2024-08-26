package finalexample.domain;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class BookBundle {
    private final List<Book> books;

    public BookBundle(Book... book) {
        this.books = List.of(book);
    }

    public BookBundle(List<Book> books) {
        this.books = books;
    }

    public Book find(Isbn isbn) {
        return books.stream()
                .filter(b -> b.hasIsbn(isbn))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));
    }

    public Book leastExpensive() {
        return books.stream()
                .min(Comparator.comparing(Book::price))
                .orElseThrow();
    }

    public List<Book> bookWithPriceLowerThan(Price price) {
        return books.stream()
                .filter(book -> book.price().isLowerThan(price))
                .collect(toList());
    }

    public List<String> publishersOf(String title) {
        return books.stream()
                .filter(book -> book.hasTitle(title))
                .map(Book::publisherName)
                .collect(toList());
    }

    public int size() {
        return books.size();
    }

    @Override
    public String toString() {
        return "BookBundle{" +
                "publishedBooks=" + books +
                '}';
    }
}
