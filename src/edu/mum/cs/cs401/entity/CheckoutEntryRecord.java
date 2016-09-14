package edu.mum.cs.cs401.entity;
import java.time.LocalDate;
import java.util.*;
import edu.mum.cs.cs401.entity.BookCopy;
public class CheckoutEntryRecord {
	private LocalDate dueDate;
	private LocalDate checkoutDate;
	private BookCopy bookCopy;
	private String currentMemberId;

	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	
	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public String getCurrentMemberId() {
		return currentMemberId;
	}
	public void setCurrentMemberId(String currentMemberId) {
		this.currentMemberId = currentMemberId;
	}

	public BookCopy getBookCopy() {
		return bookCopy;
	}
	public void setBookCopy(BookCopy bookCopy) {
		this.bookCopy = bookCopy;
	}
	@Override
	public String toString() {
		return "CheckoutEntryRecord [dueDate=" + dueDate + ", checkoutDate=" + checkoutDate + ", bookCopy=" + bookCopy
				+ ", currentMemberId=" + currentMemberId + "]";
	}

	/*public String getISBNNumber() {
		return this.ISBNNumber;
	}
	public void setISBNNumber(String iSBNNumber) {
		ISBNNumber = iSBNNumber;
	}*/
}
