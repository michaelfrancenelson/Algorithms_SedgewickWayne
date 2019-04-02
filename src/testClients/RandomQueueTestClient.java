package testClients;
import java.util.Iterator;

import completedAssignments.RandomizedQueue;
import edu.princeton.cs.algs4.StdOut;

public class RandomQueueTestClient {

	
	public static int iteratorCount( RandomizedQueue<Integer> queue) {
		
		Iterator<Integer> it = queue.iterator();
		int count = 0;
		
		while(it.hasNext()){
			count++;
			it.next();
		}
		
		return count;
	}
	
	
	public static void printIterator(RandomizedQueue<Integer> queue) {
		Iterator<Integer> it = queue.iterator();
		
		StdOut.print("\n");
		while(it.hasNext()) {
			StdOut.print(it.next());
			StdOut.print(" ");
		}
		
	}
	
	public static void test7() {
		
		RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
		
		int n = 5;
		
		for(int i = 0; i < n; i++){
			rq.enqueue(i);
		}
		
		StdOut.print("Elements in iterator: " + iteratorCount(rq));
		printIterator(rq);
		
		
	}
	
	public static void main(String[] args){
		
		test7();
		
	}
	
	
}
