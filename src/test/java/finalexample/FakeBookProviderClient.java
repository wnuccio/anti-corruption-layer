package finalexample;

import finalexample.acl.BookProviderClient;
import finalexample.acl.dtos.BookBundleDto;
import finalexample.acl.dtos.BookDto;
import finalexample.acl.dtos.PublishedBookDto;
import finalexample.acl.dtos.PublisherDto;

import java.util.List;

public class FakeBookProviderClient extends BookProviderClient {
    public static final BookDto REFACTORING =
            new BookDto("Refactoring", "Fowler", "978-1234567801");
    public static final PublishedBookDto PUB_REFACTORING =
            new PublishedBookDto("Refactoring", "978-1234567801", 10.00, 2002);

    public static final BookDto DESIGN_PATTERNS =
            new BookDto("Design Patterns", "Gof", "978-1234567802");
    public static final PublishedBookDto PUB_DESIGN_PATTERNS =
            new PublishedBookDto("Design Pattern", "978-1234567802", 30.00, 2000);

    public static final BookDto IMPLEMENTING_DDD =
            new BookDto("Implementing DDD", "Vernon", "978-1234567803");
    public static final PublishedBookDto PUB_IMPLEMENTING_DDD =
            new PublishedBookDto("Implementing DDD", "978-1234567803", 40.00, 2003);

    public static final BookDto DESIGN_PATTERNS_2 =
            new BookDto("Design Patterns", "Gof", "978-1234567804");
    public static final PublishedBookDto PUB_DESIGN_PATTERNS_2 =
            new PublishedBookDto("Design Pattern", "978-1234567804", 50.00, 2024);

    public static final BookDto BOOK_WRONG_ISBN =
            new BookDto("Wrong Isbn", "Unknown", "xxxxxxxxxxxxx");
    public static final PublishedBookDto PUB_BOOK_WRONG_ISBN =
            new PublishedBookDto("Wrong Isbn", "978-1234567804", 30.00, 2000);

    public static final BookDto BOOK_INVALID_PRICE =
            new BookDto("Invalid Price", "Unknown", "978-1234567805");
    public static final PublishedBookDto PUB_BOOK_INVALID_PRICE =
            new PublishedBookDto("Invalid Price", "978-1234567805", -30.00, 2000);

    public static final PublisherDto ADDISON_WESLEY = new PublisherDto("Addison-Wesley", "USA",
            List.of(PUB_REFACTORING, PUB_DESIGN_PATTERNS));

    public static final PublisherDto PEARSON = new PublisherDto("Pearson", "USA",
            List.of(PUB_IMPLEMENTING_DDD, PUB_DESIGN_PATTERNS_2, PUB_BOOK_WRONG_ISBN, PUB_BOOK_INVALID_PRICE));

    private final List<BookDto> bookInfos;
    private final List<PublisherDto> publishers;

    public FakeBookProviderClient(List<BookDto> books, List<PublisherDto> publishers) {
        this.bookInfos = books;
        this.publishers = publishers;
    }

    @Override
    public BookBundleDto getBookBundle() {
        return new BookBundleDto(bookInfos, publishers);
    }
}
