package finalexample.acl.dtos;

import java.util.List;

public class PublisherDto {
    String name;
    String address;
    List<EditionDto> editions;

    public PublisherDto(String name, String address, List<EditionDto> editions) {
        this.name = name;
        this.address = address;
        this.editions = editions;
    }

    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public String getAddress() {
        return address;
    }

    public List<EditionDto> getEditions() {
        return editions;
    }
}
