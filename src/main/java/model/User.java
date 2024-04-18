package model;

import java.time.LocalDate;

import org.apache.commons.codec.digest.DigestUtils;


public class User {
	private String name;
	private String surname;
	private String email;
	private String phoneNumber;
	private LocalDate birthDate;
	private LocalDate accountDate;
	private boolean suspended;
	private UserStatus status;
	/*
	 * Status index :
	 * Admin --> 1
	 * Cleaner --> 2
	 * Owner --> 3
	 */

	//Basic user  constructor
	public User(
	    String name,
	    String pwd,
	    String surname,
	    String email,
	    String phoneNumber,
	    LocalDate birthDate,
	    boolean suspended,
	    UserStatus status
	) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.birthDate = birthDate;
		this.accountDate = LocalDate.now();
		this.suspended = suspended;
		this.status = status;
	}

	public User(String name) {
		this.name = name;
	}


	//Admin-friendly constructor
	public User(
	    String name,
	    String surname,
	    String email,
	    UserStatus status
	) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.status = status;
	}

	public static String sha3256Hashing(String pwd) {
		StringBuilder salted = new StringBuilder(pwd);
		// salted.insert(3, 'P');
		pwd = salted.toString();;
		return  new DigestUtils("SHA3-256").digestAsHex(pwd);
	}

	public boolean isSuspended() {
		return suspended;
	}

	public void setSuspended(boolean suspended) {
		this.suspended = suspended;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public LocalDate getAccountDate() {
		return this.accountDate;
	}

	public void  setAccountLocalDate(LocalDate accountDate) {
		this.accountDate = accountDate;
	}

	public UserStatus getStatus() {
		return this.status;
	}

	public void connection() {

	}

	public void disconnection() {

	}
}