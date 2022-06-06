package com.mower.kata.entities;

import static com.mower.kata.entities.MowInstructions.topRightCorner;

public class Position {

	private int x;
	private int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void incrementX() {
		if ((x + 1) <= topRightCorner.getX()) {
			x += 1;
		}
	}

	public void decrementX() {
		if ((x - 1) >= 0) {
			x -= 1;
		}
	}

	public void incrementY() {
		if ((y + 1) <= topRightCorner.getY()) {
			y += 1;
		}
	}

	public void decrementY() {
		if ((y - 1) >= 0) {
			y -= 1;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(x).append(" ").append(y);
		return strBuilder.toString();
	}

}
