package sorting;

public class Insertion extends Sort{

	public static <T extends Comparable<T>> void sort(T[] a)
	{
		int n = a.length;
		
		for (int i = 1; i < n; i++)
		{
			/* Traverse the array from j leftward.
			 * Elements to the left of j are already sorted.
			 * Insert element at j into correct position in the elements left of j.
			 * Since these elements are sorted, the insertion stops when the first element less than the element at j is found. */
			for (int j = 1; j > 0 && less(a[j], a[j - 1]); j--)
				exchange(a, j, j - 1);
		}
	}

	 public static void main(String[] args) {
		
	}
	
	
}
