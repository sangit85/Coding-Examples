package com.spring.controller;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegistrationBean {

	@NotNull
	@Size(min = 1, message = "You can't leave this empty.")
	private String firstName;

	@NotNull
	@Size(min = 1, message = "You can't leave this empty.")
	private String lastName;

	@NotNull(message = "You can't leave this empty.")
	@Min(value = 13, message = "You must be greater than or equal to 13")
	@Max(value = 19, message = "You must be less than or equal to 19")
	private Integer age;

	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = "Invalid email")
	private String email;
	

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
