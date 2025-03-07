package finalexample.acl;

import finalexample.acl.dtos.BookRequestDto;
import finalexample.acl.dtos.BookResponseDto;
import finalexample.acl.mappers.BookResponseDtoMapper;
import finalexample.domain.BookBundle;
import finalexample.domain.BookService;

public class BookProviderAdapter implements BookService {
    private final BookProviderClient bookProviderClient;

    public BookProviderAdapter(BookProviderClient bookProviderClient) {
        this.bookProviderClient = bookProviderClient;
    }

    @Override
    public BookBundle retrieveSoftwareBooks() {
        BookRequestDto requestDto = new BookRequestDto("BY_KEYWORD", "software", null);
        BookResponseDto responseDto = bookProviderClient.getBookBundle(requestDto);
        BookResponseDtoMapper mapper = new BookResponseDtoMapper(responseDto);
        BookBundle bookBundle = mapper.toBundle();
        return bookBundle;
    }
}
