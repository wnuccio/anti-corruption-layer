package finalexample.acl.mappers;

import finalexample.acl.dtos.PublishedBookDto;
import finalexample.domain.Isbn;
import finalexample.domain.Price;

public class PublishedBookDtoMapper {
    private final PublishedBookDto publishedBookDto;

    public PublishedBookDtoMapper(PublishedBookDto publishedBookDto) {
        this.publishedBookDto = publishedBookDto;
    }

    public boolean hasIsbn(Isbn isbn) {
        return publishedBookDto.getIsbn().equals(isbn.asString());
    }

    public int toYear() {
        return publishedBookDto.getYear();
    }

    public Price toPrice() {
        return Price.ofEuros(publishedBookDto.getPrice());
    }
}
