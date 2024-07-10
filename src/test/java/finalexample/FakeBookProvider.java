package finalexample;

import finalexample.provider.BookBundleDto;
import finalexample.provider.BookInfoDto;
import finalexample.provider.BookProvider;
import finalexample.provider.PublishedBookDto;
import finalexample.provider.PublisherDto;

import java.util.List;

public class FakeBookProvider implements BookProvider {
    private final String isbn;

    private final BookBundleDto bookBundleDto;

    public FakeBookProvider(String isbn) {
        this.isbn = isbn;

        BookInfoDto book1 = new BookInfoDto("Refactoring", "Fowler", "978-1234567876");
        BookInfoDto book2 = new BookInfoDto("Design Patterns", "Gof", "978-0201633610");

        PublishedBookDto pubBook1 = new PublishedBookDto("Refactoring", "978-1234567876", 40.00,2002);
        PublishedBookDto pubBook2 = new PublishedBookDto("Design Pattern", "978-0201633610", 30.00,2000);

        PublisherDto publisher1 = new PublisherDto("O'Reilly", "USA", List.of(pubBook1));
        PublisherDto publisher2 = new PublisherDto("Addison-Wesley", "USA", List.of(pubBook2));

        this.bookBundleDto = new BookBundleDto(List.of(book1, book2), List.of(publisher1, publisher2));

//        this.bundle = new BookBundle(
//                Book.builder()
//                        .title("Refactoring")
//                        .isbn("978-1234567876")
//                        .publisher("O'Reilly")
//                        .year(2002)
//                        .price(40.00)
//                        .build(),
//                Book.builder()
//                        .title("Design Patterns")
//                        .isbn("978-0201633610")
//                        .publisher("Addison-Wesley")
//                        .year(2000)
//                        .price(30.00)
//                        .build());
    }

    @Override
    public BookBundleDto getBundle(String isbn) {
        if (this.isbn.equals(isbn)) {
            return bookBundleDto;
        }

        return bookBundleDto;
    }
}
