package sorting;

import java.io.File;

import edu.princeton.cs.algs4.In;

public class SortTest {

	
	public static void main(String[] args) {
		String[] a;
		In in;
		
		in = new In(new File("algs4-data/words3.txt"));
		a = in.readAllStrings();

		Selection.sort(a);
		Sort.show(a);
		
	}
}
