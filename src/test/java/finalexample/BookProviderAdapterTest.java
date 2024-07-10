package finalexample;

import finalexample.domain.Book;
import finalexample.domain.BookBundle;
import finalexample.domain.BookService;
import finalexample.domain.Isbn;
import finalexample.domain.ValidationException;
import finalexample.mapping.BookBundleDtoMapper;
import finalexample.provider.BookBundleDto;
import finalexample.provider.BookInfoDto;
import finalexample.provider.BookProviderAdapter;
import finalexample.provider.PublishedBookDto;
import finalexample.provider.PublisherDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BookProviderAdapterTest {

    @Test
    void retrieve_book_bundle_with_one_book_by_isbn() {
        FakeBookProvider bookProvider = new FakeBookProvider("978-0201633610");
        BookService bookService = new BookProviderAdapter(bookProvider);

        Isbn isbn = Isbn.validate("978-0201633610");
        BookBundle actualBundle = bookService.retrieveBook(isbn);

        BookBundle expectedBundle = new BookBundle(
                Book.builder()
                        .title("Refactoring")
                        .isbn("978-1234567876")
                        .publisher("O'Reilly")
                        .year(2002)
                        .price(40.00)
                        .build(),
                Book.builder()
                        .title("Design Patterns")
                        .isbn("978-0201633610")
                        .publisher("Addison-Wesley")
                        .year(2000)
                        .price(30.00)
                        .build());

        assertEquals(expectedBundle, actualBundle);
    }

    @Test
    void bundle_with_invalid_isbn_is_rejected() {
        BookInfoDto book = new BookInfoDto("Refactoring", "Fowler", "xxxx");
        PublishedBookDto pubBook = new PublishedBookDto("Refactoring", "xxxx", 40.00,2002);
        PublisherDto publisher = new PublisherDto("O'Reilly", "USA", List.of(pubBook));
        BookBundleDto bookBundleDto = new BookBundleDto(List.of(book), List.of(publisher));

        BookBundleDtoMapper mapper = new BookBundleDtoMapper(bookBundleDto);

        assertThrows(ValidationException.class, () -> mapper.toBundle());
    }

    @Test
    void bundle_with_isbn_not_referred_by_any_publisher_is_rejected() {
        BookInfoDto book = new BookInfoDto("Refactoring", "Fowler", "978-1234567876");
        PublishedBookDto pubBook = new PublishedBookDto("Refactoring", "978-1111111111", 40.00,2002);
        PublisherDto publisher = new PublisherDto("O'Reilly", "USA", List.of(pubBook));
        BookBundleDto bookBundleDto = new BookBundleDto(List.of(book), List.of(publisher));

        BookBundleDtoMapper mapper = new BookBundleDtoMapper(bookBundleDto);

        assertThrows(ValidationException.class, () -> mapper.toBundle());
    }

    @Test
    void bundle_with_invalid_price_is_rejected() {
        BookInfoDto book = new BookInfoDto("Refactoring", "Fowler", "978-1234567876");
        PublishedBookDto pubBook = new PublishedBookDto("Refactoring", "978-1234567876", -40.00,2002);
        PublisherDto publisher = new PublisherDto("O'Reilly", "USA", List.of(pubBook));
        BookBundleDto bookBundleDto = new BookBundleDto(List.of(book), List.of(publisher));

        BookBundleDtoMapper mapper = new BookBundleDtoMapper(bookBundleDto);

        assertThrows(ValidationException.class, () -> mapper.toBundle());
    }
}
