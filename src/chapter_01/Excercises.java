package chapter_01;

import edu.princeton.cs.algs4.StdOut;

public class Excercises {


	public static void main(String[] args)
	{

		int[] a = new int[] {0, 0, 1, 1, 1, 3, 3, 5, 5, 7, 8, 8};
		PrintArrays.print(histogram(a, 3));
		PrintArrays.print(histogram(a, 10));

		StdOut.print(exR1(6));
		StdOut.println();
		StdOut.print(exR2(6));
	
		StdOut.println();
		StdOut.println(mystery(2, 25));
		StdOut.println();
		StdOut.println(mystery(3, 11));
		
	}

	
	
	public static int mystery(int a, int b)
	{
	   if (b == 0) return 0;
	   if (b % 2 == 0) return mystery(a+a, b/2);
	   return mystery(a+a, b/2) + a;
	}

	public static String exR2(int n)
	{
		if (n <= 0) return "";
		String s = exR2(n-3) + n + exR2(n-2) + n;
		return s;
	}

	public static String exR1(int n)
	{
		if (n <= 0) return "";
		return exR1(n-3) + n + exR1(n-2) + n;
	}

	/* Ex 1.1.15 */
	public static int[] histogram(int[] a, int m)
	{
		int[] out = new int[m];

		for (int i = 0; i < a.length; i++)
		{
			if (a[i] < m)
				out[a[i]]++;
		}

		return out;
	}

}
