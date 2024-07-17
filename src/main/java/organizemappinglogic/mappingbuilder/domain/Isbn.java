package organizemappinglogic.mappingbuilder.domain;

public class Isbn {
    private final String value;

    public Isbn(String value) {
        this.value = value;
    }

    public void mapWith(BookMapper bookMapper) {
        bookMapper.isbn(value);
    }
}
