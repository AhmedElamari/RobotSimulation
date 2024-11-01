package RobSim;

import java.util.Random;
import java.util.ArrayList;


public class RobotArena {
	private int xMax, yMax;
	private ArrayList<Robot> robots;
	Random randomGenerator;
	
	
/** creating a arena and adding robot in random position
@param a //define arena in form of "xs ys: xr yr"
*param ramdomGenerator //random generator
*/
public RobotArena(int xMax, int yMax) {
	this.xMax = xMax; //moves xmax to this.xmax in order to select
	this.yMax = yMax; //moves ymax to this.ymax in order to select
	robots = new ArrayList<Robot>(); //initialize robots array list
	randomGenerator = new Random(); //initialize random generator
}


/**
 * constructor for RobotArena
 * 
 * @param a //define arena in form of "xs ys: xr yr"
 */
public RobotArena(String a) {
	//split the string a in format 20 6; 0 0 NORTH; 1 1 SOUTH; etc
	StringSplitter ss = new StringSplitter(a, ";"); //split the string a using ; as delimiter
	StringSplitter sp = new StringSplitter(ss.getNth(0, ""), " "); //split the first string in ss using space as delimiter
	xMax = sp.getNthInt(0, 20); //set xMax to the first integer in sp
	yMax = sp.getNthInt(1, 6); //set yMax to the second integer in sp
	robots = new ArrayList<Robot>(); //initialize robots array list
	for (int i = 1; i < ss.numElement(); i++) { // for each robot in the string
		robots.add(new Robot(ss.getNth(i, ""))); // add the robot to the arena
	}
	randomGenerator = new Random(); //initialize random generator
	
}


/**
 * add a robot in random position
 */
public void addRobot() {
    int x, y; // x and y position of the robot
    do { // ensure the robot is not placed on top of another robot
        x = randomGenerator.nextInt(xMax); // random x position
        y = randomGenerator.nextInt(yMax);  // random y position
    } while (getRoboAt(x, y) != null); // ensure no other robot is at this position

    Direction d = Direction.values()[randomGenerator.nextInt(Direction.values().length)]; // random direction
    robots.add(new Robot(x, y, d));
}


/**
 * add a robot in specific position
 * 
 * @param x // x position of robot
 * @param y // y position of robot
 * @param d // direction of robot
 */
public void showRobots(ConsoleCanvas c) { //method to show robots on the console canvas
	for (Robot r : robots) { //for each robot in the arena
		r.displayRobot(c);
	}
}


/**
 * method to return the string of the arena
 */
public String toString() { 
	String result = ""; //initialize result to empty string to add robots
	for (Robot r : robots) { //for each robot in the arena
		result += r.toString() + "\n"; //use method toString from robot class to add robot information to result and then separate with new line
	}
	
	return "Arena Size: " + xMax + " " + yMax + "\n" + result; //return the result string after all robots are added and add arena size beforehand
}

/**
 * method to return the string of the file
 */
public String fileString() {
	String result = xMax + " " + yMax + ";"; //moves x and y size to result string
	for (Robot r : robots) { //for each robot in the arena
		result += r.fileString() + ";"; //add the x and y position of robot to string in format x y; etc
	} //repeat for all robots in the arena
	return result; //return the result string after all robots are added
}

/**
 * getter of robot x arena size
 */
public int getXMax() {
	return xMax; 
}

/**
 * getter of robot y arena size
 */
public int getYMax() {
	return yMax;
}


/**
 * determine whether a robot canmovehere and if so then return true otherwise return false, 
 * if robot is outside arenasize 
 * or another robot is present
 * @param x // x position of robot
 * @param y // y position of robot
 */
public boolean canMoveHere(int x, int y) {
	if (x < 0 || x >= xMax || y <0|| y >= yMax) { //if robot is outside the arena
		return false; //then return false as it can not move outside arena
	}
	return getRoboAt(x, y) == null; //robot can move if there is no other robot at that position
}


/**
 * method to moveAllRobots at once using trytomove function
 */
public void moveAllRobots() {
	for (Robot r : robots) { // for each robot in the arena
		r.tryToMove(this); //move that specific robot 
	} //then repeat for all robots till all robots are moved
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
	RobotArena a = new RobotArena(20, 12);
	a.addRobot();
	a.addRobot();
	a.addRobot();
	System.out.println(a.toString());
	//test fileString
	System.out.println(a.fileString());
	
	
}



}