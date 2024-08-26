package finalexample.acl.dtos;

import java.util.List;

public class BookBundleDto {
    List<BookDto> books;
    List<PublisherDto> publishers;

    public BookBundleDto(List<BookDto> books, List<PublisherDto> publishers) {
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
