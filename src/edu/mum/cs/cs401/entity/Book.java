package edu.mum.cs.cs401.entity;

public class Book {
	private String title;
	private int ISBNNumber;
//	TODO: unlock later when author is implemented
//	private List<Author> authorList;
	private boolean availability;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getISBNNumber() {
		return ISBNNumber;
	}
	public Integer getNumberISBN() {
		return new Integer(ISBNNumber);
	}
	
	public void setISBNNumber(int iSBNNumber) {
		ISBNNumber = iSBNNumber;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	
	public Book(int ISBN, String title, boolean availability) {
		this.ISBNNumber = ISBN;
		this.title = title;
		this.availability = availability; 
	}
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", ISBNNumber=" + ISBNNumber + ", availability=" + availability + "]";
	}
	
}
