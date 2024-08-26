package finalexample.domain;

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

    public Price price() {
        return price;
    }

    public boolean hasIsbn(Isbn isbn) {
        return this.isbn.equals(isbn);
    }

    public boolean publishedAfter(int year) {
        return this.year > year;
    }

    public boolean hasTitle(String title) {
        return this.title.equals(title);
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
