package finalexample.mapping;

import finalexample.dtos.PublishedBookInfoDto;

public class PublishedBookInfoMapper {
    private final PublishedBookInfoDto publishedBookInfo;

    public PublishedBookInfoMapper(PublishedBookInfoDto publishedBookInfo) {
        this.publishedBookInfo = publishedBookInfo;
    }

    public boolean hasIsbn(String isbn) {
        return publishedBookInfo.getIsbn().equals(isbn);
    }

    public int toYear() {
        return publishedBookInfo.getYear();
    }

    public double toPrice() {
        return publishedBookInfo.getPrice();
    }
}
