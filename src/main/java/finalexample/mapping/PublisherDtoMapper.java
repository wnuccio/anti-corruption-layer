package finalexample.mapping;

import finalexample.dtos.PublisherDto;
import finalexample.model.Publisher;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class PublisherDtoMapper {
    private final PublisherDto publisherDto;
    private final List<PublishedBookInfoDtoMapper> publishedBookInfoDtoMappers;

    public PublisherDtoMapper(PublisherDto publisherDto) {
        this.publisherDto = publisherDto;
        this.publishedBookInfoDtoMappers = publisherDto.getPublishedBooks().stream()
                .map(publishedBookInfo -> new PublishedBookInfoDtoMapper(publishedBookInfo))
                .collect(toList());
    }

    public boolean hasIsbn(String isbn) {
        return publishedBookInfoDtoMappers.stream()
                .anyMatch(publishedBookInfo -> publishedBookInfo.hasIsbn(isbn));
    }

    public Publisher toPublisher() {
        return new Publisher(publisherDto.getName());
    }

    public PublishedBookInfoDtoMapper publisherBookInfoMapperOf(String isbn) {
        return publishedBookInfoDtoMappers.stream()
                .filter(publishedBookInfoDtoMapper -> publishedBookInfoDtoMapper.hasIsbn(isbn))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Published book info not found"));
    }
}
