package transformresponse.manyresponsestooneclass.example;

import java.util.Date;

public class BookDetailDto {
    private String title;
    private String author;
    private Date date;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Date getDate() {
        return date;
    }
}
