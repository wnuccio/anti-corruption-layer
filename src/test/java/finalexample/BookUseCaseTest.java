package finalexample;

import finalexample.acl.BookProviderAdapter;
import finalexample.domain.Book;
import finalexample.domain.Isbn;
import finalexample.domain.Price;
import finalexample.domain.ValidationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;

import static finalexample.FakeBookProviderClient.ADDISON_WESLEY;
import static finalexample.FakeBookProviderClient.BOOK_INVALID_PRICE;
import static finalexample.FakeBookProviderClient.BOOK_WRONG_ISBN;
import static finalexample.FakeBookProviderClient.DESIGN_PATTERNS;
import static finalexample.FakeBookProviderClient.DESIGN_PATTERNS_2;
import static finalexample.FakeBookProviderClient.IMPLEMENTING_DDD;
import static finalexample.FakeBookProviderClient.PEARSON;
import static finalexample.FakeBookProviderClient.REFACTORING;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookUseCaseTest {

    @Test
    void count_books() {
        FakeBookProviderClient provider = new FakeBookProviderClient(
                List.of(REFACTORING, DESIGN_PATTERNS, IMPLEMENTING_DDD),
                List.of(ADDISON_WESLEY, PEARSON));
        BookUseCase bookUseCase = createBookUseCase(provider);

        int count = bookUseCase.countSoftwareBooks();

        assertEquals(3, count);
    }

    @Test
    void fail_for_book_not_referred_by_publisher() {
        FakeBookProviderClient provider = new FakeBookProviderClient(
                List.of(REFACTORING),
                List.of(PEARSON));
        BookUseCase bookUseCase = createBookUseCase(provider);

        Executable countBooks = bookUseCase::countSoftwareBooks;

        assertThrows(ValidationException.class, countBooks);
    }

    @Test
    void fail_for_invalid_isbn() {
        FakeBookProviderClient provider = new FakeBookProviderClient(
                List.of(BOOK_WRONG_ISBN),
                List.of(PEARSON));
        BookUseCase bookUseCase = createBookUseCase(provider);

        Executable countBooks = bookUseCase::countSoftwareBooks;

        assertThrows(ValidationException.class, countBooks);
    }

    @Test
    void fail_for_invalid_price() {
        FakeBookProviderClient provider = new FakeBookProviderClient(
                List.of(BOOK_INVALID_PRICE),
                List.of(PEARSON));
        BookUseCase bookUseCase = createBookUseCase(provider);

        Executable countBooks = bookUseCase::countSoftwareBooks;

        assertThrows(ValidationException.class, countBooks);
    }

    @Test
    void find_book_by_isbn() {
        FakeBookProviderClient provider = new FakeBookProviderClient(
                List.of(REFACTORING, IMPLEMENTING_DDD),
                List.of(ADDISON_WESLEY, PEARSON));
        BookUseCase bookUseCase = createBookUseCase(provider);

        Book book = bookUseCase.findBookByIsbn(Isbn.validate("978-1234567803"));

        assertEquals(book.title(), "Implementing DDD");
    }

    @Test
    void find_cheapest_book() {
        FakeBookProviderClient provider = new FakeBookProviderClient(
                List.of(REFACTORING, DESIGN_PATTERNS, IMPLEMENTING_DDD),
                List.of(ADDISON_WESLEY, PEARSON));
        BookUseCase bookUseCase = createBookUseCase(provider);

        Book book = bookUseCase.findCheapestBook();

        assertEquals(book.title(), "Refactoring");
    }

    @Test
    void find_books_with_price_lower_than_x() {
        FakeBookProviderClient provider = new FakeBookProviderClient(
                List.of(REFACTORING, DESIGN_PATTERNS, IMPLEMENTING_DDD),
                List.of(ADDISON_WESLEY, PEARSON));
        BookUseCase bookUseCase = createBookUseCase(provider);

        List<Book> books = bookUseCase.findBooksLessExpensiveThan(Price.ofEuros(30.00));

        assertEquals(1, books.size());
        assertEquals(books.get(0).title(), "Refactoring");
    }

    @Test
    void find_books_published_after_x() {
        FakeBookProviderClient provider = new FakeBookProviderClient(
                List.of(REFACTORING, DESIGN_PATTERNS, IMPLEMENTING_DDD),
                List.of(ADDISON_WESLEY, PEARSON));
        BookUseCase bookUseCase = createBookUseCase(provider);

        List<Book> books = bookUseCase.findRecentlyPublishedBooks(2002);

        assertEquals(1, books.size());
        assertEquals(books.get(0).title(), "Implementing DDD");
    }

    @Test
    void find_publishers_of_books() {
        FakeBookProviderClient provider = new FakeBookProviderClient(
                List.of(REFACTORING, IMPLEMENTING_DDD, DESIGN_PATTERNS, DESIGN_PATTERNS_2),
                List.of(ADDISON_WESLEY, PEARSON));
        BookUseCase bookUseCase = createBookUseCase(provider);

        List<String> publishersOfRefactoring = bookUseCase.findPublihsersOfBook("Refactoring");
        List<String> publishersOfDesignPatterns = bookUseCase.findPublihsersOfBook("Design Patterns");
        List<String> noPublisher = bookUseCase.findPublihsersOfBook("No such a published book");

        assertEquals(1, publishersOfRefactoring.size());
        assertTrue(publishersOfRefactoring.contains("Addison-Wesley"));

        assertEquals( 2, publishersOfDesignPatterns.size());
        assertTrue(publishersOfDesignPatterns.contains("Addison-Wesley"));
        assertTrue(publishersOfDesignPatterns.contains("Pearson"));

        assertTrue(noPublisher.isEmpty());
    }

    private BookUseCase createBookUseCase(FakeBookProviderClient provider) {
        BookProviderAdapter adapter = new BookProviderAdapter(provider);
        return new BookUseCase(adapter);
    }
}
