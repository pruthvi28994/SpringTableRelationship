package com.pruthvi.relations.exception;

import java.util.List;

import lombok.Data;

@Data
public class InvalidInputException extends Exception {/**
	 * 
	 */
	private static final long serialVersionUID = 4007608575967107701L;
	
	private transient List<ErrorResponseDataItems> errors = null;

	public InvalidInputException(String msg) {
		//Sends msg to Exception class
		super(msg);
		this.errors = null;
	}
	
	
}
