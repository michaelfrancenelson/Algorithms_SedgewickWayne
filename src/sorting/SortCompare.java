package sorting;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {

	public static void main(String[] args) {
		String alg1 = "Selection";
		String alg2 = "Insertion1";
		String alg3 = "Insertion";
				
		int N = 10000;
		int T = 10;
		
		double t1 = timeRandomInput(alg1, N, T);
		double t2 = timeRandomInput(alg2, N, T);
		double t3 = timeRandomInput(alg2, N, T);
		
		StdOut.printf("For %d random Doubles\n", N);
		StdOut.printf(" Time for %15s sort is %.1f%s of %s sort\n", alg2, 100 * t2/t1, "%", alg1);
		StdOut.printf(" Time for %15s sort is %.1f%s of %s sort\n", alg3, 100 * t3/t1, "%", alg1);
		
	}
	
	public static double timeRandomInput(String alg, int N, int T)
	{
		double total = 0.0;
		
		Double[] a = new Double[N];
		
		for (int t = 0; t < T; t++)
		{
			/* Build a set of random numbers to sort. */
			for (int i = 0; i < N; i++)
				a[i] = StdRandom.uniform();
			total += time(alg, a);
		}
		return total;
	}
	
	public static <T extends Comparable<T>> double time(String alg, T[] a)
	{
		Stopwatch timer = new Stopwatch();
		
		if (alg.equals("Insertion")) Sort.insertionImproved(a);
		if (alg.equals("Insertion1")) Sort.insertion(a);
		if (alg.equals("Selection")) Sort.selection(a);

		return timer.elapsedTime();
	}

	
	
	
}
