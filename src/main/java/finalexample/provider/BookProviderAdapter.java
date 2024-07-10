package finalexample.provider;

import finalexample.domain.BookBundle;
import finalexample.domain.BookService;
import finalexample.domain.Isbn;
import finalexample.provider.dtos.BookBundleDto;
import finalexample.provider.mappers.BookBundleDtoMapper;

public class BookProviderAdapter implements BookService {

    private final BookProvider bookProvider;

    public BookProviderAdapter(BookProvider bookProvider) {
        this.bookProvider = bookProvider;
    }

    @Override
    public BookBundle retrieveBook(Isbn isbn) {
        BookBundleDto bookBundleDto = bookProvider.getBundle(isbn.asString());
        BookBundleDtoMapper mapper = new BookBundleDtoMapper(bookBundleDto);
        return mapper.toBundle();
    }
}
