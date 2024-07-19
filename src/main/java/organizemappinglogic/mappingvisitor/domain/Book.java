package organizemappinglogic.mappingvisitor.domain;

public class Book {
    Isbn isbn;
    String title;
    String author;
    int year;

    public Book(Isbn isbn, String title, String author, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public void mapWith(BookMapper bookMapper) {
        bookMapper.title(title)
                .author(author);

        isbn.mapWith(bookMapper);
    }
}
