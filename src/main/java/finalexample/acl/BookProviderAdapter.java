package finalexample.acl;

import finalexample.acl.dtos.BookBundleDto;
import finalexample.acl.mappers.BookBundleDtoMapper;
import finalexample.domain.BookBundle;
import finalexample.domain.BookService;

public class BookProviderAdapter implements BookService {

    private final BookProvider bookProvider;

    public BookProviderAdapter(BookProvider bookProvider) {
        this.bookProvider = bookProvider;
    }

    @Override
    public BookBundle retrieveBooks(String keyword) {
        BookBundleDto bundleDto = bookProvider.getBookBundle(keyword);
        BookBundleDtoMapper mapper = new BookBundleDtoMapper(bundleDto);
        return mapper.toBundle();
    }
}
