package edu.mum.cs.cs401.entity;

public class Author {
	private String firstName;
	private String lastName;
	private String bio;
	@Override
	public String toString() {
		return "Author [firstName=" + firstName + ", lastName=" + lastName + ", bio=" + bio + "]";
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	
}
