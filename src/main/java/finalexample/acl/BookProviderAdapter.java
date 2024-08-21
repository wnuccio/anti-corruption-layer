package finalexample.acl;

import finalexample.acl.dtos.BookBundleDto;
import finalexample.acl.mappers.BookBundleDtoMapper;
import finalexample.domain.BookBundle;
import finalexample.domain.BookService;

import java.util.List;

public class BookProviderAdapter implements BookService {

    private final BookProvider bookProvider;

    public BookProviderAdapter(BookProvider bookProvider) {
        this.bookProvider = bookProvider;
    }

    @Override
    public BookBundle retrieveBooks(String keyword) {
        return retrieveBooks(List.of(keyword));
    }

    @Override
    public BookBundle retrieveBooks(List<String> keywords) {
        BookBundleDto bundleDto = bookProvider.getBookBundle(keywords);
        BookBundleDtoMapper mapper = new BookBundleDtoMapper(bundleDto);
        return mapper.toBundle();
    }


}
