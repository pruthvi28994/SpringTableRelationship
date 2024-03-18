package com.pruthvi.relations.exception;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseDataItems {

	private String ref = "";
	
	private String identifier = "";
	
	private List<Error> errors;
}
