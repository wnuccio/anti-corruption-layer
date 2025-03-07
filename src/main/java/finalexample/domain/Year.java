package finalexample.domain;

public class Year {
    private final int number;

    public Year(int number) {
        if (number < 1900) throw new ValidationException("Forbidden number for year: " + number);
        this.number = number;
    }

    public boolean isAfter(Year year) {
        return this.number > year.number;
    }
}
