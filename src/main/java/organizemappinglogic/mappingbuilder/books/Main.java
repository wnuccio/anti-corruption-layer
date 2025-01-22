package organizemappinglogic.mappingbuilder.books;

import organizemappinglogic.mappingbuilder.BookBuilder;

public class Main {

    public Books buildBooks() {
        return new BooksBuilder()
                .addBook(new BookBuilder()
                        .withTitle("The Lord of the Rings")
                        .build())
                .addBook(new BookBuilder()
                        .withTitle("Game of Thrones")
                        .build())
                .build();
    }
}
