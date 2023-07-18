package ch7collectiontoclass;

import java.util.List;
import java.util.Optional;

public class Book {
    String title;
    String author;
    Bibliography bibliography;
}

class Bibliography {
    List<Reference> references;

    Optional<Reference> findReferenceBy(String text) {
        Reference reference =
                new Reference(); // some finding logic
        return Optional.of(reference);
    }
}

class Reference {
    String type;
    String name;
}
