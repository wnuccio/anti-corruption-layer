package nulltoemptycollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Book {
    String title;
    List<String> stores;

    private Book(String title, List<String> stores) {
        this.title = title;
        this.stores = stores;
    }

    public static Book of(String title, List<String> stores) {
        if (stores == null) {
            stores = new ArrayList<>();
        }

        return new Book(title, stores);
    }

    public List<String> stores() {
        return Collections.unmodifiableList(stores);
    }
}
