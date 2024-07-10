package finalexample;

import finalexample.domain.Book;
import finalexample.domain.BookBundle;
import finalexample.domain.Edition;
import finalexample.domain.Isbn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookBundleTest {

    @Test
    void retrieveTheEditionWithOneBookAndOnePublisher() {
        Book book = Book.builder()
                .title("Design Patterns")
                .isbn("978-0201633610")
                .publisher("Addison-Wesley")
                .year(1994)
                .price(30.00)
                .build();
        BookBundle bundle = new BookBundle(book);

        Isbn isbn = Isbn.validate("978-0201633610");
        Edition edition = bundle.editionOf(isbn);

        assertEquals(edition, new Edition("Design Patterns", "Addison-Wesley", 1994, 30.00));
    }

    @Test
    void retrieveTheEditionWithTwoBooksAndTwoPublishers() {
        Book book1 = Book.builder()
                .title("Refactoring")
                .isbn("978-1234567876")
                .publisher("O'Reilly")
                .year(2002)
                .price(40.00)
                .build();

        Book book2 = Book.builder()
                .title("Design Patterns")
                .isbn("978-0201633610")
                .publisher("Addison-Wesley")
                .year(2000)
                .price(30.00)
                .build();

        BookBundle bundle = new BookBundle(book1, book2);

        Isbn isbn = Isbn.validate("978-0201633610");
        Edition edition = bundle.editionOf(isbn);

        assertEquals(edition, new Edition("Design Patterns", "Addison-Wesley", 2000, 30.00));
    }
}