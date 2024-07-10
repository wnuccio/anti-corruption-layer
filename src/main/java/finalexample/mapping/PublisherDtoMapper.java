package finalexample.mapping;

import finalexample.dtos.PublisherDto;
import finalexample.model.Publisher;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class PublisherDtoMapper {
    private final String name;
    private final List<PublishedBookInfoMapper> publishedBookInfoMappers;

    public PublisherDtoMapper(PublisherDto publisherDto) {
        this.name = publisherDto.getName();
        this.publishedBookInfoMappers = publisherDto.getPublishedBookInfo().stream()
                .map(publishedBookInfo -> new PublishedBookInfoMapper(publishedBookInfo))
                .collect(toList());
    }

    public boolean hasIsbn(String isbn) {
        return publishedBookInfoMappers.stream()
                .anyMatch(publishedBookInfo -> publishedBookInfo.hasIsbn(isbn));
    }

    public Publisher toPublisher() {
        return new Publisher(name);
    }

    public PublishedBookInfoMapper publisherBookInfoMapperOf(String isbn) {
        return publishedBookInfoMappers.stream()
                .filter(publishedBookInfoMapper -> publishedBookInfoMapper.hasIsbn(isbn))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Published book info not found"));
    }
}
