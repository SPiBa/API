package RequestModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.codehaus.groovy.ast.expr.UnaryMinusExpression;

public class AddBookRequest {

    private String name;
    private String author;
    private String isbn;
    private String aisle;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
