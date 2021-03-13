import ResponseModels.AddBookResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.sound.midi.Soundbank;

public class DeleteBookAfterAddingABook extends BaseTest {


    @DataProvider(name = "DeleteBook")
    public static Object[][] AddABook() {
        return new Object[][]{{"Learning Again", "SINDHU PAI", "SINDPi", "65789",}};
    }

    @Test(dataProvider = "DeleteBook")
    public void testDeleteBook(String bookName, String author, String isbn, String aisle) {

        Response response = addNewBook(bookName, author, isbn, aisle);
        AddBookResponse addBook = response.body().as(AddBookResponse.class);
        System.out.println("Adding the book");
        Assert.assertEquals(addBook.getId(), isbn + aisle);


        String bookResponse = getBookByID(addBook.getId());
        String newBookID = addBook.getId();
        System.out.println("The details of the book added are");
        Assert.assertEquals(bookResponse, "[{\"book_name\":\"" + bookName + "\",\"isbn\":\"" + isbn + "\",\"aisle\":\"" + aisle + "\",\"author\":\"" + author + "\"}]");

        String deleteResponse = deleteByID(newBookID);
        System.out.println("Deleting the book");
        Assert.assertEquals(deleteResponse, "{\"msg\":\"book is successfully deleted\"}");

        bookResponse = getBookByID(newBookID);
        System.out.println("Check if book exists");
        Assert.assertEquals(bookResponse, "{\"msg\":\"The book by requested bookid \\/ author name does not exists!\"}");

        response = addNewBook(bookName, author, isbn, aisle);
        addBook = response.body().as(AddBookResponse.class);
        System.out.println("Add book again");
        Assert.assertEquals(addBook.getId(), isbn + aisle);

    }
}
