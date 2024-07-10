package finalexample.mapping;

import finalexample.dtos.BookBundleDto;
import finalexample.model.BookBundle;
import finalexample.model.PublishedBook;
import finalexample.model.Publisher;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class BookBundleDtoMapper {
    private final List<BookInfoDtoMapper> bookInfoMappers;
    private final List<PublisherDtoMapper> publisherMappers;

    public BookBundleDtoMapper(BookBundleDto bookBundleDto) {
        this.bookInfoMappers = bookBundleDto.getBookInfo().stream()
                .map(info -> new BookInfoDtoMapper(info))
                .collect(toList());
        this.publisherMappers = bookBundleDto.getPublishers().stream()
                .map(publisher -> new PublisherDtoMapper(publisher))
                .collect(toList());
    }

    public BookBundle toBundle() {
        List<PublishedBook> publishedBooks = new ArrayList<>();

        for (BookInfoDtoMapper bookInfoMapper : bookInfoMappers) {
            String title = bookInfoMapper.toTitle();
            String isbn = bookInfoMapper.toIsbn().isbn();

            PublisherDtoMapper publisherMapper = publisherOf(publisherMappers, bookInfoMapper.toIsbn().isbn());
            Publisher publisher = publisherMapper.toPublisher();

            PublishedBookInfoMapper publishedBookInfoMapper = publisherMapper.publisherBookInfoMapperOf(isbn);
            int year = publishedBookInfoMapper.toYear();
            double price = publishedBookInfoMapper.toPrice();

            PublishedBook publishedBook = new PublishedBook(title, isbn, publisher, year, price);
            publishedBooks.add(publishedBook);
        }

        return new BookBundle(publishedBooks);
    }

    private PublisherDtoMapper publisherOf(List<PublisherDtoMapper> publishers, String isbn) {
        return publishers.stream()
                .filter(publisherDtoMapper -> publisherDtoMapper.hasIsbn(isbn))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Publisher not found"));
    }
}
