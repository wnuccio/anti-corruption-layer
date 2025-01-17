package modelrelationships.relatedfieldstoclass.namesurname;

public class Book {
    private Person author;
    private Person reviewer;

    public String authorName() {
        return author.fullName();
    }

    public String reviewerName() {
        return reviewer.fullName();
    }
}
