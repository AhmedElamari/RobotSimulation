package RobSim;

import java.util.Arrays;

public class StringSplitter {
	private String [] manyStrings;
	public StringSplitter(String s, String spl) {
		manyStrings= s.split(spl);
	}

	public int NumElement() {
		return manyStrings.length;
	}
	public String getNth(int n, String defStr) {
		if (n<manyStrings.length) return manyStrings[n]; else return defStr;
	}

	public int getNthInt(int n, int defInt) {
		if (n < manyStrings.length)
			return Integer.parseInt(manyStrings[n]);
		else
			return defInt;
	}
	public String[] getStrings() {

	    return Arrays.copyOf(manyStrings, manyStrings.length);
	}
	public int[] getIntegers() {
		int res[] = new int [manyStrings.length];
		for (int i =0; i<manyStrings.length; i++) res[i] = Integer.parseInt(manyStrings[i]);
		return res;
	}
	public String toString() {
		String res = "";
		for (int i =0; i<NumElement(); i++) 
		 res += manyStrings[i] + " ";
		return res;
	}
public static void main(String [] args) {
  StringSplitter ME = new StringSplitter("2 5 6 9", " ");
  System.out.println(ME.toString());
  String[] temp = ME.getStrings();
	for (int i = 0; i < temp.length; i++) 
		System.out.println(temp[i] + "\t");
		System.out.println();
		temp[0] = "fred";
		for (int i = 0; i < temp.length; i++) 
			System.out.println(temp[i] + "\t");
		
		System.out.println();
		System.out.println(ME.toString());
	
}
}


