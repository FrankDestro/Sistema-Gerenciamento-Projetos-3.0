package com.management.project_managment.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.project_managment.dto.UserDTO;
import com.management.project_managment.services.UserService;

@RestController
@RequestMapping(value = "/users/profile")
public class UserProfileResource {

	@Autowired
	private UserService Userservice;
	
	@GetMapping
	public ResponseEntity <UserDTO> ForCurrentUser() {
		UserDTO dto = Userservice.ProfileUserCurrent();
		return ResponseEntity.ok().body(dto);
	}
	
}
