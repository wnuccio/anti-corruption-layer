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
import static finalexample.FakeBookProviderClient.BOOK_INVALID_PRICE;
import static finalexample.FakeBookProviderClient.BOOK_WRONG_ISBN;
import static finalexample.FakeBookProviderClient.PUBLISHER_A;
import static finalexample.FakeBookProviderClient.PUBLISHER_B;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookUseCaseTest {

    @Test
    void count_books() {
        FakeBookProviderClient provider = new FakeBookProviderClient(
                List.of(BOOK_1, BOOK_2, BOOK_3),
                List.of(PUBLISHER_A, PUBLISHER_B));
        BookUseCase bookUseCase = createBookUseCase(provider);

        int count = bookUseCase.countSoftwareBooks();

        assertEquals(3, count);
    }

    @Test
    void fail_for_book_not_referred_by_publisher() {
        FakeBookProviderClient provider = new FakeBookProviderClient(
                List.of(BOOK_1),
                List.of(PUBLISHER_B));
        BookUseCase bookUseCase = createBookUseCase(provider);

        Executable countBooks = bookUseCase::countSoftwareBooks;

        assertThrows(ValidationException.class, countBooks);
    }

    @Test
    void fail_for_invalid_isbn() {
        FakeBookProviderClient provider = new FakeBookProviderClient(
                List.of(BOOK_WRONG_ISBN),
                List.of(PUBLISHER_B));
        BookUseCase bookUseCase = createBookUseCase(provider);

        Executable countBooks = bookUseCase::countSoftwareBooks;

        assertThrows(ValidationException.class, countBooks);
    }

    @Test
    void fail_for_invalid_price() {
        FakeBookProviderClient provider = new FakeBookProviderClient(
                List.of(BOOK_INVALID_PRICE),
                List.of(PUBLISHER_B));
        BookUseCase bookUseCase = createBookUseCase(provider);

        Executable countBooks = bookUseCase::countSoftwareBooks;

        assertThrows(ValidationException.class, countBooks);
    }

    @Test
    void find_book_by_isbn() {
        FakeBookProviderClient provider = new FakeBookProviderClient(
                List.of(BOOK_1, BOOK_3),
                List.of(PUBLISHER_A, PUBLISHER_B));
        BookUseCase bookUseCase = createBookUseCase(provider);

        Book book = bookUseCase.findBookByIsbn(Isbn.validate("978-1234567803"));

        assertEquals(book.title(), "Implementing DDD");
    }

    @Test
    void find_cheapest_book() {
        FakeBookProviderClient provider = new FakeBookProviderClient(
                List.of(BOOK_1, BOOK_2, BOOK_3),
                List.of(PUBLISHER_A, PUBLISHER_B));
        BookUseCase bookUseCase = createBookUseCase(provider);

        Book book = bookUseCase.findLeastExpensiveBook();

        assertEquals(book.title(), "Refactoring");
    }

    @Test
    void find_publishers_of_books() {
        FakeBookProviderClient provider = new FakeBookProviderClient(
                List.of(BOOK_1, BOOK_2, BOOK_3, BOOK_4),
                List.of(PUBLISHER_A, PUBLISHER_B));
        BookUseCase bookUseCase = createBookUseCase(provider);

        List<String> publishersOfRefactoring = bookUseCase.findPublihsersOfBook("Refactoring");
        List<String> publishersOfDesignPatterns = bookUseCase.findPublihsersOfBook("Design Patterns");

        assertEquals( 2, publishersOfDesignPatterns.size());
        assertTrue(publishersOfDesignPatterns.contains("Addison-Wesley"));
        assertTrue(publishersOfDesignPatterns.contains("Pearson"));

        assertEquals(1, publishersOfRefactoring.size());
        assertTrue(publishersOfRefactoring.contains("Addison-Wesley"));
    }

    private BookUseCase createBookUseCase(FakeBookProviderClient provider) {
        BookProviderAdapter adapter = new BookProviderAdapter(provider);
        return new BookUseCase(adapter);
    }
}
