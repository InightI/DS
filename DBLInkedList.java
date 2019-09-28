package com.lx201928;


public class DBLInkedList {
    static class Node {
        int val;
        Node prev;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }


    Node first = null;
    Node last = null;

    //头插
    //先生成新结点
    //直接进行头插放置
    //假设条件,判断本身链表(头插就是没有头结点)是否为空
    //不为空,直接进行操作,让链表头结点前驱为我们新创的节点
    //为空,直接让链表尾结点等于我们新创的节点
    //最后进行更新,该链表的王座已被我们拿下
    public void addFront(int val) {
        Node newNode = new Node(val);
        newNode.next = first;
        if (first == null) {
            last = newNode;
        } else {
            first.prev = newNode;
        }
        first = newNode;
    }

    void addBack(int val) {
        Node newNode = new Node(val);
        newNode.prev = last;
        if (last == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
    }


    //头删
    //先判断链表如果为空,则抛异常
    //建立一个头结点存放着删除指针指向的值,被选中即被删除,没被选中的就躲进来
    //忽略过程,直接写结果,王位已被篡夺,王冠后移
    //开始判断是否头结点为空,
    //如果为空,则也不存在尾结点,尾结点也为空
    //如果不为空,则就删除该结点,从操作的链表出发,被删除的下一位小弟指向自己(自己指已升天的自己,即为null)
    //最终末世大清洗结束,返回幸存人类

    int pollFront2() throws Exception {
        if (first == null) {
            throw new Exception("这是个空链表,糊弄人呢");
        }

        Node newValue = first;
        first = first.next;
        if (first == null) {
            last = null;
        } else {
            first.prev = null;
        }
        return newValue.val;
    }

    int pollBack() throws Exception {
        if (last == null) {
            throw new Exception("空的");
        }

        Node newValues = last;
        last = last.prev;
        if (last == null) {
            first = null;
        } else {
            last.next = null;
        }
        return newValues.val;
    }


    int pollFront() throws Exception {
        if (first == null) {
            throw new Exception("这是空链表");
        }
        Node oldValues = first;
        first = first.next;
        if (first == null) {
            last = null;
        } else {
            first.prev = null;
        }
        return oldValues.val;
    }


    void print() {
        System.out.println("打印链表");
        for (Node cur = first; cur != null; cur = cur.next) {
            System.out.println(cur.val);
        }
    }


    public static void main(String[] args) throws Exception {
        DBLInkedList list = new DBLInkedList();
        list.print();
        list.addFront(1);   // 空的头插
        list.print();
        list.addFront(2);   // 非空头插
        list.print();
        list.addBack(3);    // 非空尾插
        list.print();
        list.pollFront();        //  5.
        list.print();
        list.pollBack();         // 6
        list.print();
        list.pollFront();       // 7
        list.print();
        list.addBack(4);
        list.print();
        list.pollBack();
        list.print();
    }
}