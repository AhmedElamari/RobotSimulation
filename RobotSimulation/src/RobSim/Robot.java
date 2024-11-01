package RobSim;

public class Robot {
 private int x, y, dx, dy, roboID; // position of current robot, direction of movement, and robot ID moving in x and y direction
 private static int robotCount = 0; // number of robots
 private Direction d; 
 
 /**
  * 
  * @param rx 
  * @param ry
  * @param d
  */
 public Robot(int rx, int ry, Direction d) { 
	 x = rx;
	 y = ry;
	 roboID = robotCount++;
	 dx = 1;
	 dy = 1;
	 this.d = d; 
 }
 
 
 /**
  * constructor robot using string to set its position and direction
  * @param s
  */
 public Robot(String s) {
	 this(0,0,Direction.NORTH);
	StringSplitter ss = new StringSplitter(s, " ");
	System.out.println(ss);
	setRob(ss.getNthInt(0, 0), ss.getNthInt(1, 0), ss.getNthInt(2, 0), Direction.valueOf(ss.getNth(3, "NORTH")));
}

	

 
/**
 * set robot position and direction
 * 
 * @param x
 * @param y
 * @param roboID
 * @param d
 */
 public void setRob(int x, int y, int roboID , Direction d) {
		this.x = x;
		this.y = y;
		this.roboID = roboID;
		this.d = d;
	}
 
/*
 * display the robot in the canvas
 * @param c the canvas used
 */
public void displayRobot(ConsoleCanvas c) {
	c.showIt(x, y, 'R');
}


/**
 * return string representation of robot
 * 
 * @return string representation of robot
 */
public String fileString() {
	
	return x + " " + y + " " + roboID + " " + d.toString();
}


/**
 * trytomove robot in the direction
 * calculate next x,y position depending on its direction
 * @param a the arena used
 * if robot can move there, update its x,y postion to this new positon
 * otherwise change its direction to the next one in the NESW sequence
 */
public void tryToMove(RobotArena a) {
	int nextx=x+dx;
	int nexty=y+dy;
	
	if (a.canMoveHere(nextx, nexty)) {
		//change direction or move
		x = nextx;
		y = nexty;
	}
	else {
        d = d.next(); //if it can not move change direction
        switch (d) { //switch statement to change direction
        case NORTH: //if direction is north
            dx = 0; 
            dy = 1;
            break;
        case EAST:
            dx = 1;
            dy = 0;
            break;
        case SOUTH:
            dx = 0;
            dy = -1;
            break;
        case WEST:
            dx = -1;
            dy = 0;
            break;
        }
        
	}
}

/**
 * return string representation
 * @return string representation of robot
 */
public String toString() {
     return "Robot " + roboID + " is at position (" + x + ", " + y + ") moving " + d.toString() + ".";
 } //return string representation of robot (Need this reviewed for direction instructions


/**
 * check if robot is at position x, y
 * @param x
 * @param y
 * @return
 */
public boolean isHere(int x, int y) { // check if robot is at position x, y
	return this.x == x && this.y == y;
} //return true if robot ishere, else false


public static void main(String [] args) {
    Robot r1 = new Robot(0, 0, Direction.NORTH);
    Robot r2 = new Robot(5, 3, Direction.EAST);
    System.out.println(r1.toString());
    System.out.println(r2.toString());
    System.out.println(r1.fileString());
    System.out.println(r2.fileString());
    
}


}