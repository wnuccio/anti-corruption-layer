package finalexample.acl;

import finalexample.acl.dtos.BookBundleDto;
import finalexample.acl.mappers.BookBundleDtoMapper;
import finalexample.domain.BookBundle;
import finalexample.domain.BookService;
import finalexample.domain.Isbn;

import java.util.List;
import java.util.stream.Collectors;

public class BookProviderAdapter implements BookService {

    private final BookProvider bookProvider;

    public BookProviderAdapter(BookProvider bookProvider) {
        this.bookProvider = bookProvider;
    }

    @Override
    public BookBundle retrieveBook(Isbn isbn) {
        return retrieveBook(List.of(isbn));
    }

    @Override
    public BookBundle retrieveBook(List<Isbn> isbnList) {
        List<String> isbnStrings = isbnList.stream().map(Isbn::asString).collect(Collectors.toList());
        BookBundleDto bookBundleDto = bookProvider.getBundle(isbnStrings);
        BookBundleDtoMapper mapper = new BookBundleDtoMapper(bookBundleDto);
        return mapper.toBundle();
    }
}
