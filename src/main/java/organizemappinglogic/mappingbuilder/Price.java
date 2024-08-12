package organizemappinglogic.mappingbuilder;

public class Price {
    public enum Currency {EUR, USD}

    Double value;
    Currency currency;

    public Price(Double value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }
}