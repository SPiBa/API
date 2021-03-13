import RequestModels.AddBookRequest;
import RequestModels.DeleteBookRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.given;

public class BaseTest {

    @BeforeTest
    public void setBaseUrl (){
        RestAssured.baseURI = "http://216.10.245.166";
    }


    public Response addNewBook (String bookName, String author, String isbn, String aisle){
        AddBookRequest addBookRequest = new AddBookRequest();

        addBookRequest.setName(bookName);
        addBookRequest.setAuthor(author);
        addBookRequest.setIsbn(isbn);
        addBookRequest.setAisle(aisle);

        Response response = given().header("Content-Type", "application/json")
                .body(addBookRequest)
                .when().post("/Library/Addbook.php")
                .then().extract().response();

        return response;
    }

    public String getBookByID(String bookId) {
        Response response = given().queryParams("ID", bookId)
                .header("Content-Type", "application/json")
                .when().get("/Library/GetBook.php")
                .then()
                .extract().response();

        return (response.asString());
    }
    public String getBookByAuthor(String author) {
        Response response = given().queryParams("AuthorName", author)
                .header("Content-Type", "application/json")
                .when().get("/Library/GetBook.php")
                .then()
                .extract().response();

        return (response.asString());
    }

    public String deleteByID(String bookId) {

        String delResponse = "{\"ID\" : \""+bookId+"\"}";

        Response response = given()
                .header("Content-Type", "application/json").body(delResponse)
                .when().post("/Library/DeleteBook.php")
                .then()
                .extract().response();

        return (response.asString());
    }

}
