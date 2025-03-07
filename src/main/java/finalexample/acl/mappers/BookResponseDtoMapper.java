package finalexample.acl.mappers;

import finalexample.acl.dtos.BookResponseDto;
import finalexample.domain.Book;
import finalexample.domain.BookBundle;
import finalexample.domain.Isbn;
import finalexample.domain.Price;
import finalexample.domain.Publisher;
import finalexample.domain.ValidationException;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class BookResponseDtoMapper {
    private final List<BookDtoMapper> bookDtoMappers;
    private final List<PublisherDtoMapper> publisherDtoMappers;

    public BookResponseDtoMapper(BookResponseDto bookResponseDto) {
        this.bookDtoMappers = bookResponseDto.getBooks().stream()
                .map(BookDtoMapper::new)
                .collect(toList());
        this.publisherDtoMappers = bookResponseDto.getPublishers().stream()
                .map(PublisherDtoMapper::new)
                .collect(toList());
    }

    public BookBundle toBundle() {
        List<Book> books = bookDtoMappers.stream()
                .map(this::toBook)
                .collect(toList());

        return new BookBundle(books);
    }

    private Book toBook(BookDtoMapper bookMapper) {
        String title = bookMapper.toTitle();
        Isbn isbn = bookMapper.toIsbn();

        PublisherDtoMapper publisherMapper = publisherOf(isbn);
        Publisher publisher = publisherMapper.toPublisher();

        EditionDtoMapper editionMapper = publisherMapper.editionOf(isbn);
        int year = editionMapper.toYear();
        Price price = editionMapper.toPrice();

        return new Book(title, isbn, publisher, year, price);
    }

    private PublisherDtoMapper publisherOf(Isbn isbn) {
        return publisherDtoMappers.stream()
                .filter(publisherMapper -> publisherMapper.hasEdition(isbn))
                .findFirst()
                .orElseThrow(() -> new ValidationException("No Publisher found for ISBN:" + isbn));
    }
}
