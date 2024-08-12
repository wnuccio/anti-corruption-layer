package organizemappinglogic.mappingbuilder;

import static organizemappinglogic.mappingbuilder.Price.Currency.EUR;
import static organizemappinglogic.mappingbuilder.Price.Currency.USD;

public class BookBuilder {
    private String title;
    private Isbn isbn;
    private Price price;

    public BookBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder withIsbn(String isbn) {
        this.isbn = Isbn.of(isbn);
        return this;
    }

    public BookBuilder withPrice(double amount, String currencyString) {
        Price.Currency currency;
        String normalizedCurrency = currencyString.toUpperCase();

        switch (normalizedCurrency) {
            case "EUR": currency = EUR; break;
            case "USD": currency = USD; break;
            default: throw new IllegalArgumentException("Unknown currency: " + currencyString);
        };

        this.price = new Price(amount, currency);
        return this;
    }

    public Book build() {
        return new Book(title, isbn, price);
    }
}
