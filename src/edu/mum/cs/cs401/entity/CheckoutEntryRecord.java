package edu.mum.cs.cs401.entity;
import java.util.*;
public class CheckoutEntryRecord {
	private Date dueDate;
	private Date checkoutDate;
	private Book checkoutBook;
	private Member currentMember;
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public Book getCheckoutBook() {
		return checkoutBook;
	}
	public void setCheckoutBook(Book checkoutBook) {
		this.checkoutBook = checkoutBook;
	}
	public Member getCurrentMember() {
		return currentMember;
	}
	public void setCurrentMember(Member currentMember) {
		this.currentMember = currentMember;
	}
}
