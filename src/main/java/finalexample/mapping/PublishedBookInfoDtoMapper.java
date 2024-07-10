package finalexample.mapping;

import finalexample.domain.Isbn;
import finalexample.dtos.PublishedBookDto;

public class PublishedBookInfoDtoMapper {
    private final PublishedBookDto publishedBookDto;

    public PublishedBookInfoDtoMapper(PublishedBookDto publishedBookDto) {
        this.publishedBookDto = publishedBookDto;
    }

    public boolean hasIsbn(Isbn isbn) {
        return publishedBookDto.getIsbn().equals(isbn.asString());
    }

    public int toYear() {
        return publishedBookDto.getYear();
    }

    public double toPrice() {
        return publishedBookDto.getPrice();
    }
}
