package finalexample;

import finalexample.acl.BookProviderAdapter;
import finalexample.acl.dtos.BookBundleDto;
import finalexample.acl.dtos.BookInfoDto;
import finalexample.acl.dtos.PublishedBookDto;
import finalexample.acl.dtos.PublisherDto;
import finalexample.domain.Book;
import finalexample.domain.BookBundle;
import finalexample.domain.BookService;
import finalexample.domain.Isbn;
import finalexample.domain.ValidationException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BookProviderAdapterTest {

    @Test
    void retrieve_book_bundle_with_two_books_by_isbn_list() {
        FakeBookProvider bookProvider = new FakeBookProvider();
        BookService bookService = new BookProviderAdapter(bookProvider);
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
        Isbn isbn1 = Isbn.validate("978-1234567876");
        Isbn isbn2 = Isbn.validate("978-0201633610");

        BookBundle actualBundle = bookService.retrieveBook(List.of(isbn1, isbn2));

        assertEquals(expectedBundle, actualBundle);
    }

    @Test
    void bundle_with_invalid_isbn_is_rejected() {
        BookBundleDto bundleDto = new BookBundleDtoBuilder()
                .addBookWithIsbn("xxxx 978-0201633610 xxxx") // invalid isbn
                .build();
        FakeBookProvider bookProvider = new FakeBookProvider(bundleDto);
        BookService bookService = new BookProviderAdapter(bookProvider);
        Isbn isbn = Isbn.validate("978-0201633610");

        assertThrows(ValidationException.class, () -> bookService.retrieveBook(isbn));
    }

    @Test
    void bundle_with_isbn_not_referred_by_any_publisher_is_rejected() {
        BookInfoDto bookInfoDto = new BookInfoDto("Refactoring", "Fowler", "978-1234567876");
        PublishedBookDto publishedBookDto = new PublishedBookDto("Refactoring",
                "978-1111111111", // wrong isbn
                40.00,
                2002);
        PublisherDto publisherDto = new PublisherDto("O'Reilly", "USA", List.of(publishedBookDto));
        BookBundleDto bookBundleDto = new BookBundleDto(List.of(bookInfoDto), List.of(publisherDto));
        FakeBookProvider bookProvider = new FakeBookProvider(bookBundleDto);
        BookService bookService = new BookProviderAdapter(bookProvider);
        Isbn isbn = Isbn.validate("978-1234567876");

        assertThrows(ValidationException.class, () -> bookService.retrieveBook(isbn));
    }

    @Test
    void bundle_with_invalid_price_is_rejected() {
        BookInfoDto bookInfoDto = new BookInfoDto("Refactoring", "Fowler", "978-1234567876");
        PublishedBookDto publishedBookDto = new PublishedBookDto("Refactoring",
                "978-1234567876",
                -40.00, // negative price
                2002);
        PublisherDto publisher = new PublisherDto("O'Reilly", "USA", List.of(publishedBookDto));
        BookBundleDto bookBundleDto = new BookBundleDto(List.of(bookInfoDto), List.of(publisher));
        FakeBookProvider bookProvider = new FakeBookProvider(bookBundleDto);
        BookService bookService = new BookProviderAdapter(bookProvider);
        Isbn isbn = Isbn.validate("978-1234567876");

        assertThrows(ValidationException.class, () -> bookService.retrieveBook(isbn));
    }
}
