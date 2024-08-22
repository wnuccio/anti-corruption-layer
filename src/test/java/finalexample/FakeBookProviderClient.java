package finalexample;

import finalexample.acl.BookProviderClient;
import finalexample.acl.dtos.BookBundleDto;
import finalexample.acl.dtos.BookInfoDto;
import finalexample.acl.dtos.PublishedBookDto;
import finalexample.acl.dtos.PublisherDto;

import java.util.List;

public class FakeBookProviderClient extends BookProviderClient {
    public static final BookInfoDto BOOK_1 =
            new BookInfoDto("Refactoring", "Fowler", "978-1234567801");
    public static final PublishedBookDto PUB_BOOK_1 =
            new PublishedBookDto("Refactoring", "978-1234567801", 10.00, 2002);

    public static final BookInfoDto BOOK_2 =
            new BookInfoDto("Design Patterns", "Gof", "978-1234567802");
    public static final PublishedBookDto PUB_BOOK_2 =
            new PublishedBookDto("Design Pattern", "978-1234567802", 30.00, 2000);

    public static final BookInfoDto BOOK_3 =
            new BookInfoDto("Implementing DDD", "Vernon", "978-1234567803");
    public static final PublishedBookDto PUB_BOOK_3 =
            new PublishedBookDto("Implementing DDD", "978-1234567803", 40.00, 2003);

    public static final BookInfoDto BOOK_4 =
            new BookInfoDto("Wrong Isbn", "Unknown", "xxxxxxxxxxxxx");
    public static final PublishedBookDto PUB_BOOK_4 =
            new PublishedBookDto("Wrong Isbn", "978-1234567804", 30.00, 2000);

    public static final BookInfoDto BOOK_5 =
            new BookInfoDto("Invalid Price", "Unknown", "978-1234567805");
    public static final PublishedBookDto PUB_BOOK_5 =
            new PublishedBookDto("Invalid Price", "978-1234567805", -30.00, 2000);

    public static final PublisherDto PUBLISHER_A = new PublisherDto("Addison-Wesley", "USA",
            List.of(PUB_BOOK_1, PUB_BOOK_2));

    public static final PublisherDto PUBLISHER_B = new PublisherDto("Pearson", "USA",
            List.of(PUB_BOOK_3, PUB_BOOK_4, PUB_BOOK_5));

    private final List<BookInfoDto> bookInfos;
    private final List<PublisherDto> publishers;

    public FakeBookProviderClient(List<BookInfoDto> books, List<PublisherDto> publishers) {
        this.bookInfos = books;
        this.publishers = publishers;
    }

    @Override
    public BookBundleDto getBookBundle(String keyword) {
        return new BookBundleDto(bookInfos, publishers);
    }
}
