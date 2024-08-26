package finalexample.acl.mappers;

import finalexample.acl.dtos.BookBundleDto;
import finalexample.domain.Book;
import finalexample.domain.BookBundle;
import finalexample.domain.Isbn;
import finalexample.domain.Price;
import finalexample.domain.Publisher;
import finalexample.domain.ValidationException;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class BookBundleDtoMapper {
    private final List<BookDtoMapper> bookDtoMappers;
    private final List<PublisherDtoMapper> publisherDtoMappers;

    public BookBundleDtoMapper(BookBundleDto bookBundleDto) {
        this.bookDtoMappers = bookBundleDto.getBooks().stream()
                .map(BookDtoMapper::new)
                .collect(toList());
        this.publisherDtoMappers = bookBundleDto.getPublishers().stream()
                .map(PublisherDtoMapper::new)
                .collect(toList());
    }

    public BookBundle toBundle() {
        List<Book> books = new ArrayList<>();

        for (BookDtoMapper bookMapper : bookDtoMappers) {
            String title = bookMapper.toTitle();
            Isbn isbn = bookMapper.toIsbn();

            PublisherDtoMapper publisherMapper = publisherOf(isbn);
            Publisher publisher = publisherMapper.toPublisher();

            PublishedBookDtoMapper publishedBookMapper = publisherMapper.publishedBookOf(isbn);
            int year = publishedBookMapper.toYear();
            Price price = publishedBookMapper.toPrice();

            Book book = new Book(title, isbn, publisher, year, price);
            books.add(book);
        }

        return new BookBundle(books);
    }

    private PublisherDtoMapper publisherOf(Isbn isbn) {
        return publisherDtoMappers.stream()
                .filter(publisherDtoMapper -> publisherDtoMapper.hasIsbn(isbn))
                .findFirst()
                .orElseThrow(() -> new ValidationException("No Publisher found for ISBN:" + isbn));
    }
}
