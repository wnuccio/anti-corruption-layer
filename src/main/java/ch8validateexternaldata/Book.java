package ch8validateexternaldata;

public class Book {
    String title;
    ISBN isbn;
}

class ISBN {
    String value; // mandatory

    public ISBN(String value) {
        this.value = value;

        if (value == null || value.isBlank())
            throw new IllegalArgumentException("ISBN is mandatory!");
        if (! isValidIsbn(value))
            throw new IllegalArgumentException("ISBN should have 10-13 digits!");
    }

    public static boolean isValidIsbn(String value) {
        // check with some regular expression
        return true;
    }
}
