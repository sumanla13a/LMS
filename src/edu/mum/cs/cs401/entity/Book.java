package edu.mum.cs.cs401.entity;
import java.util.List;
public class Book {
	private String title;
	private String ISBNNumber;
//	TODO: unlock later when author is implemented
	private List<Author> authorList;
	private boolean availability;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getISBNNumber() {
		return this.ISBNNumber;
	}
	public void setISBNNumber(String iSBNNumber) {
		this.ISBNNumber = iSBNNumber;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

}
