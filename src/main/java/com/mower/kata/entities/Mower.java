package com.mower.kata.entities;

import java.util.List;
import com.mower.kata.enums.Action;
import com.mower.kata.enums.Orientation;

public class Mower {

	private Position mowerPosition;
	private Orientation orientation;
	private List<Action> instructions;

	public Mower(Position mowerPosition, Orientation orientation, List<Action> instructions) {
		this.mowerPosition = mowerPosition;
		this.orientation = orientation;
		this.instructions = instructions;
	}

	public void move() {
		for (Action instruction : instructions) {
			if (Action.A.equals(instruction)) {
				updatePosition();
			} else {
				updateOrientation(instruction);
			}
		}
	}

	public void updatePosition() {
		switch (orientation) {
		case N:
			mowerPosition.incrementY();
			break;
		case S:
			mowerPosition.decrementY();
			break;
		case E:
			mowerPosition.incrementX();
			break;
		case W:
			mowerPosition.decrementX();
			break;
		}
	}

	public void updateOrientation(Action instruction) {
		orientation = orientation.getNewOrientation(instruction);
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public Position getMowerPosition() {
		return mowerPosition;
	}

	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(mowerPosition.getX()).append(" ").append(mowerPosition.getY()).append(" ")
				.append(orientation);
		return strBuilder.toString();
	}
}
