package au.gov.datarefactory.domain;

import java.io.Serializable;

/**
* A Person Object Used for testing code
* 
* @author  David Sheard
* @version 1.0
* @since   2019-04-22
*/
public class Person implements Serializable{

	private static final long serialVersionUID = 7433574122837673434L;
	private String surname;
	private String givenName;
	private String dob;
	private String gender;
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
