package finalexample.acl.dtos;

import java.util.List;

public class BookResponseDto {
    List<BookDto> books;
    List<PublisherDto> publishers;

    public BookResponseDto(List<BookDto> books, List<PublisherDto> publishers) {
        this.books = books;
        this.publishers = publishers;
    }

    public List<BookDto> getBooks() {
        return books;
    }

    public List<PublisherDto> getPublishers() {
        return publishers;
    }
}
