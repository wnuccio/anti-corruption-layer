package organizemappinglogic.mappingbuilder;

public class Book {
    private String title;
    private Isbn isbn;
    private Price price;
    private Author author;

    public Book(String title, Isbn isbn, Price price, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.price = price;
        this.author = author;
    }
}

