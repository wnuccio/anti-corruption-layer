package modeloptionality.nulltonullobject;

public class NullGadget implements Gadget {
    public double priceInDollars() {
        return 0.0;
    }

    public double weight() {
        return 0.0;
    }

    public String description() {
        return "No description available.";
    }
}
