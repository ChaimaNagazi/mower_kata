package com.mower.kata.entities;

import java.util.List;

public class MowInstructions {

	private List<Mower> mowers;
	public static Position topRightCorner;

	public void moveAllMowers() {
		for (Mower mower : mowers) {
			mower.move();
		}
	}

	public List<Mower> getMowers() {
		return mowers;
	}

	public void setMowers(List<Mower> mowers) {
		this.mowers = mowers;
	}

	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		for (Mower mower : mowers) {
			if (strBuilder.length() > 0) {
				strBuilder.append(" ");
			}
			strBuilder.append(mower);
		}
		return strBuilder.toString();
	}

}
