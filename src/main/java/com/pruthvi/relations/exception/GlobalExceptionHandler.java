package com.pruthvi.relations.exception;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<ErrorResponse> handleInvalidInputException(Exception expObj) {

		/** add structure to error to look good , you can directly throw your Exception **/
		var error = new Error("ERROR_INVALID", expObj.getMessage(),"");
		var errorDataItem = new ErrorResponseDataItems();
		errorDataItem.setErrors(new ArrayList<>(List.of(error)));
		ArrayList<ErrorResponseDataItems> dataItems = new ArrayList<>();
		dataItems.add(errorDataItem);
		var errorReponse = new ErrorResponse("Error", OffsetDateTime.now(), "Invalid Input Exception", dataItems);
		return new ResponseEntity<ErrorResponse>(errorReponse, HttpStatus.NOT_FOUND);
	}
}
