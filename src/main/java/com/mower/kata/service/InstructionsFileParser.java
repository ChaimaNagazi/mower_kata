package com.mower.kata.service;

import com.mower.kata.entities.MowInstructions;
import com.mower.kata.exception.InvalidMowInstructionsException;

public interface InstructionsFileParser {
	public MowInstructions parseInstructions(String path) throws InvalidMowInstructionsException;
}
