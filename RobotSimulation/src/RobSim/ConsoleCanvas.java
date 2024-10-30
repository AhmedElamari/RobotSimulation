package RobSim;

public class ConsoleCanvas {
    private int xSize, ySize;
    private char[][] canvas;
    

    ConsoleCanvas(int xSize, int ySize, String seed) {
        this.xSize = xSize +2;
        this.ySize = ySize +2;
        canvas = new char[this.xSize][this.ySize];
        borderChar(' ', '#', seed);
    }
    private void borderChar (char schar, char bchar, String seed) {
    int topSeed = Math.max((xSize - 8)/2 , 0); //puts seed in the middle of selected border top to max.
        for (int xct = 0; xct < xSize; xct++) 
            for (int yct = 0; yct < ySize; yct++) 
                if (xct >0 && xct < xSize - 1 && yct > 0 && yct < ySize - 1) 
                    canvas[xct][yct] = schar;
           else if (xct>=topSeed && xct<8+topSeed && yct ==0) canvas[xct][yct] = seed.charAt(xct-topSeed);
           else canvas[xct][yct] =  bchar; 
        }
    
   /**
    * shows exactly what is shwon at postion x,y     
    * @param x
    * @param y
    * @param c
    */    
    public void showIt(int x, int y, char c) {
            canvas[x+1][y+1] = c; //char c into x, y'th element in canvas
        
    }
/**
 * converts row and col of chosen border char like walls and leaves middle in space 
 * outputs canvas array, and followed by the chosen space char
 */
public String toString() {
	String result = "";
	for (int yct = 0; yct < ySize; yct++) {
		for (int xct = 0; xct < xSize; xct++) {
			result += canvas[xct][yct];
		}
		result += "\n";
	}
	return result;
}

public static void main(String[] args) {
	ConsoleCanvas c = new ConsoleCanvas(10, 5, "32013680");
	c.showIt(4,3,'R');
	System.out.println(c.toString());
	}
}


