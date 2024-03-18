package com.pruthvi.relations.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.pruthvi.relations.dto.AddressSearchRequestBody;
import com.pruthvi.relations.dto.EmployeeResponse;
import com.pruthvi.relations.entity.Address;
import com.pruthvi.relations.entity.Employee;
import com.pruthvi.relations.entity.Project;
import com.pruthvi.relations.exception.InvalidInputException;
import com.pruthvi.relations.service.TableRelationService;

@RestController
public class TableRelationControllerImpl implements TableRelationController{
	
	private TableRelationService tableService;
	
	public TableRelationControllerImpl(TableRelationService tableService) {
		super();
		this.tableService = tableService;
	}

	@Override
	public ResponseEntity<EmployeeResponse> getEmployeeDetails(Integer employeeId) throws InvalidInputException {
		return ResponseEntity.status(HttpStatus.OK).body(tableService.getEmployeeDetails(employeeId));
	}

	@Override
	public ResponseEntity<List<Address>> searchAddress(AddressSearchRequestBody searchRequestBody) throws InvalidInputException {
		return ResponseEntity.status(HttpStatus.OK).body(tableService.searchAddress(searchRequestBody));
	}

	@Override
	public ResponseEntity<List<Project>> getProjects() {
		return ResponseEntity.status(HttpStatus.OK).body(tableService.getProjects());
	}

	@Override
	public ResponseEntity<Employee> assignProjectToEmployee(Integer employeeId, Integer projectId) {
		return ResponseEntity.status(HttpStatus.OK).body(tableService.assignProjectToEmployee(employeeId,projectId));
	}

	
}
