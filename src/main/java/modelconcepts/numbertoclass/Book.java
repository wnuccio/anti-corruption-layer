package modelconcepts.numbertoclass;

public class Book {
    String title;
    Price price;
}

class Price {
    double value;

    private Price(double value) {
        this.value = value;
    }

    static Price euros(double value) {
        return new Price(value);
    }

    public double euros() {
        return value;
    }

    public Price discounted() {
        return new Price(euros() * 0.90);
    }
}
