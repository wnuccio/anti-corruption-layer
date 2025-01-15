package modelconcepts.rawtovalidated;

import java.util.regex.Pattern;

public class Book {
    String title;
    Isbn isbn;
}

class Isbn {
    String value;

    private Isbn(String value) {
        this.value = value;
    }

    public static Isbn of(String code) {
        if ( ! isValidIsbn(code)) throw new IllegalArgumentException(
                "ISBN should have 10-13 digits!");

        return new Isbn(code);
    }

    public static boolean isValidIsbn(String code) {
        return Pattern.matches("^(?:\\d{9}X|\\d{10})$", code);
    }
}
