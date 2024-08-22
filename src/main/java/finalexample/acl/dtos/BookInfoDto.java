package finalexample.acl.dtos;

public class BookInfoDto {
    String title;
    String author;
    String isbn;

    public BookInfoDto(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

}
