package finalexample;

import finalexample.acl.BookProviderClient;
import finalexample.acl.dtos.BookBundleDto;
import finalexample.acl.dtos.BookInfoDto;
import finalexample.acl.dtos.PublishedBookDto;
import finalexample.acl.dtos.PublisherDto;

import java.util.List;

public class FakeBookProviderClient extends BookProviderClient {
    public static final BookInfoDto BOOK_1 =
            new BookInfoDto("Refactoring", "Fowler", "978-1234567876",
            List.of("refactoring", "clean-code", "coding", "software"));
    public static final PublishedBookDto PUB_BOOK_1 =
            new PublishedBookDto("Refactoring", "978-1234567876", 10.00, 2002);

    public static final BookInfoDto BOOK_2 =
            new BookInfoDto("Design Patterns", "Gof", "978-0201633610",
            List.of("design", "pattern", "coding", "software"));
    public static final PublishedBookDto PUB_BOOK_2 =
            new PublishedBookDto("Design Pattern", "978-0201633610", 30.00, 2000);

    public static final BookInfoDto BOOK_3 =
            new BookInfoDto("Implementing DDD", "Vernon", "978-0201633603",
            List.of("design", "ddd", "software"));
    public static final PublishedBookDto PUB_BOOK_3 =
            new PublishedBookDto("Implementing DDD", "978-0201633603", 40.00, 2003);

    public static final BookInfoDto BOOK_4 = new BookInfoDto("Wrong Isbn", "Unknown", "xxxxxxxxxxxxx", "wrong-isbn");
    public static final PublishedBookDto PUB_BOOK_4 = new PublishedBookDto("Wrong Isbn", "xxxxxxxxxxxxx", 30.00, 2000);

    public static final BookInfoDto BOOK_5 = new BookInfoDto("Invalid Price", "Unknown", "978-0201633605", "invalid-price");
    public static final PublishedBookDto PUB_BOOK_6 = new PublishedBookDto("Invalid Price", "978-0201633605", -30.00, 2000);

    public static final PublisherDto PUBLISHER_A = new PublisherDto("Addison-Wesley", "USA",
            List.of(PUB_BOOK_1, PUB_BOOK_3));

    public static final PublisherDto PUBLISHER_B = new PublisherDto("Pearson", "USA",
            List.of(PUB_BOOK_2, PUB_BOOK_4, PUB_BOOK_6));

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
