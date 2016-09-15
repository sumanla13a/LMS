package edu.mum.cs.cs401.controller;

import java.util.*;

import edu.mum.cs.cs401.dataaccess.DataAccess;
import edu.mum.cs.cs401.dataaccess.DataAccessImpl;
import edu.mum.cs.cs401.entity.Book;
import edu.mum.cs.cs401.entity.BookCopy;

public class BookController {
	private static BookController instance = new BookController();

	private DataAccess<String, Book> bookAccess = new DataAccessImpl<String, Book>();
	private DataAccess<String, Integer> bookCopyAccess = new DataAccessImpl<String, Integer>();
	
	private BookController() {
		Book book1 = new Book("100", "book title1", true);
		Book book2 = new Book("101", "book title2", true);
		Book book3 = new Book("102", "book title3", true);
		
		bookAccess.add(book1.getISBN(), book1);
		bookAccess.add(book2.getISBN(), book2);
		bookAccess.add(book3.getISBN(), book3);
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
		bookAccess.add(book.getISBN(), book);
	}
	
	public boolean addBookCopy(String isbn) {
		Book book = bookAccess.get(isbn);
		if (book == null) {
			System.out.println("no this book with ISBN: " + isbn);
			return false;
		}
		
		int copyNum = book.getCopyNumber();
		book.addBookCopy(new BookCopy(book, copyNum));


		System.out.println("book: " + book);
		return true;
	}
	
	public BookCopy getBookCopy(Book book) {
		List<BookCopy> books = book.getCopyList();
		for(BookCopy entry : books) {
			if(!entry.isCheckedout()) return entry;
		}
		return null;
	}
}
