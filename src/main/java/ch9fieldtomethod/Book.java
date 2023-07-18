package ch9fieldtomethod;

import java.util.List;

public class Book {
    String title;
    List<Page> pages;

    public boolean isDamaged() {
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
    boolean damaged;

    public boolean damaged() {
        return damaged;
    }
}
