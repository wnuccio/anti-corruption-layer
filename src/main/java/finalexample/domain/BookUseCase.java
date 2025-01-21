package finalexample.domain;

import java.util.List;
import java.util.Optional;

public class BookUseCase {
    private final BookProvider bookProvider;

    public BookUseCase(BookProvider bookProvider) {
        this.bookProvider = bookProvider;
    }

    public Optional<Book> findBookByIsbn(Isbn isbn) {
        BookBundle bundle = bookProvider.retrieveSoftwareBooks();
        return bundle.find(isbn);
    }

    public Optional<Book> findCheapestBook() {
        BookBundle bundle = bookProvider.retrieveSoftwareBooks();
        return bundle.cheapestBook();
    }

    public List<String> findPublihsersOfBook(String title) {
        BookBundle bundle = bookProvider.retrieveSoftwareBooks();
        return bundle.publishersOf(title);
    }

    public List<Book> findBooksLessExpensiveThan(Price price) {
        BookBundle bundle = bookProvider.retrieveSoftwareBooks();
        return bundle.booksLessExpensiveThan(price);
    }

    public List<Book> findRecentlyPublishedBooks(int year) {
        BookBundle bundle = bookProvider.retrieveSoftwareBooks();
        return bundle.booksPublishedAfter(year);
    }
}
