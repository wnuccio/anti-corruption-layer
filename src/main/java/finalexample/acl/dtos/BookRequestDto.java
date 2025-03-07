package finalexample.acl.dtos;

public class BookRequestDto {
    private final String filterType;
    private final String keyword;
    private final String author;

    public BookRequestDto(String filterType, String keyword, String author) {
        this.filterType = filterType;
        this.keyword = keyword;
        this.author = author;
    }
}
