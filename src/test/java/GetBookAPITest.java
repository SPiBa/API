import ResponseModels.AddBookResponse;
import ResponseModels.BookResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetBookAPITest extends BaseTest{


    @DataProvider(name = "bookID")
    public static Object[][] LoginLogout() {
        return new Object[][]{{"test2910","test mine","test","2910",""}};
    }

    @Test(dataProvider = "bookID")
    public void verifyGetBookByID(String bookId,String bookName, String isbn, String aisle,String author) {
        String bookResponse = getBookByID("test2910");
        System.out.println(bookResponse);
        Assert.assertEquals(bookResponse,"[{\"book_name\":\""+ bookName + "\",\"isbn\":\"" +isbn+ "\",\"aisle\":\""+ aisle+ "\",\"author\":\""+author+"\"}]");
    }

    @Test
    public void verifyGetBookByAuthor() {
        String response = getBookByAuthor("Sind");
        System.out.println(response);
        //BookResponse[] getBooks = response

        //Assert.assertEquals(response.asString(),"[{\"book_name\":\"test mine\",\"isbn\":\"test\",\"aisle\":\"2910\",\"author\":\"\"}]");
    }
}
