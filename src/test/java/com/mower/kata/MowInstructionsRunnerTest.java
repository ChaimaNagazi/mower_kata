package com.mower.kata;

import com.mower.kata.exception.InvalidMowInstructionsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MowInstructionsRunnerTest {

	MowInstructionsRunner runner;
	ClassLoader classLoader;

	@BeforeEach
	void setUp() {
		runner = new MowInstructionsRunner();
		classLoader = getClass().getClassLoader();

	}

	@Test
	void runInstructions_should_output_correct_result() throws InvalidMowInstructionsException {
		// Given
		String path = classLoader.getResource("instructions.txt").getPath();
		String expected = "1 3 N 5 1 E";

		// When
		String result = runner.runInstructions(path);

		// Then
		assertEquals(expected, result);

	}

	@Test
	void runInstructions_should_throw_InvalidMowInstructionsException_when_FileIsEmpty()
			throws InvalidMowInstructionsException {
		// Given
		String path = classLoader.getResource("instructions_empty.txt").getPath();

		// When
		Executable executable = () -> runner.runInstructions(path);

		// Then
		assertThrows(InvalidMowInstructionsException.class, executable);

	}

	@Test
	void runInstructions_should_throw_InvalidMowInstructionsException_when_File_Not_Found()
			throws InvalidMowInstructionsException {
		// Given
		String path = "X";

		// When
		Executable executable = () -> runner.runInstructions(path);

		// Then
		assertThrows(InvalidMowInstructionsException.class, executable);

	}

	@Test
	void runInstructions_should_throw_InvalidMowInstructionsException_when_BadSyntax()
			throws InvalidMowInstructionsException {
		// Given
		String path = classLoader.getResource("instructions_bad_syntax.txt").getPath();

		// When
		Executable executable = () -> runner.runInstructions(path);

		// Then
		assertThrows(InvalidMowInstructionsException.class, executable);

	}

	@Test
	void runInstructions_should_throw_InvalidMowInstructionsException_when_wrong_action()
			throws InvalidMowInstructionsException {
		// Given
		String path = classLoader.getResource("instructions_wrong_action.txt").getPath();

		// When
		Executable executable = () -> runner.runInstructions(path);

		// Then
		assertThrows(InvalidMowInstructionsException.class, executable);

	}

	@Test
	void runInstructions_should_throw_InvalidMowInstructionsException_when_wong_mowerlines()
			throws InvalidMowInstructionsException {
		// Given
		String path = classLoader.getResource("instructions_wrong_lines.txt").getPath();

		// When
		Executable executable = () -> runner.runInstructions(path);

		// Then
		assertThrows(InvalidMowInstructionsException.class, executable);

	}

	@Test
	void runInstructions_should_throw_InvalidMowInstructionsException_when_wong_cornerline()
			throws InvalidMowInstructionsException {
		// Given
		String path = classLoader.getResource("instructions_wrong_corner_line.txt").getPath();

		// When
		Executable executable = () -> runner.runInstructions(path);

		// Then
		assertThrows(InvalidMowInstructionsException.class, executable);

	}

}