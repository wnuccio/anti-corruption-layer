package finalexample.acl.mappers;

import finalexample.acl.dtos.PublishedBookDto;
import finalexample.domain.Isbn;
import finalexample.domain.Price;

public class PublishedBookDtoMapper {
    private final String isbn;
    private final double price;
    private final int year;

    public PublishedBookDtoMapper(PublishedBookDto publishedBookDto) {
        this.isbn = publishedBookDto.getIsbn();
        this.price = publishedBookDto.getPrice();
        this.year = publishedBookDto.getYear();
    }

    public boolean hasIsbn(Isbn isbn) {
        return isbn.hasValue(this.isbn);
    }

    public Price toPrice() {
        return Price.ofEuros(price);
    }

    public int toYear() {
        return year;
    }
}
