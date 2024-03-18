package com.pruthvi.relations.dto;

import java.util.List;
import com.pruthvi.relations.entity.Employee;

import lombok.Data;

@Data
public class EmployeeResponse {
	
	private String status;
	
	private Employee employeeDtl;
}
