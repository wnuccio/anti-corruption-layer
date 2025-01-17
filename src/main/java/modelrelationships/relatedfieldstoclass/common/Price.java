package modelrelationships.relatedfieldstoclass.common;

public class Price {
    private Double amount;
    private Currency currency;

    public Price(Double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }
}
