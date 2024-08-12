package organizemappinglogic.mappingbuilder;

public class Book {
    private String title;
    private Isbn isbn;
    private Price price;

    public Book(String title, Isbn isbn, Price price) {
        this.title = title;
        this.isbn = isbn;
        this.price = price;
    }
}

