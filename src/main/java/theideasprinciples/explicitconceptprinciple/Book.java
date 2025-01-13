package theideasprinciples.explicitconceptprinciple;

import java.util.Optional;

public class Book {
    private String title;
    private String publisher;
    private Genre genre;
    private Price price;
    private Isbn isbn;

    public Optional<String> publisher() {
        return Optional.ofNullable(publisher);
    }
}
