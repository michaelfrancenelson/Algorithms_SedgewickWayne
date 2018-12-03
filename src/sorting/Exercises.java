package sorting;

import java.awt.Font;

import edu.princeton.cs.algs4.StdDraw;

public class Exercises {

	
	public static void main(String[] args) {
		
		stdDrawExamples();
	}
	
	public static void stdDrawExamples()
	{
		int N = 100;
		StdDraw.setXscale(0, N);
		StdDraw.setYscale(0, N * N);
		StdDraw.setPenRadius(0.01);
		
		for (int i = 1; i <= N; i++)
		{
			StdDraw.point(i,  i);	
			StdDraw.point(i, i * i);
			StdDraw.point(i,  i * Math.log(i));
		}
		
		StdDraw.setXscale(0, 10);
		StdDraw.setYscale(0, 10);
		StdDraw.setPenColor();
		StdDraw.setFont(new Font("serif", 2, 12));
		StdDraw.textLeft(2,  2, "ttext");
		
		
//		StdDraw.clear();
		
		
	}
	
}
