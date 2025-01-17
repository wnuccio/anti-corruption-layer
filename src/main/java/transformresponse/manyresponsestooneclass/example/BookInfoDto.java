package transformresponse.manyresponsestooneclass.example;

import java.util.Date;

public class BookInfoDto {
    private String title;
    private String createdBy;
    private String state;
    private Date date;

    public String getTitle() {
        return title;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getState() {
        return state;
    }

    public Date getDate() {
        return date;
    }
}
