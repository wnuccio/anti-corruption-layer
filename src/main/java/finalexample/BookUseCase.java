package finalexample;

import finalexample.domain.Book;
import finalexample.domain.BookBundle;
import finalexample.domain.BookService;
import finalexample.domain.Isbn;

public class BookUseCase {
    private final BookService bookService;

    public BookUseCase(BookService bookService) {
        this.bookService = bookService;
    }

    public Book findBookByIsbn(Isbn isbn, String keyword) {
        BookBundle bundle = bookService.retrieveBooks(keyword);
        return bundle.find(isbn);
    }

    public Book findLeastExpensiveBook(String keyword) {
        return bookService.retrieveBooks(keyword).leastExpensive();
    }
}
