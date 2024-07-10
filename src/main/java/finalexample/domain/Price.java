package finalexample.domain;

import java.util.Objects;

public class Price {

    private final double euros;

    private Price(double euros) {
        this.euros = euros;
    }

    public static Price ofEuros(double euros) {
        return new Price(euros);
    }

    public double euros() {
        return this.euros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Double.compare(euros, price.euros) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(euros);
    }

    @Override
    public String toString() {
        return "Price{" +
                "euros=" + euros +
                '}';
    }
}
