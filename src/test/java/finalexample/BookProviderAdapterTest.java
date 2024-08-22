package finalexample;

import finalexample.acl.BookProviderAdapter;
import finalexample.domain.Book;
import finalexample.domain.BookBundle;
import finalexample.domain.BookService;
import finalexample.domain.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BookProviderAdapterTest {

    private BookService bookService;

    @BeforeEach
    void setUp() {
        FakeBookProvider bookProvider = new FakeBookProvider();
        bookService = new BookProviderAdapter(bookProvider);
    }

    @Test
    void retrieve_book_bundle_with_two_books_by_isbn_list() {
        BookBundle expectedBundle = new BookBundle(
                Book.builder()
                        .title("Refactoring")
                        .isbn("978-1234567876")
                        .publisher("Addison-Wesley")
                        .year(2002)
                        .price(10.00)
                        .build(),
                Book.builder()
                        .title("Design Patterns")
                        .isbn("978-0201633610")
                        .publisher("Pearson")
                        .year(2000)
                        .price(30.00)
                        .build());

        BookBundle actualBundle = bookService.retrieveBooks("coding");

        assertEquals( 2, actualBundle.size());
        assertEquals(expectedBundle, actualBundle);
    }

    @Test
    void bundle_with_invalid_isbn_is_rejected() {
        Executable retrieve = () -> bookService.retrieveBooks("wrong-isbn");

        assertThrows(ValidationException.class, retrieve);
    }

    @Test
    void bundle_with_isbn_not_referred_by_any_publisher_is_rejected() {
        Executable retrieve = () -> bookService.retrieveBooks("not-referred-by-any-publisher");

        assertThrows(ValidationException.class, retrieve);
    }

    @Test
    void bundle_with_invalid_price_is_rejected() {
        Executable retrieve = () -> bookService.retrieveBooks("invalid-price");

        assertThrows(ValidationException.class, retrieve);
    }
}
