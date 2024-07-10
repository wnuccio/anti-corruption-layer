package finalexample.model;

import java.util.Objects;

public class Book {
    private final String title;
    private final String isbn;
    private final Publisher publisher;
    private final int year;
    private final double price;

    public Book(String title, String isbn, Publisher publisher, int year, double price) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.year = year;
        this.price = price;
    }

    public static PublishedBookBuilder builder() {
        return new PublishedBookBuilder();
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

    public double price() {
        return price;
    }

    public boolean hasIsbn(String isbn) {
        return this.isbn.equals(isbn);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book that = (Book) o;
        return year == that.year && Double.compare(price, that.price) == 0 && Objects.equals(title, that.title) && Objects.equals(isbn, that.isbn) && Objects.equals(publisher, that.publisher);
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
