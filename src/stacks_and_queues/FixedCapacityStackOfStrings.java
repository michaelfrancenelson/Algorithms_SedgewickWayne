package stacks_and_queues;

public class FixedCapacityStackOfStrings implements StackOfStrings{

	private String[] s;
	private int n = 0;
	
	public FixedCapacityStackOfStrings(int capacity)
	{ 
		s = new String[capacity]; 
	}
	
	public boolean isEmpty(){ return n == 0; }
	
	public void push (String item) { s[n++] = item; }
	public String pop(){
		n--;
		String item = s[n];
		s[n] = null;
		return item;
	}
}
