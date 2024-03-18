package com.pruthvi.relations.dto;

import java.util.List;

import com.pruthvi.relations.entity.Address;

import lombok.Data;

@Data
public class AddressSearchRequestBody {

	private SearchType searchType = SearchType.BASIC;
	
	private String country;
	
	private String state;
	
	private String city;
	
	private List<String> states;
	
	private Integer pinCode;
}
