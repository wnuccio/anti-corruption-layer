package finalexample.acl.mappers;

import finalexample.acl.dtos.BookInfoDto;
import finalexample.domain.Isbn;

public class BookInfoDtoMapper {
    BookInfoDto bookInfoDto;

    public BookInfoDtoMapper(BookInfoDto bookInfoDto) {
        this.bookInfoDto = bookInfoDto;
    }

    public String toTitle() {
        return bookInfoDto.getTitle();
    }

    public Isbn toIsbn() {
        return Isbn.validate(bookInfoDto.getIsbn());
    }
}
