package finalexample.provider.mappers;

import finalexample.domain.Isbn;
import finalexample.provider.dtos.BookInfoDto;

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
