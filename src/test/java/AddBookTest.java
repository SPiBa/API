
import ResponseModels.AddBookResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddBookTest extends BaseTest{

    @DataProvider(name = "AddBook")
    public static Object[][] AddABook() {
        return new Object[][]{{"Learning Again","SINDHU PAI","SIND","543768",}};
    }

    @Test(dataProvider = "AddBook")
    public void testAddBook(String bookName,String author,String isbn,String aisle){
        Response response = addNewBook(bookName,author,isbn, aisle);
        AddBookResponse addBook = response.body().as(AddBookResponse.class);
        Assert.assertEquals(addBook.getId(),isbn+aisle);
    }

    @Test(dataProvider = "AddBook")
    public void testAddExistingBook (String bookName,String author,String isbn,String aisle){
        Response response = addNewBook(bookName,author,isbn, aisle);
        System.out.println(response.asString());
        AddBookResponse addBook = response.body().as(AddBookResponse.class);
        Assert.assertEquals(addBook.getMessage(),"Add Book operation failed, looks like the book already exists");
    }

}
