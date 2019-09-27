package lx201927;

import java.util.*;
public class MyLinkedList
{
    static class Node
    {
        int val;
        Node prev;
        Node next;

        Node(int val)
        {
            this.val = val;
        }
    }


    Node first = null;

    Node last = null;

    void addFirst(int val)
    {
        //先生成新结点
        //直接进行头插放置
        //假设条件,判断本身链表(头插就是没有头结点)是否为空
        //不为空,直接进行操作,让链表头结点前驱为我们新创的节点
        //为空,直接让链表尾结点等于我们新创的节点
        //最后进行更新,该链表的王座已被我们拿下
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

    void insertF(int val)
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

    void insetBack(int val)
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


    int pollFront()  throws Exception
    {
        //先判断链表如果为空,则抛异常
        //建立一个头结点存放着删除指针指向的值,被选中即被删除,没被选中的就躲进来
        //忽略过程,直接写结果,王位已被篡夺,王冠后移
        //开始判断是否头结点为空,
        //如果为空,则也不存在尾结点,尾结点也为空
        //如果不为空,则就删除该结点,从操作的链表出发,被删除的下一位小弟指向自己
        //最终末世大清洗结束,返回幸存人类
        Node oldValues = first;
        first = first.next;
        if(first == null)
        {
            throw new Exception("空的链表");
        }

        if(first != null)
        {
            first.prev = null;
        }
        else
        {
            last = null;
        }
        return oldValues.val;
    }


    void print() {
        System.out.println("打印链表");
        for (Node c = first; c != null; c = c.next) {
            System.out.println(c.val);
        }
        System.out.println("==================");
        for (Node c = last; c != null; c = c.prev) {
            System.out.println(c.val);
        }
    }

    public static void main(String[] args) throws Exception {
        MyLinkedList list = new MyLinkedList();
        list.print();
        list.addFirst(1);   // 空的头插
        list.print();
        list.addFirst(2);   // 非空头插
        list.print();
        list.insetBack(9);
        list.print();
        /**
         * 1. 空的头插
         * 2. 非空的头插
         * 3. 空的尾插
         * 4. 非空的尾插
         * 5. > 1 结点的头删
         * 6. > 1 结点的尾删
         * 7. == 1 结点的头删
         * 8. == 1 结点的尾删
         * 9. 空链表的头删
         * 10. 空链表的尾删
         *
         * 1. 打印
         * 2. 调试
         */
    }
}
