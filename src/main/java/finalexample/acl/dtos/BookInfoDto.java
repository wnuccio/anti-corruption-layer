package finalexample.acl.dtos;

import java.util.List;

import static java.util.Collections.singletonList;

public class BookInfoDto {
    String title;
    String author;
    String isbn;
    List<String> keywords;

    public BookInfoDto(String title, String author, String isbn, List<String> keywords) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.keywords = keywords;
    }

    public BookInfoDto(String title, String author, String isbn, String keyword) {
        this(title, author, isbn, singletonList(keyword));
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

    public List<String> getKeywords() {
        return keywords;
    }
}
