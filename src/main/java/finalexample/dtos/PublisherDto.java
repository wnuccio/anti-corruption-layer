package finalexample.dtos;

import java.util.List;

public class PublisherDto {
    String name;
    String address;
    List<PublishedBookDto> publishedBookDtos;

    public PublisherDto(String name, String address, List<PublishedBookDto> publishedBookDtos) {
        this.name = name;
        this.address = address;
        this.publishedBookDtos = publishedBookDtos;
    }

    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public String getAddress() {
        return address;
    }

    public List<PublishedBookDto> getPublishedBooks() {
        return publishedBookDtos;
    }
}
