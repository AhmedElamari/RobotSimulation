package RobSim;

import java.util.Random;
import java.util.ArrayList;


public class RobotArena {
	private int xMax, yMax;
	private ArrayList<Robot> robots;
	Random randomGenerator;
	
	
/** creating a arena and adding robot in random position
@param a //define arena in form of "xs ys: xr yr"
*/
	
	
public RobotArena(int xMax, int yMax) {
	this.xMax = xMax;
	this.yMax = yMax;
	randomGenerator = new Random();
	
	robots = new ArrayList<Robot>();
}


public void addRobot() {
    int x, y;
    do {
        x = randomGenerator.nextInt(xMax); // generates values from 1 to xMax - 2
        y = randomGenerator.nextInt(yMax); // generates values from 1 to yMax - 2
    } while (getRoboAt(x, y) != null); // ensure no other robot is at this position

    Direction d = Direction.values()[randomGenerator.nextInt(Direction.values().length)]; // random direction
    robots.add(new Robot(x, y, d));
}


public void showRobots(ConsoleCanvas c) {
	for (Robot r : robots) {
		r.displayRobot(c);
	}
}

public String toString() {
	String result = "";
	for (Robot r : robots) {
		result += r.toString() + "\n";
	}
	
	return "Arena Size: " + xMax + " " + yMax + "\n" + result;
}

/**
 * getter of robot arena size
 */
public int getXMax() {
	return xMax; 
}

public int getYMax() {
	return yMax;
}

/**
 * determine whether a robot canmovehere and if so then return true otherwise return false, 
 * if robot is outside arenasize 
 * or another robot is present
 */

public boolean canMoveHere(int x, int y) {
	if (x < 0 || x >= xMax || y <0|| y >= yMax) {
		return false;
	}
	return getRoboAt(x, y) == null;
}
/**
 * move all robots in the arena
 */
public void moveAllRobots() {
	for (Robot r : robots) {
		r.tryToMove(this);
	}
}


/***
 * get robot at position x, y
 * @param x
 * @param y
 * @return
 */
public Robot getRoboAt(int x, int y) {
	for(Robot robot: robots) {
		if (robot.isHere(x, y)) {
			return robot;
		}
	}
	return null;
}


public static void main(String[] args) {
	RobotArena a = new RobotArena(20, 10);
	a.addRobot();
	a.addRobot();
	a.addRobot();
	System.out.println(a.toString());
	
}
}