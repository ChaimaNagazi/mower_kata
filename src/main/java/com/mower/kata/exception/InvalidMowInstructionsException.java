package com.mower.kata.exception;

/**
 * create new checked exception thrown when invalid file or invalid instruction
 *
 */
public class InvalidMowInstructionsException extends Exception {

	public InvalidMowInstructionsException(String message) {
		super(message);
	}
}
