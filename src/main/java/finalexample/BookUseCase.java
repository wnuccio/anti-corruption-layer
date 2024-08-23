package finalexample;

import finalexample.domain.Book;
import finalexample.domain.BookBundle;
import finalexample.domain.BookProvider;
import finalexample.domain.Isbn;

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

    public Book findLeastExpensiveBook() {
        BookBundle bundle = bookProvider.retrieveSoftwareBooks();
        return bundle.leastExpensive();
    }

    public List<String> findPublihsersOfBook(String title) {
        BookBundle bundle = bookProvider.retrieveSoftwareBooks();
        return bundle.publishersOf(title);
    }
}
