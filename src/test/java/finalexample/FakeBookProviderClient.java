package finalexample;

import finalexample.acl.BookProviderClient;
import finalexample.acl.dtos.BookBundleDto;
import finalexample.acl.dtos.BookDto;
import finalexample.acl.dtos.EditionDto;
import finalexample.acl.dtos.PublisherDto;

import java.util.List;

public class FakeBookProviderClient extends BookProviderClient {
    public static final BookDto REFACTORING =
            new BookDto("Refactoring", "Fowler", "978-1234567801");
    public static final EditionDto REFACTORING_EDITION =
            new EditionDto("Refactoring", "978-1234567801", 10.00, 2002);

    public static final BookDto DESIGN_PATTERNS =
            new BookDto("Design Patterns", "Gof", "978-1234567802");
    public static final EditionDto DESIGN_PATTERNS_EDITION =
            new EditionDto("Design Pattern", "978-1234567802", 30.00, 2000);

    public static final BookDto IMPLEMENTING_DDD =
            new BookDto("Implementing DDD", "Vernon", "978-1234567803");
    public static final EditionDto IMPLEMENTING_DDD_EDITION =
            new EditionDto("Implementing DDD", "978-1234567803", 40.00, 2003);

    public static final BookDto DESIGN_PATTERNS_2 =
            new BookDto("Design Patterns", "Gof", "978-1234567804");
    public static final EditionDto DESIGN_PATTERNS_2_EDITION =
            new EditionDto("Design Pattern", "978-1234567804", 50.00, 2024);

    public static final BookDto BOOK_WRONG_ISBN =
            new BookDto("Wrong Isbn", "Unknown", "xxxxxxxxxxxxx");
    public static final EditionDto BOOK_WRONG_ISBN_EDITION =
            new EditionDto("Wrong Isbn", "978-1234567804", 30.00, 2000);

    public static final BookDto BOOK_INVALID_PRICE =
            new BookDto("Invalid Price", "Unknown", "978-1234567805");
    public static final EditionDto BOOK_INVALID_PRICE_EDITION =
            new EditionDto("Invalid Price", "978-1234567805", -30.00, 2000);

    public static final PublisherDto ADDISON_WESLEY = new PublisherDto("Addison-Wesley", "USA",
            List.of(REFACTORING_EDITION, DESIGN_PATTERNS_EDITION));

    public static final PublisherDto PEARSON = new PublisherDto("Pearson", "USA",
            List.of(IMPLEMENTING_DDD_EDITION, DESIGN_PATTERNS_2_EDITION, BOOK_WRONG_ISBN_EDITION, BOOK_INVALID_PRICE_EDITION));

    private final List<BookDto> books;
    private final List<PublisherDto> publishers;

    public FakeBookProviderClient(List<BookDto> books, List<PublisherDto> publishers) {
        this.books = books;
        this.publishers = publishers;
    }

    @Override
    public BookBundleDto getBookBundle() {
        return new BookBundleDto(books, publishers);
    }
}
