import ResponseModels.AddBookResponse;
import ResponseModels.BookResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetListOfBooksByAuthor extends BaseTest{


    @DataProvider(name = "AddBook")
    public static Object[][] AddABook() {
        return new Object[][]{{"Learning JAVA Again","BOXXOM","SIND12","543768"},
                {"Learning API Again","BOXXOM","SIND22","543768"},
                {"Learning SE Again"," BOXXOM","SIND32","543768"}};
    }

    @Test(dataProvider = "AddBook")
    public void testAddBook(String bookName,String author,String isbn,String aisle){
        Response response = addNewBook(bookName,author,isbn, aisle);
        AddBookResponse addBook = response.body().as(AddBookResponse.class);
        Assert.assertEquals(addBook.getId(),isbn+aisle);
    }

    @DataProvider(name = "GetBook")
    public static Object[][] GetABook() {
        return new Object[][]{{"BOXXOM",3}};
    }

    @Test(dataProvider = "GetBook")
    public void verifyAddedBooksByAuthor(String authorName, int noOfBooks){
        BookResponse[] getBooks = getBookByAuthor(authorName);
        Assert.assertEquals(getBooks.length, noOfBooks);
        for (BookResponse book : getBooks)
            System.out.println(book.getBookName());

    }

}
