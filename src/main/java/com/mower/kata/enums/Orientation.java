package com.mower.kata.enums;

public enum Orientation {
    N("NORTH") {
        @Override
        public Orientation getNewOrientation(Action instruction) {
            if (Action.G.equals(instruction)) {
                return Orientation.W;
            } else if (Action.D.equals(instruction)) {
                return Orientation.E;
            } else {
                return this;
            }
        }
    },
    E("EAST") {
        @Override
        public Orientation getNewOrientation(Action instruction) {
            if (Action.G.equals(instruction)) {
                return Orientation.N;
            } else if (Action.D.equals(instruction)) {
                return Orientation.S;
            } else {
                return this;
            }
        }
    },
    S("SOUTH") {
        @Override
        public Orientation getNewOrientation(Action instruction) {
            if (Action.G.equals(instruction)) {
                return Orientation.E;
            } else if (Action.D.equals(instruction)) {
                return Orientation.W;
            } else {
                return this;
            }
        }
    },
    W("WEST") {
        @Override
        public Orientation getNewOrientation(Action instruction) {
            if (Action.G.equals(instruction)) {
                return Orientation.S;
            } else if (Action.D.equals(instruction)) {
                return Orientation.N;
            } else {
                return this;
            }
        }
    };

	private final String value;

    private Orientation(String value) {
        this.value = value;
    }

    public abstract Orientation getNewOrientation(Action instruction);
}
