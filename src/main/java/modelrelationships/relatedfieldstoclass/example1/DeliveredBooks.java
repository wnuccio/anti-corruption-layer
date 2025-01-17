package modelrelationships.relatedfieldstoclass.example1;

import modelrelationships.relatedfieldstoclass.common.Price;

import java.util.List;

class DeliveredBooks {
    private List<Book> books;

    public Price priceOfBook(String title) {
        return books.stream()
                .filter(book -> book.title().equals(title))
                .findFirst()
                .map(Book::price)
                .orElseThrow();
    }
}
