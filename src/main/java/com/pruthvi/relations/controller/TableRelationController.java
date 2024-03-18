package com.pruthvi.relations.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pruthvi.relations.dto.AddressSearchRequestBody;
import com.pruthvi.relations.dto.EmployeeResponse;
import com.pruthvi.relations.entity.Address;
import com.pruthvi.relations.entity.Employee;
import com.pruthvi.relations.entity.Project;

@Validated
public interface TableRelationController {
	
	@GetMapping("/{employeeId}/employee-details")
	public ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable Integer employeeId) throws Exception;
	
	@PostMapping(path = "/address-search", consumes = "application/json")
	public ResponseEntity<List<Address>> searchAddress(@RequestBody AddressSearchRequestBody searchRequestBody) throws Exception;
	
	@GetMapping(path = "/projects")
	public ResponseEntity<List<Project>> getProjects();
	
	@PutMapping(path = "employeeId/{employeeId}/projectId/{projectId}", consumes = "application/json")
	public ResponseEntity<Employee> assignProjectToEmployee(@PathVariable Integer employeeId,@PathVariable Integer projectId);
}
