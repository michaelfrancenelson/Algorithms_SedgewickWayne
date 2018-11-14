package chapter_01;

import java.util.Arrays;

import cern.jet.random.engine.MersenneTwister;
import cern.jet.random.engine.RandomEngine;
import edu.princeton.cs.algs4.StdDraw;
import sequeuces.Sequences;

public class StdDrawExample {

	static RandomEngine re = new MersenneTwister(12334);

	static int n;
	static double[] a;
	
	public static void main(String[] args)
	{

		n = 50;
		a = Sequences.vectorOfDoubleUnifs(n, 0, 1, re);
		
//		ex1();
//		ex2();
		ex3();	



	}
	
	public static void ex3()
	{
		Arrays.sort(a);
		plotA();
	}
	
	public static void plotA()
	{
		for (int i = 0; i < n; i++)
		{
			double x = 1d * i / n;
			double y = a[i] / 2d;
			double rw = 0.5 / n;
			double rh = a[i] / 2d;
			StdDraw.filledRectangle(x, y, rw, rh);
		}		
	}

	public static void ex2()
	{
		StdDraw.setXscale(0, 1);
		StdDraw.setYscale(0, 1);
		StdDraw.setPenRadius(0.01);

		plotA();
	}

	public static void ex1()
	{
		n = 100;
		StdDraw.setXscale(-1, n + 1);
		StdDraw.setYscale(-5,  n*n + 1);
		StdDraw.setPenRadius(0.01);

		for (int i = 1; i <= n; i++)
		{
			StdDraw.point(i,  i);
			StdDraw.point(i, i * i);
			StdDraw.point(i, i * Math.log(i));
		}
	}

}
