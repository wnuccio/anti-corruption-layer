package modelrelationships.relatedfieldstoclass.example2;

import modelrelationships.relatedfieldstoclass.common.Currency;
import modelrelationships.relatedfieldstoclass.common.Price;

import java.util.List;

class DeliveredBooks {
    private List<Book> books;
    private Currency currency;

    Price priceOfBook(String title) {
        return books.stream()
                .filter(book -> book.title().equals(title))
                .findFirst()
                .map(book -> new Price(book.price(), currency))
                .orElseThrow();
    }
}
