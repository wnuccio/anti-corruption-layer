package modelconcepts.rawtovalidated;

import java.util.regex.Pattern;

public class Book {
    String title;
    ISBN isbn;
}

class ISBN {
    String value;

    private ISBN(String value) {
        this.value = value;
    }

    public static ISBN of(String code) {
        if ( ! isValidIsbn(code)) throw new IllegalArgumentException(
                "ISBN should have 10-13 digits!");

        return new ISBN(code);
    }

    public static boolean isValidIsbn(String code) {
        return Pattern.matches("^(?:\\d{9}X|\\d{10})$", code);
    }
}
