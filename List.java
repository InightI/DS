class Node {
    public int val;
    public Node next = null;

    public Node(int val) {
        this.val = val;
    }

    // 方法签名：方法名称 + 形参列表
    // 方法重载：方法名称相同，形参列表不同
    public Node(int val, Node next) {
        this(val);
        this.next = next;
    }

    public String toString() {
        return String.format("Node(%d)", val);
    }
}

public class List {
    public Node reverse(Node head) {
        // 遍历 head 代表的链表
        // 把每个结点头插到一个新链表上

        Node rhead = null;// 新链表的第一个结点，代表新链表
        Node cur = head; // 让 cur 指向 head 当前指向的对象
        // cur == null 停止
        while (cur != null) {
            // 记录 cur 原来的下一个结点，因为马上要更改 cur.next
            Node next = cur.next;
            // 把 cur 头插到 rhead 代表的链表上
            // cur 指向的结点的 next 应该是原来的第一个结点
            cur.next = rhead;
            // cur 指向的结点 成为新的第一个结点
            // rhead 指向新的第一个结点
            rhead = cur;
            // 让 cur 指向 cur 原来的下一个结点
            cur = next;
        }

        return rhead;
    }

    private static Node createList() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.next = n2; n2.next = n3; n3.next = n4;

        return n1;
    }

    public static void main(String[] args) {
        Node n1 = createList(); // 静态方法
        Node rhead = new List().reverse(n1); // 普通方法

        // 打印链表
        for (Node c = rhead; c != null; c = c.next) {
            System.out.println(c);
        }
    }
}
