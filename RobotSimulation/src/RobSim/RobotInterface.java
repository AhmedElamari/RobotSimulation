package RobSim;
import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
* Simple program to show arena with multiple Robots
* @author Ahmed                                                                                                                                                   
*
*/
public class RobotInterface {
private Scanner s; // scanner used for input from user
private RobotArena myArena; // arena in which Robots are shown
private TextFile tf = new TextFile("Text Files", "txt"); // text file object file extention and description of files in dialog
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
System.out.print("Enter (N)ew arena, (A)dd Robot, get (I)nformation,(M)ove all robots,(S)imulate ,do (D)isplay or e(X)it > ");
ch = s.next().charAt(0);
s.nextLine();
switch (ch) {
case 'N' :
case 'n' :
newArena(); // create a new arena
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
Simulate(100); // simulate the robotsjh
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
public void newArena() {
	try {
		System.out.print("Enter x and y size of new arena > ");
		myArena = new RobotArena(s.next());
		s.nextLine();
		
	
} catch (Exception e) {
	System.out.println("Invalid input");
}
	
	
}

public void Save() {

	if (tf.createFile()) {
		tf.writeAllFile(myArena.fileString());
	}
	else {
		System.out.println("No write file selected");
	}
	try {
		tf.createFile();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
}

public void Load() {

	if (tf.openFile()) {
	System.out.println("Reading from " + tf.usedFileName());
	String data = tf.readAllFile();
	myArena = new RobotArena(data);
}
	else {
		System.out.println("No read file selected");
	}
				
		
		
}

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
