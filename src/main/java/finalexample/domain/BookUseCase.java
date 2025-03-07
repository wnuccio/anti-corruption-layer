package finalexample.domain;

import java.util.List;
import java.util.Optional;

public class BookUseCase {
    private final BookService bookService;

    public BookUseCase(BookService bookService) {
        this.bookService = bookService;
    }

    public Optional<Book> findBookByIsbn(Isbn isbn) {
        BookBundle bundle = bookService.retrieveSoftwareBooks();
        return bundle.find(isbn);
    }

    public Optional<Book> findCheapestBook() {
        BookBundle bundle = bookService.retrieveSoftwareBooks();
        return bundle.cheapestBook();
    }

    public List<String> findPublihsersOfBook(String title) {
        BookBundle bundle = bookService.retrieveSoftwareBooks();
        return bundle.publishersOf(title);
    }

    public List<Book> findBooksLessExpensiveThan(Price price) {
        BookBundle bundle = bookService.retrieveSoftwareBooks();
        return bundle.booksLessExpensiveThan(price);
    }

    public List<Book> findRecentlyPublishedBooks(Year year) {
        BookBundle bundle = bookService.retrieveSoftwareBooks();
        return bundle.booksPublishedAfter(year);
    }
}
