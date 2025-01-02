package defensivemappingprinciple.constructor;

import java.util.regex.Pattern;

public class Isbn {
    private String value;

    private Isbn(String value) {
        if (!Pattern.matches("^(?:\\d{9}X|\\d{10})$", value))
            throw new IllegalArgumentException("ISBN should have 10-13 digits!");

        this.value = value;
    }
}

