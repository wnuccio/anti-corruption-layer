package finalexample;

import finalexample.acl.BookProvider;
import finalexample.acl.dtos.BookBundleDto;
import finalexample.acl.dtos.BookInfoDto;
import finalexample.acl.dtos.PublishedBookDto;
import finalexample.acl.dtos.PublisherDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FakeBookProvider extends BookProvider {
    private final List<BookInfoDto> bookInfos;
    private final List<PublisherDto> publishers;

    public FakeBookProvider() {
        BookInfoDto book1 = new BookInfoDto("Refactoring", "Fowler", "978-1234567876",
                List.of("refactoring", "clean-code", "martin-fowler"));
        PublishedBookDto pubBook1 = new PublishedBookDto("Refactoring", "978-1234567876", 40.00, 2002);

        BookInfoDto book2 = new BookInfoDto("Design Patterns", "Gof", "978-0201633610",
                List.of("design", "pattern"));
        PublishedBookDto pubBook2 = new PublishedBookDto("Design Pattern", "978-0201633610", 30.00, 2000);

        BookInfoDto book3 = new BookInfoDto("Wrong Isbn", "Unknown", "xxxxxxxxxxxxx", "wrong-isbn");
        PublishedBookDto pubBook3 = new PublishedBookDto("Wrong Isbn", "xxxxxxxxxxxxx", 30.00, 2000);

        BookInfoDto book4 = new BookInfoDto("Wrong Isbn", "Unknown", "978-0201633604", "not-referred-by-any-publisher");

        BookInfoDto book5 = new BookInfoDto("Invalid Price", "Unknown", "978-0201633605", "invalid-price");
        PublishedBookDto pubBook5 = new PublishedBookDto("Invalid Price", "978-0201633605", -30.00, 2000);

        PublisherDto publisher1 = new PublisherDto("O'Reilly", "USA", List.of(pubBook1, pubBook3));
        PublisherDto publisher2 = new PublisherDto("Addison-Wesley", "USA", List.of(pubBook2, pubBook5));

        this.bookInfos = List.of(book1, book2, book3, book4, book5);
        this.publishers = List.of(publisher1, publisher2);
    }

    @Override
    public BookBundleDto getBookBundle(List<String> keywords) {
        List<BookInfoDto> bookInfoDtos = this.bookInfos.stream()
                .filter(bookInfo -> bookInfo.getKeywords().stream().anyMatch(keywords::contains))
                .collect(Collectors.toList());

        List<String> isbns = bookInfoDtos.stream().map(BookInfoDto::getIsbn).collect(Collectors.toList());

        List<PublisherDto> publisherDtos = new ArrayList<>(publishers.stream()
                .filter(publisher -> publisher.getPublishedBooks().stream()
                        .anyMatch(publishedBookDto -> bookMatchesAnyIsbn(publishedBookDto, isbns)))
                .collect(Collectors.toSet()));

        return new BookBundleDto(bookInfoDtos, publisherDtos);
    }

    private boolean bookMatchesAnyIsbn(PublishedBookDto publishedBook, List<String> isbns) {
        return isbns.stream().anyMatch(isbn -> isbn.equals(publishedBook.getIsbn()));
    }
}
