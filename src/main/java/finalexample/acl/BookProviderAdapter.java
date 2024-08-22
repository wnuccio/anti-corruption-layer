package finalexample.acl;

import finalexample.acl.dtos.BookBundleDto;
import finalexample.acl.mappers.BookBundleDtoMapper;
import finalexample.domain.BookBundle;
import finalexample.domain.BookProvider;

public class BookProviderAdapter implements BookProvider {
    private final BookProviderClient bookProviderClient;

    public BookProviderAdapter(BookProviderClient bookProviderClient) {
        this.bookProviderClient = bookProviderClient;
    }

    @Override
    public BookBundle retrieveBooks(String keyword) {
        BookBundleDto bundleDto = bookProviderClient.getBookBundle(keyword);
        BookBundleDtoMapper mapper = new BookBundleDtoMapper(bundleDto);
        return mapper.toBundle();
    }
}
