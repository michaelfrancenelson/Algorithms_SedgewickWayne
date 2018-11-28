package sorting;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {

	public static void main(String[] args) {
		String alg1 = "Selection";
		String alg2 = "Insertion_original";
		String alg3 = "Insertion_improved";
		String alg4 = "Shell";

		int N = 30000;
		int T = 1;

		double t1 = timeRandomInput(alg1, N, T);
		double t2 = timeRandomInput(alg2, N, T);
		double t3 = timeRandomInput(alg3, N, T);
		double t4 = timeRandomInput(alg4, N, T);

		StdOut.printf("For %d random Doubles\n", N);
		StdOut.printf(" Time for %25s sort is %.1f%s of %s sort\n", alg2, 100 * t2/t1, "%", alg1);
		StdOut.printf(" Time for %25s sort is %.1f%s of %s sort\n", alg3, 100 * t3/t1, "%", alg1);
		StdOut.printf(" Time for %25s sort is %.1f%s of %s sort\n", alg4, 100 * t4/t1, "%", alg1);
	}

	public static double timeRandomInput(String alg, int N, int T)
	{
		double total = 0.0;

		StdRandom.setSeed(12345l);

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

		switch (alg) 
		{
		case "Selection": Sort.selection(a); break;
		case "Insertion_improved": Sort.insertionImproved(a); break;
		case "Insertion_original": Sort.insertion(a); break;
		case "Shell": Sort.shell(a); break;
		}



		return timer.elapsedTime();
	}




}
