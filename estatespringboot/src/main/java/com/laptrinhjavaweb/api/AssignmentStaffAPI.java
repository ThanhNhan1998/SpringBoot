package com.laptrinhjavaweb.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.IUserService;

@RestController
@RequestMapping("/api/assignmentstaff")

public class AssignmentStaffAPI {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping
	public List<UserDTO> staffList(@RequestBody Map<String, String> buildingId){
		return userService.findStaff(Long.parseLong(buildingId.get("buildingId")));
	}
	
	@PostMapping
	public List<UserDTO> assignmentStaff(@RequestBody UserDTO users) {
		return userService.assignmentBuilding(users.getIds(), Long.parseLong(users.getBuildingId()));
	}
}
