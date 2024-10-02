package com.example.carrentalproject.serviceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.carrentalproject.models.Role;
import com.example.carrentalproject.models.User;
import com.example.carrentalproject.repository.RoleRepository;
import com.example.carrentalproject.repository.UserRepository;
import com.example.carrentalproject.services.UserService;

@Service // ("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(Long id) throws BadRequestException {
		// TODO Auto-generated method stub
		User user = userRepository.findById(id);
		return user;
	}

	@Override
	public User addUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public User updateUser(Long id, User user) {
		User userRes = userRepository.findById(id);
		userRes.setPassword(passwordEncoder.encode(user.getPassword()));
		userRes.setPhone(user.getPhone());
		return userRepository.save(userRes);
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
		return;
	}

	@Override
	public Role addRole(Role role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Override
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addRoleToUser(User user, String roleName) {
		// TODO Auto-generated method stub
		//get the role from roles table
		Role role = roleRepository.findByName(roleName);
		Set<Role> newRoles = new HashSet<Role>();
		newRoles.add(role);
		user.setRoles(newRoles);
		return userRepository.save(user);
	}

}
