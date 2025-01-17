package modelrelationships.relatedfieldstoclass.example1;


import modelrelationships.relatedfieldstoclass.common.Price;

class Book {
    private String title;
    private Price price;

    public String title() {
        return title;
    }

    public Price price() {
        return price;
    }
}