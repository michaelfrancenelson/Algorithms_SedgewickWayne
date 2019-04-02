package completedAssignments;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

	private final WeightedQuickUnionUF uf;
	private final int n;
	private final int sp;
	private final int topDummy;
	private final int bottomDummy;
	private final int filledDummy;
	private int nOpenCounter;
	
	/** grid of open and closed sites.  false = closed, true = open. */
	private  boolean[][] grid;

	public Percolation(int n) {
		this.n = n;
		sp = n * n;
		topDummy = 2 * sp;
		bottomDummy = topDummy + 1;
		filledDummy = bottomDummy + 1;
		nOpenCounter = 0;
		if (n < 1) throw new IllegalArgumentException();
		
		/* The last1a two elements are the 'dummy' nodes that are conneted to 
		 * all elements in the top and bottom rows, respectively.
		 * They are used as a shortcut to test for  percolation. */
		uf = new WeightedQuickUnionUF(2 * sp + 3);

		/* create n-by-n grid, with all sites blocked */
		grid = new boolean[n][n];
		for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) grid[i][j] = false;
	}

	/** Convert Cartesian 2D coordinates to linear array1a index.
	 * Assumes the 2D coordinate systems starts at (1, 1) */
	private int map2DcoordsTo1D(int row, int col) { return (row - 1) * n + col - 1;	}

//	/** Create 2D Cartesian coordinates given the linear array1a index. 
//	 * Assumes the 2D coordinate system starts at (0, 0). */
//	private int[] map1DcoordsTo2D(int coord) {
//		int col = coord % n;
//		int row = (int) Math.floor(coord / (double) n);
//		return new int[] {row, col};
//	}
	
	/** Open site (row, col) if  it is not open already 
	 * Assumes 2D coordinates start at (1, 1) */
	public void open(int row, int col) {   

		if (row < 1 || col < 1 || row > n || col > n) throw new IllegalArgumentException();

		int index1     = map2DcoordsTo1D(row, col);
		int indexAbove = index1 - n;
		int indexBelow = index1 + n;
		int indexLeft  = index1 - 1;
		int indexRight = index1 + 1;
		
		/* if  the cell is not already open. */
		if (!isOpen(row, col)) {

			/* Open the cell, and count it */
			grid[row - 1][col - 1] = true;
			nOpenCounter++;

			/* Check the von Neumann neighborhood for  other open cells: */
			/* Upper neighbor: */
			if (row > 1) if (isOpen(row - 1, col)) {
				union(index1, indexAbove); }
			/* Lower neighbor: */
			if (row < n) if (isOpen(row + 1, col)) {
				union(index1, indexBelow); }
			/* Left neighbor: */
			if (col > 1) if (isOpen(row, col - 1)) {
				union(index1, indexLeft); }
			/* Right neighbor: */
			if (col < n) if (isOpen(row, col + 1)) {
				union(index1, indexRight); }
			
			/* Top row cells should union with the top dummy cell. */
			 if (row == 1) { 
				 uf.union(index1, topDummy);
				 uf.union(index1 + sp, filledDummy);
			 }
			 
			 /* Bottom row cells should union with the bottom dummy cell. */
			 if (row == n)
				 uf.union(index1,  bottomDummy);
		}
	}
	
	private void union(int index1, int index2) {
		uf.union(index1, index2);
		uf.union(index1 + sp, index2 + sp);
	}

	/** is site (row, col) open? */
	public boolean isOpen(int row, int col) {
		if (row < 1 || col < 1 || row > n || col > n) throw new IllegalArgumentException();
		return grid[row - 1][col - 1];
	}  

	/** is site (row, col) full? */
	public boolean isFull(int row, int col) {
		if (row < 1 || col < 1 || row > n || col > n) throw new IllegalArgumentException();
		int coord = map2DcoordsTo1D(row, col);
		return uf.connected(coord + sp, filledDummy);
	}

	/**  number of open sites */
	public int numberOfOpenSites() {
		return nOpenCounter;
	}      

	/** Does the system percolate? 
	 * System will percolate if any cells in the bottom row are filled.*/
	public boolean percolates() {      
		return uf.connected(topDummy, bottomDummy);
	}


	public static void main(String[] args) {
//				int n = 10;
//				Percolation perc = new Percolation(n);
//				int count = perc.simulate();
//				StdOut.print("/nSystem percolated after " + count + " cells were opened.");
	}

}