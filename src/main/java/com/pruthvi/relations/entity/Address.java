package com.pruthvi.relations.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name ="ADDRESS")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String country;
	
	private String state;
	
	private String city;
	
	private String addressLineOne;
	
	private String addressLineTwo;
	
	private Integer pinCode;

	//In Case of Bi-Directional use in Both Objects 
//	@OneToOne
//	@JoinColumn(name ="employee_Id")
//	private Employee employee;
}
