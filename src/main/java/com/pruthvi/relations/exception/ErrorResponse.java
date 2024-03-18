package com.pruthvi.relations.exception;


import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

	@JsonProperty("status")
	private String status;
	
	@JsonProperty("timeStamp")
	private OffsetDateTime timeStamp;
	
	@JsonProperty("message")
	private String message;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("dataItems")
	private List<ErrorResponseDataItems> dataItems = null; 
}
