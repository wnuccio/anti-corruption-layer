package finalexample.dtos;

import java.util.List;

public class PublisherDto {
    String name;
    String address;
    List<PublishedBookInfoDto> publishedBookInfo;

    public PublisherDto(String name, String address, List<PublishedBookInfoDto> publishedBookInfo) {
        this.name = name;
        this.address = address;
        this.publishedBookInfo = publishedBookInfo;
    }

    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public String getAddress() {
        return address;
    }

    public List<PublishedBookInfoDto> getPublishedBookInfo() {
        return publishedBookInfo;
    }
}
