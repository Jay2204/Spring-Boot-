package com.boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such Keyword")
public class UserIdExistException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UserIdExistException(int id) {
		super(id  + "already exist");
	}
}
