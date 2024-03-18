package com.pruthvi.relations.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruthvi.relations.Repository.AddressRepository;
import com.pruthvi.relations.Repository.DepartmentRepository;
import com.pruthvi.relations.Repository.EmployeeRepositoy;
import com.pruthvi.relations.Repository.ProjectRepository;
import com.pruthvi.relations.dto.AddressSearchRequestBody;
import com.pruthvi.relations.dto.EmployeeResponse;
import com.pruthvi.relations.entity.Address;
import com.pruthvi.relations.entity.Department;
import com.pruthvi.relations.entity.Employee;
import com.pruthvi.relations.entity.Project;
import com.pruthvi.relations.exception.InvalidInputException;

@Service
public class TableRelationService {

	private EmployeeRepositoy employeeRepo;
	
	private AddressRepository addressRepo;
	
	private DepartmentRepository departmentRepo;
	
	private ProjectRepository projectRepo;
	
	
	
	public TableRelationService(EmployeeRepositoy employeeRepo, AddressRepository addressRepo,
			DepartmentRepository departmentRepo, ProjectRepository projectRepo) {
		super();
		this.employeeRepo = employeeRepo;
		this.addressRepo = addressRepo;
		this.departmentRepo = departmentRepo;
		this.projectRepo = projectRepo;
	}

	public EmployeeResponse getEmployeeDetails(Integer employeeId) throws InvalidInputException {
		var employeeResponse = new EmployeeResponse();
		employeeResponse.setStatus("Success");
		if(employeeId== null || employeeId==0) {
			throw new InvalidInputException("No records Found");
		}
		var employeeData = employeeRepo.findById(employeeId);
		if(employeeData.isEmpty()) {
			throw new InvalidInputException("No records Found");
		} else {
			employeeResponse.setEmployeeDtl(employeeData.get());
		}
		return employeeResponse;
	}

	public List<Address> searchAddress(AddressSearchRequestBody searchRequestBody) throws InvalidInputException {
		if(searchRequestBody==null) {
			throw new InvalidInputException("No records Found");
		}
		if(searchRequestBody.getStates()!=null && !searchRequestBody.getStates().isEmpty()) {
			return addressRepo.findByStateIn(searchRequestBody.getStates());
		} 
		
		if(searchRequestBody.getCity()!=null && searchRequestBody.getState()!=null) {
			return addressRepo.findByCityStartsWithIgnoringCaseAndStateEndsWithIgnoringCase(searchRequestBody.getCity(), searchRequestBody.getState());
		} 
		
		return addressRepo.findAll();
	}

	public List<Project> getProjects() {
		return projectRepo.findAll();
	}

	public Employee assignProjectToEmployee(Integer employeeId, Integer projectId) {
		var employeeDtl = employeeRepo.findById(employeeId).get();
		var assignedProjects = employeeDtl.getProject();
		
		var project = projectRepo.findById(projectId).get();
		assignedProjects.add(project);
		
		employeeDtl.setProject(assignedProjects);
		return employeeRepo.save(employeeDtl);
	}

}
