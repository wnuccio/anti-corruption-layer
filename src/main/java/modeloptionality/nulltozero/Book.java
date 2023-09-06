package modeloptionality.nulltozero;

public class Book {
    String title;
    Integer price;

    private Book(String title, Integer price) {
        this.title = title;
        this.price = price;
    }

    static Book createBook(String title, Integer price) {
        if (price == null) {
            price = 0;
        }

        return new Book(title, price);
    }

    public Integer price() {
        return price;
    }
}
