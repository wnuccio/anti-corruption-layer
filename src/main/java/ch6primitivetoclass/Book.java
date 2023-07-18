package ch6primitivetoclass;

import java.util.Optional;

public class Book {
    String title;
    Price price;
    Price suggestedPrice;
    ISBN isbn;
}

class Price {
    Double value;

    public Optional<Double> euros() {
        return Optional.ofNullable(value);
    }
}

class ISBN {
    String value; // can be null or empty

    public Optional<String> code() {
        return Optional.ofNullable(value)
                .filter(value -> ! value.isBlank());
    }
}
