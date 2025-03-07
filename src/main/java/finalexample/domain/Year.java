package finalexample.domain;

public class Year {
    private final int year;

    public Year(int year) {
        if (year < 1900) throw new ValidationException("Forbidden value for year: " + year);
        this.year = year;
    }

    public int val() {
        return year;
    }
}
