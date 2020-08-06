package com.encore.exception;

public class RecordNotFoundException extends Exception {
	public RecordNotFoundException() {
		this("This is DuplicateNameException....");
	}
	public RecordNotFoundException(String message) {
		super(message);
	}

}
