package RobSim;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
/**
* Simple program to show arena with multiple Robots
* @author Ahmed                                                                                                                                                   
*
*/
public class RobotInterface {
private Scanner s; // scanner used for input from user
private RobotArena myArena; // arena in which Robots are shown
/**
* constructor for RobotInterface
* sets up scanner used for input and the arena
* then has main loop allowing user to enter commands
*/
public RobotInterface() {
s = new Scanner(System.in); // set up scanner for user input
myArena = new RobotArena(20, 6);// create arena of size 20*6
char ch = ' ';
do {
System.out.print("Enter (A)dd Robot, get (I)nformation,(M)ove all robots,(S)imulate ,do (D)isplay or e(X)it > ");
ch = s.next().charAt(0);
s.nextLine();
switch (ch) {
case 'A' :
case 'a' :
myArena.addRobot(); // add a new Robot to arena
break;
case 'I' :
case 'i' :
System.out.print(myArena.toString());
break;
case 'S' :
case 's' :
Simulate(100);
break;
case 'D' :
case 'd' :
doDisplay(); // display the arena
break;
case 'M' :
case 'm' :
myArena.moveAllRobots(); // move all the robots
System.out.print(myArena.toString());
doDisplay(); // display the arena


break;
case 'x' : ch = 'X'; // when X detected program ends
break;
}
} while (ch != 'X'); // test if end
s.close(); // close scanner
}
/**
 * display the robot arena on the console
 */
public void doDisplay() {
    int ax = myArena.getXMax();
    int ay = myArena.getYMax();
    ConsoleCanvas c = new ConsoleCanvas(ax, ay, "32013680");
    myArena.showRobots(c);
    System.out.println(c.toString());
}
public void Simulate(int n) {
	for (int i =0; i < n; i++) { 
		myArena.moveAllRobots();
		doDisplay();
		try {
			TimeUnit.MILLISECONDS.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
		}
		
	}
}

public static void main(String[] args) {
RobotInterface r = new RobotInterface();// just call the interface

}
}
