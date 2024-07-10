package finalexample.model;

import java.util.Objects;

public class Edition {
    private final String title;
    private final String publisher;
    private final int year;
    private final double price;

    public Edition(String title, String publisher, int year, double price) {
        this.title = title;
        this.publisher = publisher;
        this.year = year;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edition edition = (Edition) o;
        return year == edition.year && Double.compare(price, edition.price) == 0 && Objects.equals(title, edition.title) && Objects.equals(publisher, edition.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, publisher, year, price);
    }

    @Override
    public String toString() {
        return "Edition{" +
                "title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
