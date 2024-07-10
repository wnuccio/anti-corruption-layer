package finalexample;

import finalexample.domain.Book;
import finalexample.domain.BookBundle;
import finalexample.domain.ValidationException;
import finalexample.dtos.BookBundleDto;
import finalexample.dtos.BookInfoDto;
import finalexample.dtos.PublishedBookDto;
import finalexample.dtos.PublisherDto;
import finalexample.mapping.BookBundleDtoMapper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BookBundleDtoMapperTest {

    @Test
    void map_book_bundle_dto_to_book_bundle() {
        BookInfoDto book1 = new BookInfoDto("Refactoring", "Fowler", "978-1234567876");
        BookInfoDto book2 = new BookInfoDto("Design Patterns", "Gof", "978-0201633610");

        PublishedBookDto pubBook1 = new PublishedBookDto("Refactoring", "978-1234567876", 40.00,2002);
        PublishedBookDto pubBook2 = new PublishedBookDto("Design Pattern", "978-0201633610", 30.00,2000);

        PublisherDto publisher1 = new PublisherDto("O'Reilly", "USA", List.of(pubBook1));
        PublisherDto publisher2 = new PublisherDto("Addison-Wesley", "USA", List.of(pubBook2));

        BookBundleDto bookBundleDto = new BookBundleDto(List.of(book1, book2), List.of(publisher1, publisher2));

        BookBundle actualBundle = new BookBundleDtoMapper(bookBundleDto).toBundle();

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
    void book_with_invalid_isbn_is_rejected() {
        BookInfoDto book = new BookInfoDto("Refactoring", "Fowler", "xxxx");
        PublishedBookDto pubBook = new PublishedBookDto("Refactoring", "xxxx", 40.00,2002);
        PublisherDto publisher = new PublisherDto("O'Reilly", "USA", List.of(pubBook));
        BookBundleDto bookBundleDto = new BookBundleDto(List.of(book), List.of(publisher));

        BookBundleDtoMapper mapper = new BookBundleDtoMapper(bookBundleDto);

        assertThrows(ValidationException.class, () -> mapper.toBundle());
    }

    @Test
    void book_with_isbn_not_referred_by_any_publisher_is_rejected() {
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
