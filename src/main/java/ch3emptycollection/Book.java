package ch3emptycollection;

import java.util.ArrayList;
import java.util.List;

public class Book {
    String title;
    String author;
    List<Reference> references;

    public Book(String title,
                String author,
                List<Reference> references) {

        this.title = title;
        this.author = author;
        this.references = references == null ?
                new ArrayList<>() : references;
    }
}

class Reference {
    String type;
    String name;
}
