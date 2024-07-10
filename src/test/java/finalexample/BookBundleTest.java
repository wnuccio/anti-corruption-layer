package finalexample;

import finalexample.model.BookBundle;
import finalexample.model.Edition;
import finalexample.model.PublishedBook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookBundleTest {

    /**
     * Book not present: exception
     * DONE
     * Retrieve the edition of a book with one book in the catalog and one publisher
     * Retrieve the edition of a book with two books and two publisher
     */

    @Test
    void retrieveTheEditionWithOneBookAndOnePublisher() {
        PublishedBook book = PublishedBook.builder()
                .title("Design Patterns")
                .isbn("978-0201633610")
                .publisher("Addison-Wesley")
                .year(1994)
                .price(30.00)
                .build();
        BookBundle bundle = new BookBundle(book);

        Edition edition = bundle.editionOf("978-0201633610");

        assertEquals(edition, new Edition("Design Patterns", "Addison-Wesley", 1994, 30.00));
    }

    @Test
    void retrieveTheEditionWithTwoBooksAndTwoPublishers() {
        PublishedBook book1 = PublishedBook.builder()
                .title("Refactoring")
                .isbn("978-1234567876")
                .publisher("O'Reilly")
                .year(2002)
                .price(40.00)
                .build();

        PublishedBook book2 = PublishedBook.builder()
                .title("Design Patterns")
                .isbn("978-0201633610")
                .publisher("Addison-Wesley")
                .year(2000)
                .price(30.00)
                .build();

        BookBundle bundle = new BookBundle(book1, book2);

        Edition edition = bundle.editionOf("978-0201633610");

        assertEquals(edition, new Edition("Design Patterns", "Addison-Wesley", 2000, 30.00));
    }
}