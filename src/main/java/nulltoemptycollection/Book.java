package nulltoemptycollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Book {
    String title;
    String author;
    List<Reference> references;

    public List<Reference> references() {
        return references == null ?
                new ArrayList<>() :
                Collections.unmodifiableList(references);
    }
}

class Reference {
    String type;
    String name;
}
