package finalexample.domain;

import java.util.List;

public interface BookService {
    BookBundle retrieveBook(Isbn isbn);

    BookBundle retrieveBook(List<Isbn> isbnList);
}
