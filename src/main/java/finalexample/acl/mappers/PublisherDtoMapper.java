package finalexample.acl.mappers;

import finalexample.acl.dtos.PublisherDto;
import finalexample.domain.Isbn;
import finalexample.domain.Publisher;
import finalexample.domain.ValidationException;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class PublisherDtoMapper {
    private final String publisherName;
    private final List<PublishedBookDtoMapper> publishedBookDtoMappers;

    public PublisherDtoMapper(PublisherDto publisherDto) {
        this.publisherName = publisherDto.getName();
        this.publishedBookDtoMappers = publisherDto.getPublishedBooks().stream()
                .map(PublishedBookDtoMapper::new)
                .collect(toList());
    }

    public boolean hasIsbn(Isbn isbn) {
        return publishedBookDtoMappers.stream()
                .anyMatch(publishedBook -> publishedBook.hasIsbn(isbn));
    }

    public Publisher toPublisher() {
        return new Publisher(publisherName);
    }

    public PublishedBookDtoMapper publishedBookOf(Isbn isbn) {
        return publishedBookDtoMappers.stream()
                .filter(publishedBook -> publishedBook.hasIsbn(isbn))
                .findFirst()
                .orElseThrow(() -> new ValidationException("Published book not found"));
    }
}
