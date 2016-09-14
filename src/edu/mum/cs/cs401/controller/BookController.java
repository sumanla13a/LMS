package edu.mum.cs.cs401.controller;

import java.util.Collection;

import edu.mum.cs.cs401.dataaccess.DataAccess;
import edu.mum.cs.cs401.dataaccess.DataAccessImpl;
import edu.mum.cs.cs401.entity.Book;

public class BookController {
	private static BookController instance = new BookController();
	
	private DataAccess<String, Book> dataAccess = new DataAccessImpl<String, Book>();
	
	private BookController() {}
	
	public static BookController getInstance() {return instance;}
	
	public Book addNewBook(Book book) {
		return dataAccess.add(book.getISBNNumber(), book);
	}
	
	public Book getBookByISBNNumber(String isbn) {
		return dataAccess.get(isbn);
	}
	
	public Collection<Book> getAll() {
		return dataAccess.get();
	}
}
