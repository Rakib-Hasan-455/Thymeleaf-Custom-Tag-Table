package com.thymeleafcustom.tag.model;

public class Employee {
	private String name;
	private String email;
	private int age;
	private String contactNumber;
	
	public Employee(String name, String email, int age, String contactNumber) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.contactNumber = contactNumber;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
}
