package organizemappinglogic.mappingbuilder;

import org.junit.jupiter.api.Test;
import organizemappinglogic.mappingbuilder.domain.Book;
import organizemappinglogic.mappingbuilder.domain.Buyer;
import organizemappinglogic.mappingbuilder.domain.Isbn;
import organizemappinglogic.mappingbuilder.provider.BookDto;
import organizemappinglogic.mappingbuilder.provider.BuyerDto;
import organizemappinglogic.mappingbuilder.provider.BuyerMapperImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BuyerMapperTest {
    @Test
    void map_domain_object_to_dto_with_builder() {
        Isbn isbn1 = new Isbn("978-12345678761");
        Book book1 = new Book(isbn1, "I promessi sposi", "Manzoni", 1800);
        Isbn isbn2 = new Isbn("978-12345678762");
        Book book2 = new Book(isbn2, "Divina Commedia", "Dante", 1300);
        Buyer buyer = new Buyer("Mario Rossi", "mariorossi@googl.com", List.of(book1, book2));

        BuyerMapperImpl buyerMapper = new BuyerMapperImpl();
        buyer.mapWith(buyerMapper);

        BuyerDto buyerDto = buyerMapper.toBuyerDto();

        assertEquals("Mario Rossi", buyerDto.getName());
        assertEquals("mariorossi@googl.com", buyerDto.getEmail());

        BookDto bookDto1 = buyerDto.getBooks().get(0);
        assertEquals("978-12345678761", bookDto1.getIsbn());
        assertEquals("I promessi sposi", bookDto1.getTitle());
        assertEquals("Manzoni", bookDto1.getAuthor());

        BookDto bookDto2 = buyerDto.getBooks().get(1);
        assertEquals("978-12345678762", bookDto2.getIsbn());
        assertEquals("Divina Commedia", bookDto2.getTitle());
        assertEquals("Dante", bookDto2.getAuthor());
    }
}