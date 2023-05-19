package com.amk.service;

import java.util.Random;

public class EmailService {

	private String firstName;
	private String lastName;
	private String department;
	private String generatedEmailId;
	private String alternateEmailId;
	private StringBuffer generatedPassword = new StringBuffer();
	private int mailBoxCapacity = 200;
	private String companySuffix = "amk.com";

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public StringBuffer getGeneratedPassword() {
		return generatedPassword;
	}

	public String getDepartment() {
		return department;
	}

	public String getGeneratedEmailId() {
		return generatedEmailId;
	}

	public void setGeneratedEmailId(String generatedEmailId) {
		this.generatedEmailId = generatedEmailId;
	}

	public int getMailBoxCapacity() {
		return mailBoxCapacity;
	}

	public String getAlternateEmailId() {
		return alternateEmailId;
	}

	// setting department
	public void setDepartment(int choice) {

		switch (choice) {
		case 1:
			this.department = "Sales";
			break;
		case 2:
			this.department = "IT";
			break;
		case 3:
			this.department = "Accounts";
			break;
		case 4:
			this.department = "HR";
			break;
		default:
			this.department = "none";

		}
		// this.generateEmail(this.firstName, this.lastName);
		// this.generatePassword();
	}

	// Email generator
	public String generateEmail() {

		// this.firstName = firstName;
		// this.lastName = lastName;
		String emailId = this.firstName + "." + this.lastName + "." + this.department + "." + this.companySuffix;

		return emailId;
	}

	// Password generator
	public StringBuffer generatePassword() {

		String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
		String specialCharacters = "!@#$";
		String numbers = "1234567890";
		String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
		Random random = new Random();
		char[] password = new char[8];

		password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
		password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
		password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
		password[3] = numbers.charAt(random.nextInt(numbers.length()));

		for (int i = 4; i < 8; i++) {
			password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
		}
		return generatedPassword.append(password);

	}

	// change password
	public String changePassword(StringBuffer newPassword) {

		generatedPassword.append(newPassword);
		String message = "Changed the password Successfully...";
		return message;
	}

	// setting alternate email
	public String setAlternateEmailId(String alternateEmailId) {
		this.alternateEmailId = alternateEmailId;
		return "alternate email set successfully...";
	}

	// setting mail box capacity
	public void setMailBoxCapacity(int mailBoxCapacity) {
		this.mailBoxCapacity = mailBoxCapacity;
	}

}
