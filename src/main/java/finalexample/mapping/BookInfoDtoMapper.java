package finalexample.mapping;

import finalexample.dtos.BookInfoDto;
import finalexample.model.Isbn;

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
