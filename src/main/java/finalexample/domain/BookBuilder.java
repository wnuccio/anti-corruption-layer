package finalexample.domain;

public class BookBuilder {
    private String title;
    private String isbn;
    private String publisher;
    private int year;
    private double price;

    public BookBuilder title(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder isbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public BookBuilder publisher(String publisherName) {
        this.publisher = publisherName;
        return this;
    }

    public BookBuilder year(int year) {
        this.year = year;
        return this;
    }

    public BookBuilder price(double price) {
        this.price = price;
        return this;
    }

    public Book build() {
        return new Book(title, Isbn.validate(isbn), new Publisher(publisher), new Year(year), Price.ofEuros(price));
    }
}