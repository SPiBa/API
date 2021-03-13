import ResponseModels.AddBookResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetBooksByAuthor extends BaseTest{


    @DataProvider(name = "AddBook")
    public static Object[][] AddABook() {
        return new Object[][]{{"Learning JAVA Again","SINDHU PAI","SIND1","543768"},
                {"Learning API Again","SINDHU PAI","SIND2","543768"},
                {"Learning SE Again","SINDHU PAI","SIND3","543768"}};
    }

    @Test(dataProvider = "AddBook")
    public void testAddBook(String bookName,String author,String isbn,String aisle){
        Response response = addNewBook(bookName,author,isbn, aisle);
        AddBookResponse addBook = response.body().as(AddBookResponse.class);
        Assert.assertEquals(addBook.getId(),isbn+aisle);
    }


}
