package testClients;

import java.util.Iterator;

import completedAssignments.Deque;
import edu.princeton.cs.algs4.StdOut;
@SuppressWarnings("rawtypes")
public class DequeTestClient {


	public static void printIterator(Deque deque){
		Iterator it = deque.iterator();
		StdOut.print("\n");
		while(it.hasNext()) StdOut.print(it.next() + " ");

	}

	public static void rmLast(Deque deque){
		deque.removeLast();
		printIterator(deque);		
	}
	
	public static void rmFirst(Deque deque){
		deque.removeFirst();
		printIterator(deque);
	}
	
	public static void testIterator1(){
		Deque<Integer> deque = new Deque<Integer>(); 
		deque.addLast(1);
		deque.addFirst(2); 
		deque.addLast(3);
		deque.addLast(4);
		printIterator(deque);
		
		rmLast(deque);
		rmFirst(deque);
		rmLast(deque);
	}
	
	public static void test2(){
		Deque<Integer> deque = new Deque<Integer>(); 
		deque.addFirst(0);
		deque.removeLast();
		deque.addLast(23);
		deque.removeFirst();
	}
	
	public static void test3() {
		 Deque<Integer> deque = new Deque<Integer>();
		 deque.addFirst(0);
		 deque.addFirst(1);
		 deque.size();
		 deque.removeLast();
		 deque.removeLast();
	}
	
	
	public static void test10(){
		 Deque<Integer> deque = new Deque<Integer>();
		 deque.addLast(1);
		 deque.removeLast();
		 printIterator(deque);
	}
	
	public static void main(String[] args){

		test2();
		test3();
		test10();

//		testIterator1();
		
		
//		deque.removeLast();
//		printIterator(deque);
//		
//		deque.removeFirst();
//		printIterator(deque);
		//
		//		Deque<Integer> deq;
		//		deq =  new Deque<Integer>();
		//
		//		int n = 5;
		//
		//		for(int i = 0; i < n; i++){
		//			deq.addFirst(n - i - 1);
		//		}
		//
		//		Iterator<Integer> itr = deq.iterator();
		//
		//		for(int i = 0; i < n; i++){
		//			StdOut.print(" " + itr.next());
		//		}
		//		//		StdOut.print(" " + itr.next());
		//		//		StdOut.print(" " + itr.next());
		//
		//
		//		for(int i = 0; i < n; i++){
		//			deq.addFirst(n - i - 1);
		//			deq.addLast(i);
		//		}
		//		StdOut.print("\n");
		//		for(int i = 0; i < n; i++){
		//			StdOut.print(" " + deq.removeFirst());	
		//		}
		//		StdOut.print("\n");
		//		for(int i = 0; i < n; i++){
		//			StdOut.print(" " + deq.removeLast());
		//		}
		//
		//		deq =  new Deque<Integer>();
		//
		//
		//		for(int i = 0; i < 5; i++){
		//			deq.addFirst(i);
		//		}
		//
		//		StdOut.print("\nSize == 5? " + String.format("%s", deq.size() == 5));
		//
		//		for(int i = 0; i < 5; i++){
		//			deq.addLast(i);
		//		}
		//
		//		StdOut.print("\nSize == 10? " + String.format("%s", deq.size() == 10));
		//
		//
		//		for(int i = 0; i < 8; i++){
		//			deq.removeFirst();
		//		}
		//
		//		StdOut.print("\nSize == 2? " + String.format("%s", deq.size() == 2));
		//
		//
		//		for(int i = 0; i < 2; i++){
		//			deq.removeFirst();
		//		}
		//
		//		StdOut.print("\nSize == 0? " + String.format("%s", deq.size() == 0));
		//		StdOut.print("\nIs empty? " + String.format("%s", deq.isEmpty()));
		//












	}

}
