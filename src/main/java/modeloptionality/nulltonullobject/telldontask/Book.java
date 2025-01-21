package modeloptionality.nulltonullobject.telldontask;

public class Book {
    private double price;
    private Gadget gadget;

    public Book(double price, Gadget gadget) {
        this.price = price;
        this.gadget = gadget;
    }

    public double priceInDollars() {
        PriceCalculator priceCalculator = new PriceCalculator();
        gadget.computePrice(priceCalculator);
        return this.price + priceCalculator.priceInDollars();
    }
}
