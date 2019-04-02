package testClients;
import completedAssignments.Percolation;
import completedAssignments.PercolationStats;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class PercolationTestClient {

	public static void main(String[] args){
		//		main2(new String[] {""});
		test4();
		test3();
	}

	public static void test4(){
		Percolation perc = new Percolation(4);
		perc.open(4, 1);
		perc.open(3, 1);
		perc.open(2, 1);
		perc.open(1, 1);
		StdOut.print("\nPercolates? (should be true) ... " + perc.percolates());
	}
	public static void test3() {
		Percolation perc = new Percolation(3);
		perc.open(3,  1);


		for (int row = 1; row < 4; row++) {
			perc.open(row, 1);
			//			perc.open(row, 3);
		}

		perc.open(3,  3);
		StdOut.print("\nIs (3, 3) filled? (should be false) ... " + perc.isFull(3, 3));

		perc.open(2, 3);
		perc.open(1, 3);
		StdOut.print("\nIs (3, 3) filled? (should be true) ... " + perc.isFull(3, 3));


	}

	public static void reportTime(int n, int t, Stopwatch s){
		StdOut.print("\nsize of grid: " + n + ", number of tests: " + t + " elapsed time: " + s.elapsedTime() + "\n");
	}

	public static void main2(String[] args){        // test client (described below)

		int n = 200; int t = 100;

		Stopwatch stopwatch = new Stopwatch();
		PercolationStats.main(new String[]{String.valueOf(n), String.valueOf(t)});
		reportTime(n, t, stopwatch);

		n = 400; t = 100;
		stopwatch = new Stopwatch();
		PercolationStats.main(new String[]{String.valueOf(n), String.valueOf(t)});
		reportTime(n, t, stopwatch);

		n = 800; t = 100;
		stopwatch = new Stopwatch();
		PercolationStats.main(new String[]{String.valueOf(n), String.valueOf(t)});
		reportTime(n, t, stopwatch);
	}

	/** test client (optional) */
	public static void main1(String[] args){

		int n = 10;
		Percolation perc = new Percolation(n);


		//		System.out.println("Dummy node 1 connected to (1, 1)?: " + perc.uf.connected(0, n * n + 0));
		//		System.out.println("Dummy node 1 connected to (1, n)?: " + perc.uf.connected(n - 1, n * n + 0));
		//		System.out.println("Dummy node 2 connected to (n, 1)?: " + perc.uf.connected(n * n - n, n * n + 1));
		//		System.out.println("Dummy node 2 connected to (n, n)?: " + perc.uf.connected(n * n - 1, n * n + 1));

		//		reportConnected(n, n, n - 1, n - 1, perc);
		printGrid(perc, n);

		perc.open(9, 9);
		perc.open(10, 10);
		//		reportConnected(n, n, n - 1, n - 1, perc);

		//		reportVonNeumann(n - 1, n - 1, perc);
		//		reportMoore(n - 1, n - 1, perc);

		printGrid(perc, n);

		perc = new Percolation(n);
		for(int i = 1; i < n; i++) perc.open(i + 1, i + 1);
		printGrid(perc, n);		
		report(perc);

		perc = new Percolation(n);
		for(int i = 0; i < n; i++) perc.open(i + 1, 1);
		printGrid(perc, n);
		report(perc);


	}   


	/** Open blocks until the system percolates */
	public static int simulate(Percolation perc, int n){

		int nOpen = 0;
		int[] coords;
		int[] order = StdRandom.permutation(n * n);

		do{	coords = new int[] {(int) Math.floor(order[nOpen] / (double) n), order[nOpen] % n};
		perc.open(coords[0] + 1, coords[1] + 1);
		nOpen++;
		} while(!perc.percolates());

		return nOpen;
	}


	//	private static void reportVonNeumann(int row, int col, Percolation perc){
	//		System.out.println("horizontal/vertical neighbors: ");
	//		reportConnected(row, col, row - 1, col, perc);
	//		reportConnected(row, col, row + 1, col, perc);
	//		reportConnected(row, col, row, col - 1, perc);
	//		reportConnected(row, col, row, col + 1, perc);
	//	}
	//
	//	private static void reportMoore(int row, int col, Percolation perc){
	//		System.out.println("diagonal neighbors: ");
	//		reportConnected(row, col, row - 1, col - 1, perc);
	//		reportConnected(row, col, row + 1, col - 1, perc);
	//		reportConnected(row, col, row - 1, col + 1, perc);
	//		reportConnected(row, col, row + 1, col + 1, perc);
	//	}

	private static void report(Percolation perc){
		System.out.println("\nNumber of open sites = " + perc.numberOfOpenSites());
		System.out.println("Percolates? " + perc.percolates());
	}

	//	private static void reportConnected(int row1, int col1, int row2, int col2, Percolation perc, int n){
	//
	//		int id1 = map2DcoordsTo1D(row1 - 1, col1 - 1, n);
	//		int id2 = map2DcoordsTo1D(row2 - 1, col2 - 1, n);
	//
	//		System.out.println("(" + row1 + ", " + col1 + ") id = " + id1 + " connected to (" + row2 + ", " + col2 + ") id = " + id2 + ": " + 
	//				perc.uf.connected(id1, id2));
	//	}

	private static void printGrid(Percolation perc, int n){
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(perc.isOpen(i + 1, j + 1))
					System.out.print("0");
				else 
					System.out.print("-");
			}
			System.out.print("\n");
		}
	}
}
