package organizemappinglogic.mappingvisitor.domain;

public interface BookMapper {
    BookMapper title(String title);

    BookMapper author(String author);

    void isbn(String value);
}
