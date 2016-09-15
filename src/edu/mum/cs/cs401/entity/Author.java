package edu.mum.cs.cs401.entity;

public class Author extends Person {
	private String bio;
	@Override
	public String toString() {
		return "Author [firstName=" + firstName + ", lastName=" + lastName + ", bio=" + bio + "]";
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	
}
