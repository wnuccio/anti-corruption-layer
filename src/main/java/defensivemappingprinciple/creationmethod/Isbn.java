package defensivemappingprinciple.creationmethod;

import java.util.regex.Pattern;

class Isbn {
    private String value;

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
