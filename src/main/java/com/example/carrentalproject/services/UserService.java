package com.example.carrentalproject.services;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import com.example.carrentalproject.models.Role;
import com.example.carrentalproject.models.User;

@Service
public interface UserService {
	public User addUser(User user);

	public List<User> getAllUsers();

	public User getUser(Long id) throws BadRequestException;

	public User updateUser(Long id, User user);

	public void deleteUser(Long id);

	public Role addRole(Role role);
	
	public List<Role> getAllRoles();
	
	public User addRoleToUser(User user, String roleName);
}
