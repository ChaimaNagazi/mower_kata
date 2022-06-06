package com.mower.kata.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import com.mower.kata.exception.InvalidMowInstructionsException;

class ParserUtilityTest {

	@Test
	public void subListsOfList_should_throw_IllegalArgumentException_when_sourceList_isNull()
			throws InvalidMowInstructionsException {
		// Given
		List<String> sourceList = null;
		int subListLength = 2;
		// When
		Executable executable = () -> ParserUtility.subListsOfList(sourceList, subListLength);

		// Then
		assertThrows(InvalidMowInstructionsException.class, executable);
	}

	@Test
	public void subListsOfList_should_return_emptyList() throws InvalidMowInstructionsException {
		// Given
		List<String> sourceList = Arrays.asList();
		int subListLength = 2;
		List<List<String>> expectedSublist = Arrays.asList();

		// When
		List<List<String>> actualSublist = ParserUtility.subListsOfList(sourceList, subListLength);

		// Then
		assertEquals(expectedSublist, actualSublist);
	}

	@Test
	public void subListsOfList_should_return_correctSublist() throws InvalidMowInstructionsException {
		// Given
		List<String> sourceList = Arrays.asList("A", "B", "C", "D", "E");
		int subListLength = 2;
		List<List<String>> expectedSublist = Arrays.asList(Arrays.asList("A", "B"), Arrays.asList("C", "D"),
				Arrays.asList("E"));

		// When
		List<List<String>> actualSublist = ParserUtility.subListsOfList(sourceList, subListLength);

		// Then
		assertEquals(expectedSublist, actualSublist);
	}
}