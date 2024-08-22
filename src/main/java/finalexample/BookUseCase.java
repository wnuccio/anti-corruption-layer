package finalexample;

import finalexample.domain.Book;
import finalexample.domain.BookBundle;
import finalexample.domain.BookProvider;
import finalexample.domain.Isbn;

public class BookUseCase {
    private final BookProvider bookProvider;

    public BookUseCase(BookProvider bookProvider) {
        this.bookProvider = bookProvider;
    }

    public int countBooksAbout(String keyword) {
        BookBundle bundle = bookProvider.retrieveBooks(keyword);
        return bundle.size();
    }

    public Book findBookByIsbn(Isbn isbn, String keyword) {
        BookBundle bundle = bookProvider.retrieveBooks(keyword);
        return bundle.find(isbn);
    }

    public Book findLeastExpensiveBook(String keyword) {
        BookBundle bundle = bookProvider.retrieveBooks(keyword);
        return bundle.leastExpensive();
    }
}
