package finalexample;

import finalexample.domain.Book;
import finalexample.domain.BookBundle;
import finalexample.domain.Isbn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookBundleTest {
    @Test
    void find_book_from_bundle_with_two_books_and_two_publishers() {
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

        Book found = bundle.find(Isbn.validate("978-0201633610"));

        assertEquals(found, book2);
    }
}