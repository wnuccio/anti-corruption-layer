package finalexample.mapping;

import finalexample.dtos.BookBundleDto;
import finalexample.model.Book;
import finalexample.model.BookBundle;
import finalexample.model.Publisher;
import finalexample.model.ValidationException;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class BookBundleDtoMapper {
    private final List<BookInfoDtoMapper> bookInfoDtoMappers;
    private final List<PublisherDtoMapper> publisherDtoMappers;

    public BookBundleDtoMapper(BookBundleDto bookBundleDto) {
        this.bookInfoDtoMappers = bookBundleDto.getBookInfo().stream()
                .map(info -> new BookInfoDtoMapper(info))
                .collect(toList());
        this.publisherDtoMappers = bookBundleDto.getPublishers().stream()
                .map(publisher -> new PublisherDtoMapper(publisher))
                .collect(toList());
    }

    public BookBundle toBundle() {
        List<Book> books = new ArrayList<>();

        for (BookInfoDtoMapper bookInfoMapper : bookInfoDtoMappers) {
            String title = bookInfoMapper.toTitle();
            String isbn = bookInfoMapper.toIsbn().isbn();

            PublisherDtoMapper publisherMapper = publisherOf(publisherDtoMappers, bookInfoMapper.toIsbn().isbn());
            Publisher publisher = publisherMapper.toPublisher();

            PublishedBookInfoDtoMapper publishedBookInfoDtoMapper = publisherMapper.publisherBookInfoMapperOf(isbn);
            int year = publishedBookInfoDtoMapper.toYear();
            double price = publishedBookInfoDtoMapper.toPrice();

            Book book = new Book(title, isbn, publisher, year, price);
            books.add(book);
        }

        return new BookBundle(books);
    }

    private PublisherDtoMapper publisherOf(List<PublisherDtoMapper> publishers, String isbn) {
        return publishers.stream()
                .filter(publisherDtoMapper -> publisherDtoMapper.hasIsbn(isbn))
                .findFirst()
                .orElseThrow(() -> new ValidationException("No Publisher found for ISBN:" + isbn));
    }
}
