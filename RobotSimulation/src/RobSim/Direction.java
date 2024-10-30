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
		return "North";
	case EAST:
		return "East";
	case SOUTH:
		return "South";
	case WEST:
		return "West";
	default:
		throw new IllegalArgumentException();
	}
}
}

