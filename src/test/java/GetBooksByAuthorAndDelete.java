import ResponseModels.AddBookResponse;
import ResponseModels.BookResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetBooksByAuthorAndDelete extends BaseTest {

    @DataProvider(name = "AddBook")
    public static Object[][] AddABook() {
        return new Object[][]{{"Learning JAVA HandsOn", "BOXAAM", "SIND123", "5437689"},
                {"Learning API HandsOn", "BOXAAM", "SIND223", "5437689"},
                {"Learning SE HandsOn", " BOXAAM", "SIND323", "5437689"}};
    }

    @Test(dataProvider = "AddBook")
    public void testAddBook(String bookName, String author, String isbn, String aisle) {
        Response response = addNewBook(bookName, author, isbn, aisle);
        AddBookResponse addBook = response.body().as(AddBookResponse.class);
        Assert.assertEquals(addBook.getId(), isbn + aisle);
    }

    @DataProvider(name = "GetBook")
    public static Object[][] GetABook() {
        return new Object[][]{{"BOXAAM", 3}};
    }

    @Test(dataProvider = "GetBook")
    public void verifyAddedBooksByAuthor(String authorName, int noOfBooks) {
        BookResponse[] getBooks = getBookByAuthor(authorName);
        Assert.assertEquals(getBooks.length, noOfBooks);
        for (BookResponse book : getBooks)
            System.out.println(book.getBookName());
    }


    @DataProvider(name = "GetBook2")
    public static Object[][] GetAnotherBook() {
        return new Object[][]{{"BOOM"}};
    }
    @Test(dataProvider = "GetBook2")
    public void deleteBookByAuthor(String authorName) {
        String bookId;
        BookResponse[] getBooks = getBookByAuthor(authorName);
        bookId = getBooks[0].getIsbn() + getBooks[0].getAisle();

        String deleteResponse = deleteByID(bookId);
        Assert.assertEquals(deleteResponse, "{\"msg\":\"book is successfully deleted\"}");
    }


    @Test(dataProvider = "GetBook")
    public void verifyAgainBooksByAuthor(String authorName, int noOfBooks) {
        BookResponse[] getBooks = getBookByAuthor(authorName);
        Assert.assertEquals(getBooks.length, noOfBooks);
        for (BookResponse book : getBooks)
            System.out.println(book.getBookName());
    }



}
