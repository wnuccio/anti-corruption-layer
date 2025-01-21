package modeloptionality.nulltonullobject.telldontask;

public class RealGadget implements Gadget {
    private double price;

    @Override
    public void computePrice(PriceCalculator priceCalculator) {
        priceCalculator.addDollars(price);
    }
}
