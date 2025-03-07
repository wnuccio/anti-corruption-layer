package finalexample.acl.dtos;

import java.util.List;

public class BookRequestDto {
    private final String filterType;
    private final List<String> keyword;
    private final List<String> authors;

    public BookRequestDto(String filterType, List<String> keywords, List<String> authors) {
        this.filterType = filterType;
        this.keyword = keywords;
        this.authors = authors;
    }
}
