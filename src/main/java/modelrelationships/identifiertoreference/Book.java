package modelrelationships.identifiertoreference;

import java.util.List;
import java.util.stream.Collectors;

class DeliveredBooks {
    List<DeliveredBook> books;

    List<DeliveredBook> findAllBooksDeliveredTo(String personName) {
        return books.stream()
                .filter(book -> book.isDeliveredTo(personName))
                .collect(Collectors.toList());
    }
}

class DeliveredBook {
    Book book;
    Person person;

    public boolean isDeliveredTo(String personName) {
        return person.hasName(personName);
    }
}

class Person {
    String name;
    String address;

    public boolean hasName(String personName) {
        return this.name.equals(personName);
    }
}

class Book {
    String title;
}




