package modeloptionality.nulltonullobject;

public class Book {
    private double price;
    private Gadget gadget;

    public Book(double price, Gadget gadget) {
        this.price = price;
        this.gadget = gadget;
    }

    public double priceInDollars() {
        return this.price + gadget.priceInDollars();
    }
}
