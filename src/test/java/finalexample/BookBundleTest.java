package finalexample;

import finalexample.model.BookBundle;
import finalexample.model.Edition;
import finalexample.model.PublishedBook;
import finalexample.model.Publisher;
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
        Publisher publisher = new Publisher("Addison-Wesley");
        BookBundle bundle = new BookBundle(
                new PublishedBook("Design Patterns", "Gof", "978-0201633610", publisher, 1994, 30.00)
        );

        Edition edition = bundle.editionOf("978-0201633610");

        assertEquals(edition, new Edition("Design Patterns", "Addison-Wesley", 1994, 30.00));
    }

    @Test
    void retrieveTheEditionWithOneBookAndTwoPublishers() {
        Publisher publisher1 = new Publisher("O'Reilly");
        Publisher publisher2 = new Publisher("Addison-Wesley");

        BookBundle bundle = new BookBundle(
                new PublishedBook("Refactoring", "Fowler", "978-1234567876", publisher1, 2002, 40.00),
                new PublishedBook("Design Patterns", "Gof", "978-0201633610", publisher2, 2000, 30.00)
        );

        Edition edition = bundle.editionOf("978-0201633610");

        assertEquals(edition, new Edition("Design Patterns", "Addison-Wesley", 2000, 30.00));
    }
}