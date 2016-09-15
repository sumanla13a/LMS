package edu.mum.cs.cs401.entity;

public class BookCopy {
	private String copyNumber;
	private Book book;
	private boolean isCheckedout;
	
	public boolean isCheckedout() {
		return isCheckedout;
	}

	public void setCheckedout(boolean isCheckedout) {
		this.isCheckedout = isCheckedout;
	}

	public BookCopy(Book book, String copyNumber) {
		this.copyNumber = copyNumber;
		this.setBook(book);
		this.isCheckedout = false;
	}
	
	public String getCopyNumber() {
		return this.copyNumber;
	}

	public void setCopyNumber(String copyNumber) {
		this.copyNumber = copyNumber;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
}
