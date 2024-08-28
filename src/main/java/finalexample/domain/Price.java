package finalexample.domain;

public class Price implements Comparable<Price> {

    private final double euros;

    private Price(double euros) {
        this.euros = euros;
    }

    public static Price ofEuros(double euros) {
        if (euros < 0) throw new ValidationException("Price cannot be negative: " + euros);

        return new Price(euros);
    }

    @Override
    public int compareTo(Price other) {
        return Double.compare(euros, other.euros);
    }

    public boolean isLowerThan(Price other) {
        return this.compareTo(other) < 0;
    }

    @Override
    public String toString() {
        return "Price{" +
                "euros=" + euros +
                '}';
    }
}
