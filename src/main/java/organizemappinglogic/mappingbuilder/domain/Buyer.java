package organizemappinglogic.mappingbuilder.domain;

import java.util.List;

public class Buyer {
    String name;
    String email;
    List<Book> books;

    public Buyer(String name, String email, List<Book> books) {
        this.name = name;
        this.email = email;
        this.books = books;
    }

    public void mapWith(BuyerMapper buyerMapper) {
        buyerMapper.name(name)
                .email(email)
                .books(books);
    }
}
