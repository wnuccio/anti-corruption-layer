package finalexample;

import finalexample.acl.BookProviderAdapter;
import finalexample.domain.Book;
import finalexample.domain.Isbn;
import finalexample.domain.ValidationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;

import static finalexample.FakeBookProviderClient.BOOK_1;
import static finalexample.FakeBookProviderClient.BOOK_2;
import static finalexample.FakeBookProviderClient.BOOK_3;
import static finalexample.FakeBookProviderClient.BOOK_4;
import static finalexample.FakeBookProviderClient.BOOK_5;
import static finalexample.FakeBookProviderClient.PUBLISHER_A;
import static finalexample.FakeBookProviderClient.PUBLISHER_B;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BookUseCaseTest {

    @Test
    void count_books() {
        FakeBookProviderClient provider = new FakeBookProviderClient(
                List.of(BOOK_1, BOOK_2, BOOK_3),
                List.of(PUBLISHER_A, PUBLISHER_B));
        BookUseCase bookUseCase = createBookUseCase(provider);

        int count = bookUseCase.countBooksAbout("software");

        assertEquals(3, count);
    }

    @Test
    void fail_for_invalid_isbn() {
        FakeBookProviderClient provider = new FakeBookProviderClient(
                List.of(BOOK_4),
                List.of(PUBLISHER_B));
        BookUseCase bookUseCase = createBookUseCase(provider);

        Executable countBooks = () -> bookUseCase.countBooksAbout("wrong-isbn");

        assertThrows(ValidationException.class, countBooks);
    }

    @Test
    void fail_for_invalid_price() {
        FakeBookProviderClient provider = new FakeBookProviderClient(
                List.of(BOOK_5),
                List.of(PUBLISHER_B));
        BookUseCase bookUseCase = createBookUseCase(provider);

        Executable countBooks = () -> bookUseCase.countBooksAbout("invalid-price");

        assertThrows(ValidationException.class, countBooks);
    }

    @Test
    void fail_for_book_not_referred_by_publisher() {
        FakeBookProviderClient provider = new FakeBookProviderClient(
                List.of(BOOK_1),
                List.of(PUBLISHER_B));
        BookUseCase bookUseCase = createBookUseCase(provider);

        Executable countBooks = () -> bookUseCase.countBooksAbout("software");

        assertThrows(ValidationException.class, countBooks);
    }

    @Test
    void find_book_by_isbn() {
        FakeBookProviderClient provider = new FakeBookProviderClient(
                List.of(BOOK_1, BOOK_3),
                List.of(PUBLISHER_A, PUBLISHER_B));
        BookUseCase bookUseCase = createBookUseCase(provider);

        Book book = bookUseCase.findBookByIsbn(Isbn.validate("978-0201633603"), "software");

        assertEquals(book.title(), "Implementing DDD");
    }

    @Test
    void find_cheapest_book() {
        FakeBookProviderClient provider = new FakeBookProviderClient(
                List.of(BOOK_1, BOOK_2, BOOK_3),
                List.of(PUBLISHER_A, PUBLISHER_B));
        BookUseCase bookUseCase = createBookUseCase(provider);

        Book book = bookUseCase.findLeastExpensiveBook("software");

        assertEquals(book.title(), "Refactoring");
    }

    private BookUseCase createBookUseCase(FakeBookProviderClient provider) {
        BookProviderAdapter adapter = new BookProviderAdapter(provider);
        return new BookUseCase(adapter);
    }
}
