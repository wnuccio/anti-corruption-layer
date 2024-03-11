package transformstrings.stringtostrategy;

class Thriller implements Genre {
    @Override
    public double discountPercentage() {
        // some complex logic
        return 0.20;
    }
}
