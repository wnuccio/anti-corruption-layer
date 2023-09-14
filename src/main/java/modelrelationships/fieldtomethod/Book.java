package modelrelationships.fieldtomethod;

import java.util.List;

public class Book {
    String title;
    List<Page> pages;

    public boolean isPartiallyDamaged() {
        return pages
                .stream()
                .anyMatch(Page::damaged);
    }

    public boolean isTotallyDamaged() {
        return pages
                .stream()
                .allMatch(Page::damaged);
    }
}

class Page {
    int num;
    boolean damaged;

    public boolean damaged() {
        return damaged;
    }
}
