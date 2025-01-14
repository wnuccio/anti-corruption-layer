package modelconcepts.codetoenum;

public enum Genre {
    CLASSIC(0.0),
    FANTASY(0.1),
    HORROR(0.2),
    LOVE(0.05),
    THRILLER(0.1);

    private final double discountPercentage;

    Genre(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double discountedPrice(double price) {
        return price - price * discountPercentage;
    }

    public boolean isFantastic() {
        return this == FANTASY || this == HORROR || this == THRILLER;
    }
}

