package com.wellington.springmongo.resource.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
}
