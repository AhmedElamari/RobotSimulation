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
System.out.print("Enter (N)ew arena, (S)ave, (L)oad, (A)dd Robot, get (I)nformation,(M)ove all robots,Sim(U)late ,do (D)isplay or e(X)it > ");
ch = s.next().charAt(0);
s.nextLine();
switch (ch) {
case 'N' :
case 'n' :
newArena(); // create a new arena
break;
case 'S' :
case 's' :
Save(); // save the arena to a file
break;
case 'L' :
case 'l' :
Load(); // load the arena from a file
break;
case 'A' :
case 'a' :
myArena.addRobot(); // add a new Robot to arena
break;
case 'I' :
case 'i' :
System.out.print(myArena.toString()); // get information about the arena
break;
case 'U' :
case 'u' :
Simulate(100); // simulate the robots moving at n steps
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


/**
 * Save the arena to a file through creation of file and writing in format of filestring to selected textfile.
 */
public void Save() {
	try {
		tf.createFile(); //try create file to be written to
	} catch (Exception e) { 
		e.printStackTrace(); //print error if exception caught
	}
	
	if (tf.createFile()) { // create file to be written to
		tf.writeAllFile(myArena.fileString()); // write data to file
	}
	else {
		System.out.println("No write file selected"); //if file not created then print msg
	}
}


/**
 * Load the arena from a file
 * @throws Exception
 */
public void Load() {
try {
	if (tf.openFile()) {
	System.out.println("Reading from " + tf.usedFileName()); //printing file name
	String fs = tf.readAllFile(); //reading from file parsed
	fs = fs.substring(0,fs.length()-1); //getting rid of newline to read
	myArena = new RobotArena(fs);
}
	
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("No read file selected");
	}
}
			


/**
 * Display the arena on the console
 * 
 */
public void doDisplay() {
    int ax = myArena.getXMax(); //
    int ay = myArena.getYMax();
    ConsoleCanvas c = new ConsoleCanvas(ax, ay, "32013680");
    myArena.showRobots(c);
    System.out.println(c.toString());
}

/**
 * Simulate the movement of the robots
 * 
 * @param n : number of steps to simulate
 * 
 */
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
