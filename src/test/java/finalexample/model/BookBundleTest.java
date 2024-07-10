package finalexample.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookBundleTest {

    /**
     * Retrieve the edition of a book with one book and two publishers
     * Retrieve the edition of a book with two books and two publisher
     * Book not present: exception
     * DONE
     * Retrieve the edition of a book with one book in the catalog and one publisher
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
}