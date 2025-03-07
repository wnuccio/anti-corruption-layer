package finalexample.acl.mappers;

import finalexample.acl.dtos.EditionDto;
import finalexample.domain.Isbn;
import finalexample.domain.Price;
import finalexample.domain.Year;

public class EditionDtoMapper {
    private final String isbn;
    private final double price;
    private final int year;

    public EditionDtoMapper(EditionDto editionDto) {
        this.isbn = editionDto.getIsbn();
        this.price = editionDto.getPrice();
        this.year = editionDto.getYear();
    }

    public boolean hasIsbn(Isbn isbn) {
        return isbn.hasValue(this.isbn);
    }

    public Price toPrice() {
        return Price.ofEuros(price);
    }

    public Year toYear() {
        return new Year(year);
    }
}
