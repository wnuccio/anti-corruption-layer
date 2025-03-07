package finalexample.acl.dtos;

import java.util.List;

public class BookRequestDto {
    private final String filterType;
    private final List<String> keyword;
    private final String author;

    public BookRequestDto(String filterType, List<String> keywords, String author) {
        this.filterType = filterType;
        this.keyword = keywords;
        this.author = author;
    }
}
