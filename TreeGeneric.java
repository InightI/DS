package com.lx201928;
import java.util.*;

class TreeNode<E> {
    E val;				//定义一个值
    TreeNode<E> left;	//定义左子树
    TreeNode<E> right; //定义右子树

    TreeNode(E e) {
        this.val = e;   //为了让其他方法用到val,定义构造方法
    }
}

class Pair<E> {
    TreeNode<E> node;    //定义一个节点
    int level;           //定义层数

    Pair(TreeNode<E> node, int level) {
        this.node = node;				//定义构造方法
        this.level = level;
    }
}

public class TreeGeneric {
    public static <E> List<List<E>> levelOrder(TreeNode<E> root) {
        //建立一个E类型的List,List里的内容是装E类型元素的List
        Queue<Pair<E>> queue = new LinkedList<>();
        //建立一个队列引用,指向链表,队列引用是装E类型元素的Pair类型(可以说成 (或是以队列的形式开辟一个链表空间) 不?)
        queue.offer(new Pair<>(root, 0));
        //offer是add的安全形式,将root 插入0号位置
        List<List<E>> ret = new ArrayList<>();
        //建立一个List的子类,ArrayList去实现List (可以这样说不?)
        while (!queue.isEmpty()) {
            //以队列不为空的前提下进行循环
            Pair<E> front = queue.poll();
            //把队列的元素取出来给 Pair类的 front, 然后删掉
            if (ret.size() == front.level) {
                //如果顺序表的大小等于队列的层数了
                ret.add(new ArrayList<>());
                //就在顺序表里再建新的顺序表
            }
            ret.get(front.level).add(front.node.val);
            //在顺序表里,获得队列元素层数这么多的位置,往这个位置加值
            if (front.node.left != null) {
                //如果树的左子树不为空
                queue.offer(new Pair<>(front.node.left, front.level + 1));
                //就往队列里面加左子树的元素.顺便层数加一
            }
            if (front.node.right != null) {
                queue.offer(new Pair<>(front.node.right, front.level + 1));
                //与左子树同理
            }
        }

        return ret;
        //最终返回顺序表
    }

    public static void main(String[] args) {
        TreeNode<Integer> n1 = new TreeNode<>(1);
        TreeNode<Integer> n2 = new TreeNode<>(2);
        TreeNode<Integer> n3 = new TreeNode<>(3);
        TreeNode<Integer> n4 = new TreeNode<>(4);
        TreeNode<Integer> n5 = new TreeNode<>(5);

        n1.left = n2; n1.right = n3;
        n2.left = n4; n3.right = n5;

        List<List<Integer>> r = levelOrder(n1);
        System.out.println(r);
    }
}