package com.mower.kata.entities;

public class Position {

	private int x;
	private int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void incrementX() {
		if ((x + 1) <= MowInstructions.topRightCorner.getX()) {
			x += 1;
		}
	}

	public void decrementX() {
		if ((x - 1) >= 0) {
			x -= 1;
		}
	}

	public void incrementY() {
		if ((y + 1) <= MowInstructions.topRightCorner.getY()) {
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

}
