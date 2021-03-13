package ResponseModels;

import RequestModels.AddBookRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Scenario1 {


    @Test
    public void AddNewBook (){

        RestAssured.baseURI = "http://216.10.245.166";

        AddBookRequest addBookRequest = new AddBookRequest();

        addBookRequest.setName("TEST API");
        addBookRequest.setAuthor("SINDHU");
        addBookRequest.setIsbn("689no");
        addBookRequest.setAisle("983");

        Response response = given().header("Content-Type", "application/json")
                .body(addBookRequest)
                .when().post("/Library/Addbook.php")
                .then()
                .assertThat().statusCode(200).extract().response();

        System.out.println(response.asString());

        AddBookResponse addBook = response.body().as(AddBookResponse.class);
        Assert.assertEquals(addBook.getId(),"689no983");

    }
}
