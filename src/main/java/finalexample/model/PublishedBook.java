package finalexample.model;

public class PublishedBook {
    private final String title;
    private final Publisher publisher;
    private final int year;
    private final double price;

    public PublishedBook(String title, String author, String isbn, Publisher publisher, int year, double price) {
        this.title = title;
        this.publisher = publisher;
        this.year = year;
        this.price = price;
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
}
