package lx20190831;

class Node {
	public int value;	
	public Node next;	
						
						
	public Node(int value) {
		this.value = value;
		this.next = null;
	}
}

public class LastLink {
	public static void displayLinkedList(Node head) {
		// 遍历链表
		for (Node cur = head; cur != null; cur = cur.next) {
			System.out.printf("(%d) --> ", cur.value);
		}
		
		System.out.println("null");
	}
	
	public static Node createLinkedList() {
		Node n1 = new Node(1);	
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		
		return n1;
	}
	
	public static Node pushFront(Node head, int value) {
		
		Node newNode = new Node(value);
		
		newNode.next = head;
		
		
		return newNode;
	}
	
	public static Node pushBack(Node head, int value) {
		if (head == null) {
			
			return pushFront(head, value);
		} else {
			
			Node newNode = new Node(value);
			
			Node last = getLast(head);
			
			last.next = newNode;
			
			return head;
		}
	}
	
	public static Node getLast(Node head) {
		Node cur = head;
		while (cur.next != null) {
			cur = cur.next;
		}
		return cur;
	}
	
	public static Node popFront(Node head) {
		if (head == null) {
			System.out.println("参数不合法，无法删除空链表的结点");
			return null;
		}
		
		return head.next;
	}
	
	public static Node popBack(Node head) {
		if (head == null) {
			System.out.println("参数不合法，无法删除空链表的结点");
			return null;
		}
		
		if (head.next == null) {
			
			return null;
		} else {
			
			Node lastLast = getLastLast(head);
			lastLast.next = null;
			return head;
		}
	}
	
	private static Node getLastLast(Node head) {
		Node node = head;
		while (node.next.next != null) {
			node = node.next;
		}
		
		return node;
	}
	
	public static void main(String[] args) {
		Node head = createLinkedList();
		displayLinkedList(head);
		head = pushFront(head, 0);
		displayLinkedList(head);
		pushBack(head, 9);
		displayLinkedList(head);
		
		
		
		head = null;
		displayLinkedList(head);
		head = pushBack(head, 1);
		head = pushBack(head, 2);
		head = pushBack(head, 3);
		head = pushBack(head, 4);
		head = pushBack(head, 5);
		displayLinkedList(head);
		
		head = popFront(head);
		head = popFront(head);
		head = popFront(head);
		displayLinkedList(head);	
		head = popBack(head);
		displayLinkedList(head);	
		head = popBack(head);
		displayLinkedList(head);	
	}
}