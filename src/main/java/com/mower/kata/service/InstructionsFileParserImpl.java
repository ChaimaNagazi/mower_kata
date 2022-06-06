package com.mower.kata.service;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import com.mower.kata.entities.MowInstructions;
import com.mower.kata.entities.Mower;
import com.mower.kata.entities.Position;
import com.mower.kata.exception.InvalidMowInstructionsException;
import com.mower.kata.utils.ParserUtility;

/**
 * class parser allows to parse the file in the format specified
 *
 */
public class InstructionsFileParserImpl implements InstructionsFileParser {

	@Override
	public MowInstructions parseInstructions(String path) throws InvalidMowInstructionsException {

		List<String> lines = new ArrayList<>();
		try {
			lines = Files.readAllLines(new File(path).toPath());
		} catch (Exception e) {
			throw new InvalidMowInstructionsException("Error during reading instructions File!");
		}

		if (lines.size() > 0) {
			Position topRightCorner = ParserUtility.parseTopRightCorner(lines.get(0));
			List<Mower> mowers = ParserUtility.parseMowers(lines.subList(1, lines.size()));
			MowInstructions mowInstructions = new MowInstructions();
			mowInstructions.topRightCorner = topRightCorner;
			mowInstructions.setMowers(mowers);
			return mowInstructions;
		} else {
			throw new InvalidMowInstructionsException("Instructions File is empty!");
		}
	}

}