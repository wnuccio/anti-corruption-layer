package organizemappinglogic.mappingbuilder;

import org.junit.jupiter.api.Test;

class BookBuilderTest {

    @Test
    void testBuilder() {
        new BookBuilder()
                .withTitle("The Hobbit")
                .withIsbn("123456789X")
                .withPrice(30, "EUR")
                .withAuthorName("John Ronald Reuen")
                .witAuthorSurname("Tolkien")
                .build();
    }
}