package modelconcepts.collectiontoclass;

import java.util.List;
import java.util.stream.Collectors;

public class Book {
    String title;
    String author;
    Bibliography bibliography;
}

class Bibliography {
    List<Reference> references;

    public List<Reference> findReferences(String keyword) {
            return references.stream()
                .filter(reference -> reference.hasKeyword(keyword))
                .collect(Collectors.toList());
    }
}

class Reference {
    String title;
    String author;
    String keywords;

    public boolean hasKeyword(String keyword) {
        return keywords.contains(keyword);
    }
}
