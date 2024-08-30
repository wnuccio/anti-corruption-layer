package modeloptionality.embeddednull;

public class Edition {
    private int year;
    private Publisher publisher;

    public Edition(int year, Publisher publisher) {
        this.year = year;
        this.publisher = publisher.presentOrThrow();
    }
}
