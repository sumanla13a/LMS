package edu.mum.cs.cs401.entity;
import java.util.ArrayList;
import java.util.List;

public class Book {
	private String title;
	private String ISBN;
//	TODO: unlock later when author is implemented
	private List<Author> authorList;

	private List<BookCopy> copyList = new ArrayList<BookCopy>();
	private boolean availability;
	
	public void addBookCopy(BookCopy bookCopy) {
		copyList.add(bookCopy);
	}
	
	public int getCopyNumber() {
		return copyList.size();
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getISBN() {
		return this.ISBN;
	}
	
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	
	public Book(String ISBN, String title, boolean availability) {
		this.ISBN = ISBN;
		this.title = title;
		this.availability = availability; 

		BookCopy bookCopy = new BookCopy(this, 100);
		addBookCopy(bookCopy);
	}
	public Book(){}
	
	@Override
	public String toString() {
		return "Book [title= " + title + ", ISBN=" + ISBN + ","
				+ " availability=" + availability + ", copyNum = " + copyList.size() + " ]";
	}
	
}
