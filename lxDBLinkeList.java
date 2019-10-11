package com.lx20191011;

public class lxDBLinkeList
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

    void addFirst2(int val)
    {
        Node node = new Node(val);
        node.next = first;
        if(first == null)
        {
            last = node;
        }
        else
        {
            first.prev = node;
        }
        first = node;
    }

    void addLast(int val)
    {
        Node node = new Node(val);
        node.prev = last;
        if(last == null)
        {
            first = node;
        }
        else
        {
            last.next = node;
        }
        last = node;
    }

    int  addPoll() throws Exception
    {
        if(first == null)
        {
            throw new Exception("dasdas");
        }
        Node oldValue = first;
        first = first.next;
        if(first == null)
        {
            last = null;
        }
        else
        {
            first.prev = null;
        }
        return oldValue.val;
    }

    int addLast() throws Exception
    {
        if(last == null)
        {
            throw new Exception("dasd");
        }
        Node newValue = last;
        last = last.prev;
        if(last == null)
        {
            first = null;
        }
        else
        {
            last.next = null;
        }
        return newValue.val;
    }

    void print()
    {
        System.out.println("打印链表");
        for(Node cur = first; cur != null; cur = cur.next)
        {
            System.out.println(cur.val);
        }
        System.out.println("=====");
    }

    public static void main(String[] args)
    {
        lxDBLinkeList list = new lxDBLinkeList();
        list.print();
        list.addFirst(1);
        list.print();
        list.addFirst2(2);
        list.print();
    }


}
