package com.example.carrentalproject.response;

import java.util.Set;

import com.example.carrentalproject.models.Role;
import com.example.carrentalproject.models.User;

public class CreateUserResponse {
	private Long id;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	//private String password;
	private Integer phone;
	private Set<Role> roles;
	

	public CreateUserResponse(User userRes) {
		// TODO Auto-generated constructor stub
		this.id = userRes.getId();
		this.firstName = userRes.getFirstName();
		this.lastName = userRes.getLastName();
		this.username = userRes.getUsername();
		this.email = userRes.getEmail();
		//this.password = userRes.getPassword();
		this.phone = userRes.getPhone();
		this.roles  = userRes.getRoles();
	}


	public CreateUserResponse() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "CreateUserResponse [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", email=" + email + ", phone=" + phone + ", roles=" + roles + "]";
	}
	
	

}
