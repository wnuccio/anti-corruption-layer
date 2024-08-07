package finalexample.domain;

import java.util.Objects;

public class Book {
    private final String title;
    private final Isbn isbn;
    private final Publisher publisher;
    private final int year;
    private final Price price;

    public Book(String title, Isbn isbn, Publisher publisher, int year, Price price) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.year = year;
        this.price = price;
    }

    public static BookBuilder builder() {
        return new BookBuilder();
    }

    public String title() {
        return this.title;
    }

    public String publisherName() {
        return publisher.name();
    }

    public int year() {
        return year;
    }

    public Price price() {
        return price;
    }

    public boolean hasIsbn(Isbn isbn) {
        return this.isbn.equals(isbn);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book that = (Book) o;
        return year == that.year && Objects.equals(price, that.price) && Objects.equals(title, that.title) && Objects.equals(isbn, that.isbn) && Objects.equals(publisher, that.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, isbn, publisher, year, price);
    }

    @Override
    public String toString() {
        return "PublishedBook{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publisher=" + publisher +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
