package finalexample.provider.mappers;

import finalexample.domain.Isbn;
import finalexample.domain.Price;
import finalexample.provider.dtos.PublishedBookDto;

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

    public Price toPrice() {
        return Price.ofEuros(publishedBookDto.getPrice());
    }
}
