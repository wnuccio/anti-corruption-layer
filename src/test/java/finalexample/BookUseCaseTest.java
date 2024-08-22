package finalexample;

import finalexample.acl.BookProviderAdapter;
import finalexample.domain.Book;
import finalexample.domain.Isbn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookUseCaseTest {

    @Test
    void find_book_by_isbn() {
        FakeBookProvider provider = new FakeBookProvider();
        BookProviderAdapter adapter = new BookProviderAdapter(provider);
        BookUseCase bookUseCase = new BookUseCase(adapter);

        Book book = bookUseCase.findBookByIsbn(Isbn.validate("978-0201633610"), "pattern");

        assertEquals(book.title(), "Design Patterns");
    }
}
