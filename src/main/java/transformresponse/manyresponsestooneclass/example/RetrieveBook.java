package transformresponse.manyresponsestooneclass.example;

public class RetrieveBook {
    private BookProvider1 provider1;
    private BookProvider2 provider2;

    public Book retrieveBook() {
        BookDetailDto bookDetail = provider1.getBookDetail();
        BookInfoDto bookInfo = provider2.getBookInfo();

        return new Book(
                bookDetail.getTitle(),
                bookDetail.getAuthor(),
                bookDetail.getDate(),
                bookInfo.getDate()
        );
    }
}
