package edu.mum.cs.cs401.controller;
import edu.mum.cs.cs401.dataaccess.DataAccess;
import edu.mum.cs.cs401.dataaccess.DataAccessImpl;
import edu.mum.cs.cs401.entity.Book;
//import edu.mum.cs.cs401.entity.BookCopy;

public class BookController {
	private static BookController instance = new BookController();

	private DataAccess<Integer, Book> bookAccess = new DataAccessImpl<Integer, Book>();
	private DataAccess<Integer, Integer> bookCopyAccess = new DataAccessImpl<Integer, Integer>();
	
	private BookController() {
		Book book1 = new Book(100, "title0", true);
		Book book2 = new Book(101, "title1", true);
		Book book3 = new Book(102, "title2", true);
		
		bookAccess.add(book1.getNumberISBN(), book1);
		bookAccess.add(book2.getNumberISBN(), book2);
		bookAccess.add(book3.getNumberISBN(), book3);
	}
	
	public static BookController getInstance() {return instance;}
	
	public DataAccess<Integer, Book> getBookAccess() {
		return bookAccess;
	}

	public void setBookAccess(DataAccess<Integer, Book> bookAccess) {
		this.bookAccess = bookAccess;
	}
	
	public Book getBookByISBN(Integer ISBN) {
		return bookAccess.get(ISBN);
	}

	public boolean addBookCopy(Integer isbn) {
		Book book = bookAccess.get(isbn);
		if (book == null) {
			System.out.println("no this book with ISBN" + isbn);
			return false;
		}

		Integer num = bookCopyAccess.get(isbn);
		if (num == null) {
			bookCopyAccess.add(isbn, new Integer(1));
			return true;
		}

		int updateNum = num.intValue() + 1;
		bookCopyAccess.update(isbn, new Integer(updateNum));
		return true;
	}

}
