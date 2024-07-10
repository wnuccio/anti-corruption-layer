package finalexample.model;

public class BookBundle {
    private final PublishedBook publishedBook;

    public BookBundle(PublishedBook publishedBook) {
        this.publishedBook = publishedBook;
    }

    public Edition editionOf(String isbn) {
        return new Edition(
                publishedBook.title(),
                publishedBook.publisherName(),
                publishedBook.year(),
                publishedBook.price());
    }
}
