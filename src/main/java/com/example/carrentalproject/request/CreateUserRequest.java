package com.example.carrentalproject.request;

import java.util.Set;

import com.example.carrentalproject.models.Role;

public class CreateUserRequest {

	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String password;
	private Integer phone;
	private Set<Role> roles;

	public CreateUserRequest() {
		// TODO Auto-generated constructor stub
	}

	public CreateUserRequest(String firstName, String lastName, String username, String email, String password,
			Integer phone, Set<Role> roles) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.roles = roles;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "CreateUserRequest [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", email=" + email + ", password=" + password + ", phone=" + phone + ", roles=" + roles + "]";
	}

}
