package finalexample.acl.mappers;

import finalexample.acl.dtos.BookDto;
import finalexample.domain.Isbn;

public class BookDtoMapper {
    BookDto bookDto;

    public BookDtoMapper(BookDto bookDto) {
        this.bookDto = bookDto;
    }

    public String toTitle() {
        return bookDto.getTitle();
    }

    public Isbn toIsbn() {
        return Isbn.validate(bookDto.getIsbn());
    }
}
