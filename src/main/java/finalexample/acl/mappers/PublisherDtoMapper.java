package finalexample.acl.mappers;

import finalexample.acl.dtos.PublisherDto;
import finalexample.domain.Isbn;
import finalexample.domain.Publisher;
import finalexample.domain.ValidationException;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class PublisherDtoMapper {
    private final String publisherName;
    private final List<EditionDtoMapper> editionDtoMappers;

    public PublisherDtoMapper(PublisherDto publisherDto) {
        this.publisherName = publisherDto.getName();
        this.editionDtoMappers = publisherDto.getEditions().stream()
                .map(EditionDtoMapper::new)
                .collect(toList());
    }

    public boolean hasIsbn(Isbn isbn) {
        return editionDtoMappers.stream()
                .anyMatch(edition -> edition.hasIsbn(isbn));
    }

    public Publisher toPublisher() {
        return new Publisher(publisherName);
    }

    public EditionDtoMapper editionOf(Isbn isbn) {
        return editionDtoMappers.stream()
                .filter(edition -> edition.hasIsbn(isbn))
                .findFirst()
                .orElseThrow(() -> new ValidationException("Edition not found"));
    }
}
