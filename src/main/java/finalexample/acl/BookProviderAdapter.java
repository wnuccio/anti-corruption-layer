package finalexample.acl;

import finalexample.acl.dtos.BookBundleResponseDto;
import finalexample.acl.dtos.BookRequestDto;
import finalexample.acl.mappers.BookBundleDtoMapper;
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
        BookBundleResponseDto responseDto = bookProviderClient.getBookBundle(requestDto);
        BookBundleDtoMapper mapper = new BookBundleDtoMapper(responseDto);
        BookBundle bookBundle = mapper.toBundle();
        return bookBundle;
    }
}
