package edu.mum.cs.cs401.controller;

import java.util.Collection;

import edu.mum.cs.cs401.dataaccess.DataAccess;
import edu.mum.cs.cs401.dataaccess.DataAccessImpl;
import edu.mum.cs.cs401.entity.Book;

public class BookController {
	private static BookController instance = new BookController();

	private DataAccess<String, Book> bookAccess = new DataAccessImpl<String, Book>();
	private DataAccess<String, Integer> bookCopyAccess = new DataAccessImpl<String, Integer>();
	
	private BookController() {
		Book book1 = new Book("100", "title0", true);
		Book book2 = new Book("101", "title1", true);
		Book book3 = new Book("102", "title2", true);
		
		bookAccess.add(book1.getISBNNumber(), book1);
		bookAccess.add(book2.getISBNNumber(), book2);
		bookAccess.add(book3.getISBNNumber(), book3);
	}
	
	public static BookController getInstance() {return instance;}
	
	public DataAccess<String, Book> getBookAccess() {
		return bookAccess;
	}

	public void setBookAccess(DataAccess<String, Book> bookAccess) {
		this.bookAccess = bookAccess;
	}
	
	public Book getBookByISBN(String ISBN) {
		return bookAccess.get(ISBN);
	}
	
	public void addBook(Book book) {
		bookAccess.add(book.getISBNNumber(), book);
	}
	
	public boolean addBookCopy(String isbn) {
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
	
//	public BookCopy getBookCopyByNumber()
}
