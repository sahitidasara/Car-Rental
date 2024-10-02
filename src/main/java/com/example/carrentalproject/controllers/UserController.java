package com.example.carrentalproject.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.coyote.BadRequestException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.carrentalproject.models.Role;
import com.example.carrentalproject.models.User;
import com.example.carrentalproject.repository.RoleRepository;
import com.example.carrentalproject.request.CreateUserRequest;
import com.example.carrentalproject.request.UpdateUserRequest;
import com.example.carrentalproject.services.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private RoleRepository roleRepository;

	@PostMapping("/user")
	public ResponseEntity<User> createUser(@Valid @RequestBody CreateUserRequest userReq) throws BadRequestException {
		User userRes = new User();
		Set<Role> roles = userReq.getRoles();
		if (roles == null) {
			Set<Role> roles2 = new HashSet<Role>();
			roles2.add(getUserRole().get());
			userReq.setRoles(roles2);
		}
		modelMapper.map(userReq, userRes);
		userRes = userService.addUser(userRes);
		return new ResponseEntity<>(userRes, HttpStatus.CREATED);
	}

	@GetMapping("/users/all")
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUsers());
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id) throws BadRequestException {
		User userRes = userService.getUser(id);
		if (userRes == null) {
			System.out.println("User is not found with id: " + id);
			throw new BadRequestException("User is not found with id: " + id);
		}
		return ResponseEntity.ok(userRes);
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody UpdateUserRequest userReq)
			throws BadRequestException {
		// check if the given user is present in db
		if (userService.getUser(id) == null) {
			System.out.println("User is not found");
			throw new BadRequestException("User not found");
		}

		User userRes = new User();
		modelMapper.map(userReq, userRes);
		userRes = userService.updateUser(id, userRes);
		return ResponseEntity.ok(userRes);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) throws BadRequestException {
		if (userService.getUser(id) == null) {
			System.out.println("User is not found");
			throw new BadRequestException("User not found");
		}
		userService.deleteUser(id);
		return ResponseEntity.ok(new String("Deleted user successfully"));
	}

	// TODO: should call below API only if the logged in user has admin
	// privileges
	@PostMapping("/role")
	public ResponseEntity<Role> saveRole(@RequestBody Role roleReq) throws BadRequestException {
		Role roleRes = userService.addRole(roleReq);
		return new ResponseEntity<Role>(roleRes, HttpStatus.CREATED);
	}

	@PutMapping("/user/{id}/role")
	public ResponseEntity<User> addRoleToUser(@PathVariable("id") Long id, @RequestParam String roleName)
			throws BadRequestException {
		// check if user is present in db
		User user = userService.getUser(id);
		if (user == null) {
			System.out.println("User is not found");
			throw new BadRequestException("User not found");
		}
		User userRes = userService.addRoleToUser(user, roleName);
		return ResponseEntity.ok(userRes);
	}

	public Optional<Role> getUserRole() {
		return roleRepository.findById(2);
	}
}
