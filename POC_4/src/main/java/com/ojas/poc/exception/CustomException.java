package com.ojas.poc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class CustomException extends RuntimeException {

		public CustomException(String msg) {
			super(msg);
		}

}
