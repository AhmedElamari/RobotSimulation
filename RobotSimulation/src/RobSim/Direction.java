package RobSim;


import java.util.Random;


public enum Direction {
	NORTH, EAST, SOUTH, WEST;

public Direction getRandomDirection() {
		Random random = new Random();
		return values()[random.nextInt(values().length)];
	}

public Direction next() {
	switch (this) {
	case NORTH:
		return EAST;
	case EAST:
		return SOUTH;
	case SOUTH:
		return WEST;
	case WEST:
		return NORTH;
	default:
		throw new IllegalArgumentException();
	}
}

public String toString() {
	switch (this) {
	case NORTH:
		return "NORTH";
	case EAST:
		return "EAST";
	case SOUTH:
		return "SOUTH";
	case WEST:
		return "WEST";
	default:
		throw new IllegalArgumentException();
	}
}
}

