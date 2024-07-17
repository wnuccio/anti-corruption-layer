package organizemappinglogic.mappingbuilder.domain;

public interface BookMapper {
    BookMapper title(String title);

    BookMapper author(String author);

    void isbn(String value);
}
