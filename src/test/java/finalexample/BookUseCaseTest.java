package finalexample;

import finalexample.acl.BookProviderAdapter;
import finalexample.domain.Book;
import finalexample.domain.Isbn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookUseCaseTest {
    private BookUseCase bookUseCase;

    @BeforeEach
    void setUp() {
        FakeBookProviderClient provider = new FakeBookProviderClient();
        BookProviderAdapter adapter = new BookProviderAdapter(provider);
        bookUseCase = new BookUseCase(adapter);
    }

    @Test
    void find_book_by_isbn() {
        Book book = bookUseCase.findBookByIsbn(Isbn.validate("978-0201633610"), "pattern");

        assertEquals(book.title(), "Design Patterns");
    }

    @Test
    void find_cheapest_book() {
        Book book = bookUseCase.findLeastExpensiveBook("design");

        assertEquals(book.title(), "Design Patterns");
    }
}
