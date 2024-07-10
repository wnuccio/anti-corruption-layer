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

    public PublishedBookBuilder publisher(Publisher publisher) {
        this.publisher = publisher;
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

    public PublishedBook build() {
        return new PublishedBook(title, isbn, publisher, year, price);
    }
}