package finalexample.domain;

import java.util.List;

public class BookUseCase {
    private final BookProvider bookProvider;

    public BookUseCase(BookProvider bookProvider) {
        this.bookProvider = bookProvider;
    }

    public int countSoftwareBooks() {
        BookBundle bundle = bookProvider.retrieveSoftwareBooks();
        return bundle.size();
    }

    public Book findBookByIsbn(Isbn isbn) {
        BookBundle bundle = bookProvider.retrieveSoftwareBooks();
        return bundle.find(isbn);
    }

    public Book findCheapestBook() {
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
