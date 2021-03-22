# API

Hit Library API
1. [POSITIVE TC]
-AddBook()
 	 -Validate Book that has been added getBook(id)
   
Solution – API/src/test/java/AddBookTest.java

2. [NEGATIVE TC]
-AddBook() // add the book which is already added
 	 -Validate Book that has been added getBook(id) // Validate the error message if any
   
Solution – API/src/test/java/AddExistingBookTest.java

3. [DELETE]
1. AddBook: [id=123]
2. Validate Book recently added getBook(id=123)
3. Delete the Book Added (id=123)
4. Validate getBook(id=123)
5. AddBook(id=123) // User Should be able to add Book
Solution – API/ src/test/java/DeleteBookAfterAddingABook.java
4. [Get Book By Author Name]
1. Add  book1 with Author name 'boxxom' [book name should be unique for all]
2. Add  book2 with Author name 'boxxom'
3. Add  book3 with Author name 'boxxom'
4. Get Book By Author Name
5. Validate no. of Books returned (in this case 3)
6. Print Book name of all the 3 books added

Solution – API/ src/test/java/GetListOfBooksByAuthor.java

5. [Get Book By Author Name/ Delete]
1. Add  book1 with Author name 'boxxom' [book name should be unique for all]
2. Add  book2 with Author name 'boxxom'
3. Add  book3 with Author name 'boxxom'
4. Get Book By Author Name
5. Delete one Book with author name 'boom'
6. Validate no. of Books returned (in this case 3)
7. Print Book name of all the 3 books added


Solution – API/ src/test/java/GetBooksByAuthorAndDelete.java

