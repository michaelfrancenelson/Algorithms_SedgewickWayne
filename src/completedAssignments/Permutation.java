package completedAssignments;
import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {


	public static void main(String[] args) {

		RandomizedQueue<String> queue;
		
		queue = new RandomizedQueue<String>();

		int n = Integer.parseInt(args[0]);
		
		while(!StdIn.isEmpty())
		{
			queue.enqueue(StdIn.readString());
		}
		
		Iterator<String> it = queue.iterator();
		
		int numToPrint = n;
		
		if (n < queue.size()) numToPrint = n;
		else n = queue.size();
		
		for (int i = 0; i < numToPrint; i++)
		{
			StdOut.print(it.next() + "\n");
		}
	}
}
