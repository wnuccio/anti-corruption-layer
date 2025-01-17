package transformresponse.manyresponsestooneclass.example;

import java.util.Date;

public class Book {
    private final String title;
    private final String author;
    private final Date publicationDate;
    private final Date deliveryDate;

    public Book(String title, String author, Date publicationDate, Date deliveryDate) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.deliveryDate = deliveryDate;
    }
}
