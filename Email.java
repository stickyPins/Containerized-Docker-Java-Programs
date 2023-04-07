/*
 * Email App for Shape Security contractors on-boarding to F5
 * Author : Will Odam
 * Lead Consultant : JFrog
 * 
 */


package com.bmc.it.systetems.emailApp;

import java.util.Scanner;

public class Email {

	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 8;
	private String alternateEmail;
	private String email;
	private String companyDomain = "bmc.com";

	// Constructor to receive first and last name
	public Email(String firstName, String lastName) {

		this.firstName = firstName;
		this.lastName = lastName;

		// Call method asking for department - return department
		this.department = setDepartment();

		// Call method that returns the password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is " + this.password);

		// Combine elements to generate password
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companyDomain;

	}

	// Ask for department
	private String setDepartment() {
		System.out.println("New worker: " + firstName
				+ ". Department Codes:\n1 for Sales\n2 for Development\n3 for Acconting\n0 for none\nEnter Department Code");
		try (Scanner in = new Scanner(System.in)) {
			int departmentChoice = in.nextInt();
			if (departmentChoice == 1) {
				return "sales";
			} else if (departmentChoice == 2) {
				return "development";
			} else if (departmentChoice == 3) {
				return "accounting";
			} else {
				return " ";
			}
		}
	}

	// Generate a random password

	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRST0123456789!@#$%";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);

		}
		return new String(password);

	}

	// Set Mailbox Capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}

	// Set the alternate email

	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}

	// Change the password
	public void changePassword(String password) {
		this.password = password;
	}

	// Get Mailbox Capacity
	public int getMailboxCapacity() {
		return mailboxCapacity;
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}

	public String getPassword() {
		return password;
	}

	public String showInfo() {
		return "Display NAME: " + " " + firstName + " " + lastName + "\nCOMPANY EMAIL: " + email + "\nMAILBOX CAPACITY: "
				+ mailboxCapacity + "mb";
	}

}