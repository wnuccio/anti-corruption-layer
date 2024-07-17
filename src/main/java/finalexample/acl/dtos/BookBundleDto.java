package finalexample.acl.dtos;

import java.util.List;

public class BookBundleDto {
    List<BookInfoDto> bookInfo;
    List<PublisherDto> publishers;

    public BookBundleDto(List<BookInfoDto> bookInfo, List<PublisherDto> publishers) {
        this.bookInfo = bookInfo;
        this.publishers = publishers;
    }

    public static BookBundleDtoBuilder builder() {
        return new BookBundleDtoBuilder();
    }

    public List<BookInfoDto> getBookInfo() {
        return bookInfo;
    }

    public List<PublisherDto> getPublishers() {
        return publishers;
    }
}
