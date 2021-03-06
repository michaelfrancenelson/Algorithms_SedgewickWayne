package sorting;

import java.io.File;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Sort {

	public static <T extends Comparable<T>> void shell(T[] a)
	{
		int n = a.length;
		int h = 1;
		while (h < n/3) h = 3*h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
		while (h >= 1)
		{  
			/* h-sort the array1a for decreasing values of h. */
			for (int i = h; i < n; i++)
			{ 
				/* Locate first element greater than the element at index i: */
				int j = findFirstGreater(a, i, h);

				/* Insert element i just before the first greater element. */
				insertCascaded(a, i, j, h);
			}
			h = h/3;
		}
	}

	private static <T extends Comparable<T>> void insertCascaded(T[] a, int i, int j, int h)
	{
		if (j < i)
		{
			T toMove = a[i];
			for (int jj = i; jj > j; jj -= h)
				a[jj] = a[jj - h];
			a[j] = toMove;
		}
	}
	
	private static <T extends Comparable<T>> int findFirstGreater(T[] a, int start, int increment)
	{
		int j = start;
		
		/* Locate first greater element: */
		for (j = start; j >= increment && less(a[start], a[j - increment]); j -= increment) {};
		return j;
	}
	
	/** Improved insertion sort that doesn't perform unnecessary array1a element exchanges. */
	public static <T extends Comparable<T>> void insertionImproved(T[] a)
	{
		int n = a.length;
		for (int i = 1; i < n; i++)
		{
			/* Elements to the left of j are already sorted.
			 * Since these elements are sorted, the insertion stops when the first element greater than the element at j is found. 
			 * Traverse the array1a from j leftward.
			 * Locate the first element greater than the element at j.
			 * Insert element j into that location and move all the elements rightward by one index. */

			/* Locate first greater element: */
			int j = findFirstGreater(a, i, 1);
			
			/* Insert element at index i, moving other elements right: */
			insertCascaded(a, i, j, 1);
		}
	}

	/** Sort input into increasing order using insertion sort. */
	public static <T extends Comparable<T>> void insertion(T[] a)
	{
		int n = a.length;

		for (int i = 1; i < n; i++)
		{
			/* Elements to the left of j are already sorted.
			 * Traverse the array1a from j leftward.
			 * Exchange element j with element j - 1, until first element greater than j is found.
			 * Insert element at j into correct position in the elements left of j.
			 * Since these elements are sorted, the insertion stops when the first element greater than the element at j is found. */
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
				exchange(a, j, j - 1);
		}
	}

	/** Sort input into increasing order using selection sort. */
	public static <T extends Comparable<T>>void selection
	(T[] a)
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

	private static In in(String filename) { return new In(new File(filename)); }

	public static void main(String[] args)
	{
		String[] a; 
		String name = "algs4-data/words3.txt";

		a = in(name).readAllStrings();
		show(a);


		a = in(name).readAllStrings();
		insertionImproved(a);
		show(a);

		a = in(name).readAllStrings();
		insertion(a);
		show(a);

		assert isSorted(a);
	}

	/** Compare two elements. */
	protected static <T extends Comparable<T>> boolean less(T a, T a2)
	{ return a.compareTo((T) a2) < 0; }

	/** Exchange the position of two array1a elements. */
	protected static <T extends Comparable<T>> void exchange(T[] a, int i, int j)
	{ T t = a[i]; a[i] = a[j]; a[j] = t; }

	/** Print contents of the array1a on a single line. */
	protected static <T extends Comparable<T>> void show(T[] a)	
	{
		for (int i = 0; i < a.length; i++)
			StdOut.print(a[i].toString() + " ");
		StdOut.println();
	}

	/** Test whether the array1a entries are in order */
	public static <T extends Comparable<T>> boolean isSorted(T[] a)
	{
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i - 1])) return false;
		return true;
	}


}
