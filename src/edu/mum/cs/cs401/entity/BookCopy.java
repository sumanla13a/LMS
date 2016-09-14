package edu.mum.cs.cs401.entity;

public class BookCopy extends Book {
	private int copyNumber;
	private String ISBN;
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
	
}
