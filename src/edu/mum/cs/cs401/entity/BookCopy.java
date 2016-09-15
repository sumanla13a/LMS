package edu.mum.cs.cs401.entity;

public class BookCopy extends Book {
	private int copyNumber;
	private String ISBN;
	private Book book;
	
	public BookCopy(Book book, int copyNumber) {
		this.copyNumber = copyNumber;
		this.setBook(book);
	}
	
	public int getCopyNumber() {
		return this.copyNumber;
	}

	public void setCopyNumber(int copyNumber) {
		this.copyNumber = copyNumber;
	}

	public String getISBN() {
		return this.ISBN;
	}

	public void setISBN(String iSBN) {
		this.ISBN = iSBN;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
}
