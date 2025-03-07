package finalexample.acl;

import finalexample.acl.dtos.BookRequestDto;
import finalexample.acl.dtos.BookResponseDto;
import finalexample.acl.mappers.BookResponseDtoMapper;
import finalexample.domain.BookBundle;
import finalexample.domain.BookService;

import java.util.List;

import static java.util.Collections.emptyList;

public class BookProviderAdapter implements BookService {
    private final BookProviderClient bookProviderClient;

    public BookProviderAdapter(BookProviderClient bookProviderClient) {
        this.bookProviderClient = bookProviderClient;
    }

    @Override
    public BookBundle retrieveSoftwareBooks() {
        BookRequestDto requestDto = new BookRequestDto("BY_KEYWORDS", List.of("software"), emptyList());
        BookResponseDto responseDto = bookProviderClient.getBooks(requestDto);
        BookResponseDtoMapper mapper = new BookResponseDtoMapper(responseDto);
        BookBundle bookBundle = mapper.toBundle();
        return bookBundle;
    }
}
