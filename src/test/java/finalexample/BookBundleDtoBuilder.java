package finalexample;

import finalexample.acl.dtos.BookBundleDto;
import finalexample.acl.dtos.BookInfoDto;
import finalexample.acl.dtos.PublishedBookDto;
import finalexample.acl.dtos.PublisherDto;

import java.util.List;

public class BookBundleDtoBuilder {

    private String isbn;

    public BookBundleDtoBuilder addBookWithIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public BookBundleDto build() {
        BookInfoDto book = new BookInfoDto("Refactoring", "Fowler", isbn);

        PublishedBookDto pubBook = new PublishedBookDto("Refactoring", isbn, 40.00,2002);

        PublisherDto publisher = new PublisherDto("O'Reilly", "USA", List.of(pubBook));

        return new BookBundleDto(List.of(book), List.of(publisher));
    }
}
