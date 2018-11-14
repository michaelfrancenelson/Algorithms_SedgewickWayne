package sorting;

import java.io.File;

import edu.princeton.cs.algs4.In;

public class Selection extends Sort{

	/** Sort input into increasing order using selection sort. */
	public static <T extends Comparable<T>>void sort(T[] a)
	{
		int n = a.length;
		
		for (int i = 0; i < n; i++)
		{
			
			int min = i;  /* index of (currently) smallest known element. */

			/* Loop through all elements with index greater than i to find the smallest element. */
			for (int j = i + 1; j < n; j++)
				if (less(a[j], a[min])) min = j;
			
			/* Exchange the smallest entry with element at index i. */
			exchange(a, i, min);
		}
	}
	
	public static void main(String[] args)
	{
		String[] a;
		In in;
		
		in = new In(new File("algs4-data/words3.txt"));
		a = in.readAllStrings();
		
		show(a);
		sort(a);
		show(a);
	}
	
}
