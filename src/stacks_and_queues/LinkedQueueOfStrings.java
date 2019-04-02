package stacks_and_queues;

public class LinkedQueueOfStrings implements QueueOfStrings{

	private Node first, last;

	private class Node{
		String item;
		Node next;
	}

	public boolean isEmpty(){ return first == null; }

	public String dequeue()
	{
		String item = first.item;
		first = first.next;
		if (isEmpty()) last = null;
		return item;
	}

	public void enqueue(String item) 
	{
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty()) first = last;
		else oldLast.next = last;
	}
}
