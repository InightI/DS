package lx20190925;

public class DoubleLinked 
{

	static class Node 
	{
		int val;
		Node prev;
		Node next;
		
		Node (int val)
		{
			this.val = val;
		}
	}
	
	Node first = null;
	Node last = null;
	
	void addFirst(int val)
	{
		Node newNode = new Node(val);
		newNode.next = first;
		if(first != null)
		{
			first.prev = newNode;
		}
		else
		{
			last = newNode;
		}
		first = newNode;	
	}
	
	 void addLast(int val)
	 {
		 Node newNode = new Node(val);
		 newNode.prev = last;
		 if(last != null)
		 {
			 last.next = newNode;
		 }
		 else
		 {
			 first = newNode;
		 }
		 last = newNode;
	 }
	 
	 int pollFirst() throws Exception
	 {
		 if(first == null)
		 {
			 throw new Exception("空的链表");
		 }
		 Node oldFirst = first;
		 first = first.next;
		 if(first == null)
		 {
			 last = null;
		 }
		 else
		 {
			 first.prev = null;
		 }
		 return oldFirst.val ;
	 }
	 
	 int pollLast() throws Exception 
	 {
		 if(last == null)
		 {
			 throw new Exception("空链表");
		 }
		 Node oldLast = last;
		 last = last.prev;
		 if(last == null)
		 {
			 first = null;
		 }
		 else
		 {
			 last.next = null;
		 }
		 return oldLast.val;
	 }
	 
	 void print()
	 {
		 System.out.print("打印链表");
		 for(Node c = first; c != null; c = c.next)
		 {
			 System.out.println(c.val);
		 }
		 System.out.println("=============");
		 for(Node c = last; c != null; c = c.prev)
		 {
			 System.out.println(c.val);
		 }
	 }
	 
	 public static void main(String[] args) throws Exception 
	 {
		 DoubleLinked list = new DoubleLinked();
		 list.print();
		 list.addFirst(1);
		 list.print();
		 list.addFirst(2);
		 list.print();
		 list.addLast(3);
		 list.print();
		 list.pollFirst();
		 list.print();
		 list.pollLast();
		 list.print();
		 list.pollFirst();
		 list.print();
	     list.pollLast();         // 6
	     list.print();
	     list.pollFirst();       // 7
	     list.print();
	     list.addLast(4);
	     list.print();
	     list.pollLast();
	     list.print();
		 
		 
		
	 }
}
