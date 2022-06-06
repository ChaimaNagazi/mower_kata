package com.mower.kata;

import com.mower.kata.entities.MowInstructions;
import com.mower.kata.exception.InvalidMowInstructionsException;
import com.mower.kata.service.InstructionsFileParser;
import com.mower.kata.service.InstructionsFileParserImpl;

public class MowInstructionsRunner {

	private MowInstructions mowInstructions;
	private InstructionsFileParser instructionsFileParser;

	public MowInstructionsRunner() {
		mowInstructions = new MowInstructions();
		instructionsFileParser = new InstructionsFileParserImpl();
	}

	public String runInstructions(String path) throws InvalidMowInstructionsException {
		mowInstructions = instructionsFileParser.parseInstructions(path);
		mowInstructions.moveAllMowers();
		return mowInstructions.toString();
	}

}
