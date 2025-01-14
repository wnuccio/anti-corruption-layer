package modelconcepts.codetostrategy;

public class Fiction implements Genre {
    @Override
    public double discountPercentage() {
        // some complex logic
        return 0;
    }
}
