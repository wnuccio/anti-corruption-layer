package modeloptionality.embeddednull.wrong;

public class Book {
    String title;
    String publisher;

    public String publisher() {
        return publisher; // a potential null is returned
    }
}
