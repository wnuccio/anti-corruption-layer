package nulltoemptycollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Book {
    String title;
    List<String> stores;

    public List<String> stores() {
        return stores == null ?
                new ArrayList<>() :
                Collections.unmodifiableList(stores);
    }
}
