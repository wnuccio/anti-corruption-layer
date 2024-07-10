package finalexample.provider.dtos;

public class PublishedBookDto {
    String title;
    String isbn;
    double price;
    int year;

    public PublishedBookDto(String title, String isbn, double price, int year) {
        this.title = title;
        this.isbn = isbn;
        this.year = year;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }
}
