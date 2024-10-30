package RobSim;

public class Robot {
 private int x, y, dx, dy, roboID; // position of current robot, direction of movement, and robot ID moving in x and y direction
 private static int robotCount = 0;
 private Direction d;
 public Robot(int rx, int ry, Direction d) {
	 x = rx;
	 y = ry;
	 roboID = robotCount++;
	 dx = 1;
	 dy = 1;
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
 * trytomove robot in the direction
 * calculate next x,y position depending on its direction
 * if robot can move there, update its x,y postion to this new positon
 * otherwise change its direction to the next one in the NESW sequence
 */
public void tryToMove(RobotArena a) {
	int nextx=x+dx;
	int nexty=y+dy;
	if (a.canMoveHere(nextx, nexty)) {
		//if it can move randomise whether it goes next posttion or changes direction
		x = nextx;
		y = nexty;
		if (Math.random() < 0.4) {
			d = d.next();
		}
	}
	else {
        d = d.next();
        switch (d) {
        case NORTH:
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

public String toString() {
     return "Robot " + roboID + " is at position (" + x + ", " + y + ") moving " + d.toString() + ".";
 } //return string representation of robot (Need this reviewed for direction instructions

public boolean isHere(int x, int y) { // check if robot is at position x, y
	return this.x == x && this.y == y;
} //return true if robot ishere, else false

public static void main(String [] args) {
    Robot r1 = new Robot(0, 0, Direction.NORTH);
    Robot r2 = new Robot(5, 3, Direction.EAST);
    System.out.println(r1.toString());
    System.out.println(r2.toString());
}


}