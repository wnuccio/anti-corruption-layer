package collectiontoclass;

import java.util.List;
import java.util.stream.Collectors;

public class Book {
    private String title;
    private String author;
    private Bibliography bibliography;
}

class Bibliography {
    private List<Reference> references;

    public List<Reference> findReferences(String keyword) {
        return references.stream()
                .filter(ref -> ref.contains(keyword))
                .collect(Collectors.toList());
    }
}

class Reference {
    private String author;
    private String title;
    private String keywords;

    public boolean contains(String keyword) {
        return keywords.contains(keyword);
    }
}
