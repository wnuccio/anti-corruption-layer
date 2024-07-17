package organizemappinglogic.mappingbuilder.acl;

import organizemappinglogic.mappingbuilder.domain.Book;
import organizemappinglogic.mappingbuilder.domain.BuyerMapper;

import java.util.ArrayList;
import java.util.List;

public class BuyerMapperImpl implements BuyerMapper {
    BuyerDto buyerDto = new BuyerDto();

    public BuyerDto toBuyerDto() {
        return buyerDto;
    }

    @Override
    public BuyerMapper name(String name) {
        buyerDto.setName(name);
        return this;
    }

    @Override
    public BuyerMapper email(String email) {
        buyerDto.setEmail(email);
        return this;
    }

    @Override
    public void books(List<Book> books) {
        List<BookDto> bookDtos = new ArrayList<>();
        for (Book book : books) {
            BookMapperImpl bookMapper = new BookMapperImpl();
            book.mapWith(bookMapper);
            bookDtos.add(bookMapper.toBookDto());
        }
        buyerDto.setBooks(bookDtos);
    }
}
