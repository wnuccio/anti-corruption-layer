package finalexample.acl.mappers;

import finalexample.acl.dtos.BookDto;
import finalexample.domain.Isbn;

public class BookDtoMapper {
    private final String title;
    private final String isbn;

    public BookDtoMapper(BookDto bookDto) {
        this.title = bookDto.getTitle();
        this.isbn = bookDto.getIsbn();
    }

    public String toTitle() {
        return title;
    }

    public Isbn toIsbn() {
        return Isbn.validate(isbn);
    }
}
