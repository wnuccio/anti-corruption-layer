package organizemappinglogic.mappingbuilder;

import org.junit.jupiter.api.Test;

class BookBuilderTest {

    @Test
    void testBuilder() {

        Book book = new BookBuilder()
                .withTitle("The Hobbit")
                .withIsbn("978-3-86680-192-9")
                .withPrice(30, "EUR")
                .build();

    }
}