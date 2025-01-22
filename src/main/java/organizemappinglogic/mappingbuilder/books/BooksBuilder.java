package organizemappinglogic.mappingbuilder.books;

import organizemappinglogic.mappingbuilder.Book;

import java.util.ArrayList;
import java.util.List;

public class BooksBuilder {
    private List<Book> books;

    public BooksBuilder() {
        this.books = new ArrayList<>();
    }

    public BooksBuilder addBook(Book book) {
        this.books.add(book);
        return this;
    }

    public Books build() {
        return new Books(this.books);
    }
}
