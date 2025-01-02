package defensivemappingprinciple.factory;

import java.util.regex.Pattern;

public class IsbnFactory {

    public Isbn createIsbn(String value) {
        if (!Pattern.matches("^(?:\\d{9}X|\\d{10})$", value))
            throw new IllegalArgumentException("ISBN should have 10-13 digits!");

        return new Isbn(value);
    }
}

