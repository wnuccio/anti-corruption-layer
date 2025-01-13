package modeloptionality.nulltonullobject;

public class RealGadget implements Gadget {
    private double price;
    private double weight;
    private String description;

    public double priceInDollars() {
        return price;
    }

    public double weight() {
        return weight;
    }

    public String description() {
        return description;
    }
}
