package ch14identifiertoreference;

import java.util.List;
import java.util.stream.Collectors;

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

class DeliveredBook {
    Book book;
    Person person;

    public boolean isDeliveredTo(String personName) {
        return person.hasName(personName);
    }
}

class DeliveredBooks {
    List<DeliveredBook> deliveredBooks;

    List<DeliveredBook> findAllBooksDeliveredTo(String personName) {
        return deliveredBooks.stream()
                .filter(deliveredBook -> deliveredBook.isDeliveredTo(personName))
                .collect(Collectors.toList());
    }
}



