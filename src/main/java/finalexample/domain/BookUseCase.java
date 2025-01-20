package finalexample.domain;

import java.util.List;
import java.util.Optional;

public class BookUseCase {
    private final BookProvider provider;

    public BookUseCase(BookProvider bookProvider) {
        this.provider = bookProvider;
    }

    public Optional<Book> findBookByIsbn(Isbn isbn) {
        BookBundle bundle = provider.retrieveSoftwareBooks();
        return bundle.find(isbn);
    }

    public Optional<Book> findCheapestBook() {
        BookBundle bundle = provider.retrieveSoftwareBooks();
        return bundle.cheapestBook();
    }

    public List<String> findPublihsersOfBook(String title) {
        BookBundle bundle = provider.retrieveSoftwareBooks();
        return bundle.publishersOf(title);
    }

    public List<Book> findBooksLessExpensiveThan(Price price) {
        BookBundle bundle = provider.retrieveSoftwareBooks();
        return bundle.booksLessExpensiveThan(price);
    }

    public List<Book> findRecentlyPublishedBooks(int year) {
        BookBundle bundle = provider.retrieveSoftwareBooks();
        return bundle.booksPublishedAfter(year);
    }
}
