package finalexample.acl.dtos;

import java.util.List;

public class PublisherDto {
    String name;
    String address;
    List<PublishedBookDto> publishedBooks;

    public PublisherDto(String name, String address, List<PublishedBookDto> publishedBooks) {
        this.name = name;
        this.address = address;
        this.publishedBooks = publishedBooks;
    }

    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public String getAddress() {
        return address;
    }

    public List<PublishedBookDto> getPublishedBooks() {
        return publishedBooks;
    }
}
