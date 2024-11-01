package RobSim;


import java.util.Random;

/**
 * 	* A class for representing directions in a 2D grid
 */
public enum Direction {
	NORTH, EAST, SOUTH, WEST;

/**
 * @return a random direction
*/
public Direction getRandomDirection() { 
		Random random = new Random(); 
		return values()[random.nextInt(values().length)]; //return random direction from directions represented by values using next.int to randomise
	}

/**
 * @return the direction to the right of the current direction in order to move in order NESW clockwise
 */
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
		throw new IllegalArgumentException(); //if not a valid direction throw exception
	}
}

// @return string representation of the direction
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

