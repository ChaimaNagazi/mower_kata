package com.mower.kata.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.mower.kata.entities.Mower;
import com.mower.kata.entities.Position;
import com.mower.kata.enums.Action;
import com.mower.kata.enums.Orientation;
import com.mower.kata.exception.InvalidMowInstructionsException;

public class ParserUtility {

	public static List<List<String>> subListsOfList(List<String> sourceList, int subListLength)
			throws InvalidMowInstructionsException {
		if (sourceList == null) {
			throw new InvalidMowInstructionsException("Transformation Exception!");
		}
		List<List<String>> subLists = new ArrayList<>();
		for (int i = 0; i < sourceList.size(); i += subListLength) {
			subLists.add(sourceList.subList(i, Math.min(i + subListLength, sourceList.size())));
		}
		return subLists;
	}

	public static Position parseTopRightRightCorner(String firstLine) throws InvalidMowInstructionsException {
		try {
			return parsePosition(firstLine);
		} catch (Exception exception) {
			throw new InvalidMowInstructionsException("Top right corner is missing !");
		}
	}

	public static List<Mower> parseMowers(List<String> lines) throws InvalidMowInstructionsException {
		List<Mower> mowers = new ArrayList<>();
		List<List<String>> mowerLines = ParserUtility.subListsOfList(lines, 2);
		for (List<String> mowerLine : mowerLines) {
			mowers.add(mapToMower(mowerLine));
		}
		return mowers;
	}

	public static Mower mapToMower(List<String> mowerLines) throws InvalidMowInstructionsException {
		try {
			Position mowerPosition = parsePosition(mowerLines.get(0));
			Orientation mowerOrientation = Orientation.valueOf(mowerLines.get(0).substring(4, 5));
			List<Action> instructions = Arrays.stream(mowerLines.get(1).split("")).map(Action::valueOf)
					.collect(Collectors.toList());
			return new Mower(mowerPosition, mowerOrientation, instructions);
		} catch (Exception exception) {
			throw new InvalidMowInstructionsException("Invalid instructions !");
		}
	}

	/**
	 * @param mowerLines
	 * @return
	 * @throws NumberFormatException
	 */
	private static Position parsePosition(String line) throws NumberFormatException {
		int positionX = Integer.parseInt(line.substring(0, 1));
		int positionY = Integer.parseInt(line.substring(2, 3));
		return new Position(positionX, positionY);
	}
}
