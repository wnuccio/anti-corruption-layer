package finalexample;

import finalexample.acl.BookProvider;
import finalexample.acl.dtos.BookBundleDto;
import finalexample.acl.dtos.BookInfoDto;
import finalexample.acl.dtos.PublishedBookDto;
import finalexample.acl.dtos.PublisherDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class FakeBookProvider extends BookProvider {
    public static final BookInfoDto BOOK_1 = new BookInfoDto("Refactoring", "Fowler", "978-1234567876", List.of("refactoring", "clean-code", "coding"));
    public static final PublishedBookDto PUB_BOOK_1 = new PublishedBookDto("Refactoring", "978-1234567876", 10.00, 2002);

    public static final BookInfoDto BOOK_2 = new BookInfoDto("Design Patterns", "Gof", "978-0201633610", List.of("design", "pattern", "coding"));
    public static final PublishedBookDto PUB_BOOK_2 = new PublishedBookDto("Design Pattern", "978-0201633610", 30.00, 2000);

    public static final BookInfoDto BOOK_3 = new BookInfoDto("Implementing DDD", "Vernon", "978-0201633603", List.of("design", "ddd"));
    public static final PublishedBookDto PUB_BOOK_3 = new PublishedBookDto("Design Pattern", "978-0201633603", 40.00, 2003);

    public static final BookInfoDto BOOK_4 = new BookInfoDto("Wrong Isbn", "Unknown", "xxxxxxxxxxxxx", "wrong-isbn");
    public static final PublishedBookDto PUB_BOOK_4 = new PublishedBookDto("Wrong Isbn", "xxxxxxxxxxxxx", 30.00, 2000);

    public static final BookInfoDto BOOK_5 = new BookInfoDto("Wrong Isbn", "Unknown", "978-0201633604", "not-referred-by-any-publisher");

    public static final BookInfoDto BOOK_6 = new BookInfoDto("Invalid Price", "Unknown", "978-0201633605", "invalid-price");
    public static final PublishedBookDto PUB_BOOK_6 = new PublishedBookDto("Invalid Price", "978-0201633605", -30.00, 2000);

    public static final PublisherDto PUBLISHER_A = new PublisherDto("Addison-Wesley", "USA",
            List.of(PUB_BOOK_1, PUB_BOOK_3));

    public static final PublisherDto PUBLISHER_B = new PublisherDto("Pearson", "USA",
            List.of(PUB_BOOK_2, PUB_BOOK_4, PUB_BOOK_6));

    private final List<BookInfoDto> bookInfos;
    private final List<PublisherDto> publishers;

    public FakeBookProvider() {
        this.bookInfos = List.of(BOOK_1, BOOK_2, BOOK_3, BOOK_4, BOOK_5, BOOK_6);
        this.publishers = List.of(PUBLISHER_A, PUBLISHER_B);
    }

    @Override
    public BookBundleDto getBookBundle(List<String> keywords) {
        List<BookInfoDto> bookInfoDtos = this.bookInfos.stream()
                .filter(bookInfo -> bookInfo.getKeywords().stream().anyMatch(keywords::contains))
                .collect(toList());

        List<String> isbns = bookInfoDtos.stream().map(BookInfoDto::getIsbn).collect(toList());

        List<PublisherDto> publisherDtos = publishers.stream()
                .filter(publisher -> publisher.getPublishedBooks().stream()
                        .anyMatch(publishedBookDto -> bookMatchesAnyIsbn(publishedBookDto, isbns)))
                .distinct()
                .collect(toList());

        return new BookBundleDto(bookInfoDtos, publisherDtos);
    }

    private boolean bookMatchesAnyIsbn(PublishedBookDto publishedBook, List<String> isbns) {
        return isbns.stream().anyMatch(isbn -> isbn.equals(publishedBook.getIsbn()));
    }
}
