package finalexample.domain;

import java.util.List;

public interface BookService {
    BookBundle retrieveBooks(String keyword);

    BookBundle retrieveBooks(List<String> keywords);
}
