package edu.mum.cs.cs401.entity;

public class Book {
	private String title;
	private String ISBNNumber;
//	TODO: unlock later when author is implemented
//	private List<Author> authorList;
	private boolean availability;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getISBNNumber() {
		return ISBNNumber;
	}
	
	public void setISBNNumber(String ISBN) {
		this.ISBNNumber = ISBN;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	
	public Book(String ISBN, String title, boolean availability) {
		this.ISBNNumber = ISBN;
		this.title = title;
		this.availability = availability; 
	}
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", ISBNNumber=" + ISBNNumber + ", availability=" + availability + "]";
	}
	
}
