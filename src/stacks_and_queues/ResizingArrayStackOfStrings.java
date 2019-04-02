package stacks_and_queues;

public class ResizingArrayStackOfStrings implements StackOfStrings{

	private String[] s;
	private int n = 0;
	
	public ResizingArrayStackOfStrings()
	{ 
		s = new String[1]; 
	}
	
	public boolean isEmpty(){ return n == 0; }
	
	private void resize(int capacity){
		String[] s2 = new String[capacity];
		for(int i = 0; i < n; i++) s2[i] = s[i];
		s = s2;
	}
	
	public void push (String item) { 
		if (n == s.length) resize(2 * s.length);
		s[n++] = item; }
	
	public String pop(){
		n--;
		String item = s[n];
		s[n] = null;
		if(n > 0 && n == s.length / 4){ 
			resize(s.length / 2);
//			StdOut.print(s.length);
		}
			
		return item;
	}
}
