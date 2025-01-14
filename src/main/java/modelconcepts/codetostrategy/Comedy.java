package modelconcepts.codetostrategy;

class Comedy implements Genre {
    @Override
    public double discountPercentage() {
        // some complex logic
        return 0.10;
    }
}
