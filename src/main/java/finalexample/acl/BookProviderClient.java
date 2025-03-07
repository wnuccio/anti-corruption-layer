package finalexample.acl;

import finalexample.acl.dtos.BookRequestDto;
import finalexample.acl.dtos.BookResponseDto;

public class BookProviderClient {
    public BookResponseDto getBookBundle(BookRequestDto requestDto) {
        // in a real application this class would be responsible for fetching the data from a remote service
        throw new UnsupportedOperationException("Not implemented");
    }
}
