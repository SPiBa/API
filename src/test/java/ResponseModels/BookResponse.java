package ResponseModels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookResponse {
    @JsonProperty ("book_name")
    private String bookName;

    @JsonProperty ("isbn")
    private String isbn;

    @JsonProperty ("aisle")
    private String aisle;


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAisle() {
        return aisle;
    }

    public void setAisle(String aisle) {
        this.aisle = aisle;
    }


}
