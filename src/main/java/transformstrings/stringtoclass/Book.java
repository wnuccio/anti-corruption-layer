package transformstrings.stringtoclass;

public class Book {
    private String title;
    private ISBN isbn;
}

class ISBN {
    private String value;

    public String prefix() {
        return value.substring(0, 2);
    }
}

class SomeService {
    void someFunction(ISBN aBook, String aPerson) {
    }
}

