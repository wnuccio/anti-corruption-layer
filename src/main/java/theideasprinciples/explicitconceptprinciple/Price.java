package theideasprinciples.explicitconceptprinciple;

public class Price {
    private double amount;

    public Price(double amount) {
        this.amount = amount;
    }

    public static Price ofEuros(double amount) {
        return new Price(amount);
    }

    public double euros() {
        return amount;
    }
}
