package finalexample;

import finalexample.dtos.BookBundleDto;
import finalexample.dtos.BookInfoDto;
import finalexample.dtos.PublishedBookInfoDto;
import finalexample.dtos.PublisherDto;
import finalexample.mapping.BookBundleDtoMapper;
import finalexample.model.BookBundle;
import finalexample.model.PublishedBook;
import finalexample.model.Publisher;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookBundleDtoMapperTest {

    @Test
    void mapBookBundleDtoToBookBundle() {
        BookInfoDto book1 = new BookInfoDto("Refactoring", "Fowler", "978-1234567876");
        BookInfoDto book2 = new BookInfoDto("Design Patterns", "Gof", "978-0201633610");

        PublishedBookInfoDto pubBook1 = new PublishedBookInfoDto("Refactoring", "978-1234567876", 40.00,2002);
        PublishedBookInfoDto pubBook2 = new PublishedBookInfoDto("Design Pattern", "978-0201633610", 30.00,2000);

        PublisherDto publisher1 = new PublisherDto("O'Reilly", "USA", List.of(pubBook1));
        PublisherDto publisher2 = new PublisherDto("Addison-Wesley", "USA", List.of(pubBook2));

        BookBundleDto bookBundleDto = new BookBundleDto(List.of(book1, book2), List.of(publisher1, publisher2));


        BookBundle actualBundle = new BookBundleDtoMapper(bookBundleDto).toBundle();

        BookBundle expectedBundle = new BookBundle(
                PublishedBook.builder()
                        .title("Refactoring")
                        .isbn("978-1234567876")
                        .publisher(new Publisher("O'Reilly"))
                        .year(2002)
                        .price(40.00)
                        .build(),
                PublishedBook.builder()
                        .title("Design Patterns")
                        .isbn("978-0201633610")
                        .publisher(new Publisher("Addison-Wesley"))
                        .year(2000)
                        .price(30.00)
                        .build());

        assertEquals(expectedBundle, actualBundle);
    }
}
