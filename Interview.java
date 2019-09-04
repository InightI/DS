public class Interview {

	public Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}

		// 1. 复制每个结点，插入到老结点后边
		Node cur = head;
		while (cur != null) {
			// 复制新新结点
			Node node = new Node(cur.val);

			// 把新结点node插入到对应老结点cur的后边
			node.next = cur.next;
			cur.next = node;

			// 让 cur 指向老的下一个结点
			cur = cur.next.next;
			// cur = node.next;		一样
		}

		// 2. 进行 random 的复制
		cur = head;
		while (cur != null) {
			// cur.random 可能是 null
			if (cur.random != null) {
				cur.next.random = cur.random.next;
			} else {
				cur.next.random = null;
			}

			// 让 cur 指向老的下一个结点
			cur = cur.next.next;
		}

		// 3. 把 head 代表的链表拆分新的和老的
		cur = head;
		Node newHead = head.next;
		while (cur != null) {
			// 拆分链表，要改变两个 next 的指向
			Node node = cur.next;
			cur.next = node.next;
			if (node.next != null) {
				node.next = node.next.next;
			}

			// 让 cur 指向老的下一个结点
			cur = cur.next;
		}

		return newHead;
    }
}







