package com.springapi.player.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springapi.player.exception.PlayerException;
import com.springapi.player.model.PlayerError;

@ControllerAdvice
public class ControllerException {
	
	@ExceptionHandler
	public ResponseEntity<PlayerError> getExceptionNotFound(PlayerException se){
		PlayerError playerError = new PlayerError();
		playerError.setStatusCode(HttpStatus.NOT_FOUND.value());
		playerError.setMessage(se.getMessage());
		playerError.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<PlayerError>(playerError,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<PlayerError> getException(Exception se){
		PlayerError playerError = new PlayerError();
		playerError.setStatusCode(HttpStatus.BAD_REQUEST.value());
		playerError.setMessage(se.getMessage());
		playerError.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<PlayerError>(playerError,HttpStatus.BAD_REQUEST);
	}
	
}
