package modeloptionality.nulltoemptycollection;

import java.util.List;

public class Example {

    public int storesCount(Book book) {
        List<String> stores = book.stores();

        if (stores == null) return 0;

        return stores.size();
    }
}
