package organizemappinglogic.mappingbuilder.acl;

import organizemappinglogic.mappingbuilder.domain.BookMapper;

public class BookMapperImpl implements BookMapper {
    private final BookDto bookDto = new BookDto();

    @Override
    public BookMapper title(String title) {
        bookDto.setTitle(title);
        return this;
    }

    @Override
    public BookMapper author(String author) {
        bookDto.setAuthor(author);
        return this;
    }

    @Override
    public void isbn(String value) {
        bookDto.setIsbn(value);
    }

    public BookDto toBookDto() {
        return bookDto;
    }
}
