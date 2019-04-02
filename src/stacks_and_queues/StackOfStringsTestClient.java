package stacks_and_queues;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import edu.princeton.cs.algs4.StdOut;

public class StackOfStringsTestClient {

	public static void main(String[] args) throws IOException{

		String filenameIn = "queues/tobe.txt";
		FileReader fr = new FileReader(filenameIn);
		BufferedReader br = new BufferedReader(fr);
		String[] line = br.readLine().split(" ");
		
		StackOfStrings fixedCapArrStackOfStrings = new FixedCapacityStackOfStrings(10);
		StackOfStrings linkedStackOfStrings = new LinkedStackOfStrings();
		StackOfStrings resizingArraStackOfStrings = new ResizingArrayStackOfStrings();
		
		testStack(fixedCapArrStackOfStrings, line);
		testStack(linkedStackOfStrings, line);
		testStack(resizingArraStackOfStrings, line);
		
		br.close();
	}
	
	public static void testStack(StackOfStrings stack, String[] line){
		for(String st : line){
			if(st.equals("-")) StdOut.print(stack.pop() + " ");
			else stack.push(st);
		}
		StdOut.print("\n");
	}
}
