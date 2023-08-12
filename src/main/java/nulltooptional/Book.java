package nulltooptional;

import java.util.Optional;

public class Book {
    String title;
    String author;

    String publisher;

    public Optional<String> publisher() {
        return Optional.ofNullable(publisher);
    }
}
