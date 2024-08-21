package finalexample.acl;

import finalexample.acl.dtos.BookBundleDto;

import java.util.List;

public class BookProvider {
    public BookBundleDto getBookBundle(List<String> keywords) {
        // in a real application this class would be responsible for fetching the data from a remote service
        throw new UnsupportedOperationException("Not implemented");
    }
}
