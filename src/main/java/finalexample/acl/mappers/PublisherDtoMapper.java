package finalexample.acl.mappers;

import finalexample.acl.dtos.PublisherDto;
import finalexample.domain.Isbn;
import finalexample.domain.Publisher;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class PublisherDtoMapper {
    private final PublisherDto publisherDto;
    private final List<PublishedBookDtoMapper> publishedBookDtoMappers;

    public PublisherDtoMapper(PublisherDto publisherDto) {
        this.publisherDto = publisherDto;
        this.publishedBookDtoMappers = publisherDto.getPublishedBooks().stream()
                .map(PublishedBookDtoMapper::new)
                .collect(toList());
    }

    public boolean hasIsbn(Isbn isbn) {
        return publishedBookDtoMappers.stream()
                .anyMatch(publishedBookInfo -> publishedBookInfo.hasIsbn(isbn));
    }

    public Publisher toPublisher() {
        return new Publisher(publisherDto.getName());
    }

    public PublishedBookDtoMapper publisherBookInfoMapperOf(Isbn isbn) {
        return publishedBookDtoMappers.stream()
                .filter(publishedBookDtoMapper -> publishedBookDtoMapper.hasIsbn(isbn))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Published book info not found"));
    }
}
