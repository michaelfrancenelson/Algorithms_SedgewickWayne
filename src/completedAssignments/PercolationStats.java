package completedAssignments;
import edu.princeton.cs.algs4.StdOut; 
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats; 

public class PercolationStats  { 

	private final double m; 
	private final double sd; 
	private final double z; 

	public PercolationStats(int n, int trials) {    // perfor m trials independent experiments on an n-by-n grid

		if (n <= 0 || trials <= 0) { throw new IllegalArgumentException(); }

		Percolation perc; 

		double[] thresholds = new double[trials]; 

		for (int trial = 0; trial < trials; trial++) { 
			perc = new Percolation(n); 

			int i = 0; 
			
			int[] coords; 
			int[] order = StdRandom.permutation(n * n); 
			
			for (i = 0; i < n * n; i++){
				coords = new int[]  { (int) Math.floor(order[i] / (double) n), order[i] % n };
				perc.open(coords[0] + 1, coords[1] + 1); 
				if (perc.percolates()) break;
			}
				
			thresholds[trial] = ((double) perc.numberOfOpenSites()) / ((double) (n * n)); 
		}

		m = StdStats.mean(thresholds); 
		sd = StdStats.stddev(thresholds); 
		z = 1.96 * sd / Math.sqrt(trials); 
	}

	// sample mean of percolation threshold
	public double mean() { return m; }
	// sample standard deviation of percolation threshold
	public double stddev() { return sd; }
	// low  endpoint of 95% confidence interval
	public double confidenceLo() {                  
		return m - z; 
	}
	// high endpoint of 95% confidence interval
	public double confidenceHi() {                  
		return m + z; 
	}

	public static void main(String[] args) { 

		int n = 100; 
		int t = 50; 

		if (args.length == 2) { 
			n = Integer.parseInt(args[0]); 
			t = Integer.parseInt(args[1]); 
		}

		PercolationStats ps = new PercolationStats(n, t); 
		StdOut.print("Mean   = " + ps.mean()); 
		StdOut.print("\nSD     = " + ps.sd); 
		StdOut.print("\n95% CI = [" + ps.confidenceLo() + ", " + ps.confidenceHi() + "]"); 
	}
}