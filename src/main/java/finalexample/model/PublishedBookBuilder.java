package finalexample.model;

public class PublishedBookBuilder {
    private String title;
    private String isbn;
    private Publisher publisher;
    private int year;
    private double price;

    public PublishedBookBuilder title(String title) {
        this.title = title;
        return this;
    }

    public PublishedBookBuilder isbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public PublishedBookBuilder publisher(String publisherName) {
        this.publisher = new Publisher(publisherName);
        return this;
    }

    public PublishedBookBuilder year(int year) {
        this.year = year;
        return this;
    }

    public PublishedBookBuilder price(double price) {
        this.price = price;
        return this;
    }

    public Book build() {
        return new Book(title, isbn, publisher, year, price);
    }
}