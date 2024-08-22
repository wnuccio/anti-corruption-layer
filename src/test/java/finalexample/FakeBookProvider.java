package finalexample;

import finalexample.acl.BookProvider;
import finalexample.acl.dtos.BookBundleDto;
import finalexample.acl.dtos.BookInfoDto;
import finalexample.acl.dtos.PublishedBookDto;
import finalexample.acl.dtos.PublisherDto;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public class FakeBookProvider extends BookProvider {
    private final List<BookInfoDto> bookInfos;
    private final List<PublisherDto> publishers;

    public FakeBookProvider() {
        BookInfoDto book1 = new BookInfoDto("Refactoring", "Fowler", "978-1234567876",
                List.of("refactoring", "clean-code", "coding"));
        PublishedBookDto pubBook1 = new PublishedBookDto("Refactoring", "978-1234567876", 10.00, 2002);

        BookInfoDto book2 = new BookInfoDto("Design Patterns", "Gof", "978-0201633610",
                List.of("design", "pattern", "coding"));
        PublishedBookDto pubBook2 = new PublishedBookDto("Design Pattern", "978-0201633610", 30.00, 2000);

        BookInfoDto book3 = new BookInfoDto("Implementing DDD", "Vernon", "978-0201633603",
                List.of("design", "ddd"));
        PublishedBookDto pubBook3 = new PublishedBookDto("Design Pattern", "978-0201633603", 40.00, 2003);

        BookInfoDto book4 = new BookInfoDto("Wrong Isbn", "Unknown", "xxxxxxxxxxxxx", "wrong-isbn");
        PublishedBookDto pubBook4 = new PublishedBookDto("Wrong Isbn", "xxxxxxxxxxxxx", 30.00, 2000);

        BookInfoDto book5 = new BookInfoDto("Wrong Isbn", "Unknown", "978-0201633604", "not-referred-by-any-publisher");

        BookInfoDto book6 = new BookInfoDto("Invalid Price", "Unknown", "978-0201633605", "invalid-price");
        PublishedBookDto pubBook6 = new PublishedBookDto("Invalid Price", "978-0201633605", -30.00, 2000);

        PublisherDto publisher1 = new PublisherDto("Addison-Wesley", "USA", List.of(pubBook1, pubBook3));
        PublisherDto publisher2 = new PublisherDto("Pearson", "USA", List.of(pubBook2, pubBook4, pubBook6));
        PublisherDto publisher3 = new PublisherDto("O'Reilly", "USA", emptyList());

        this.bookInfos = List.of(book1, book2, book3, book4, book5, book6);
        this.publishers = List.of(publisher1, publisher2, publisher3);
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
