package lx20190824;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tree 
{
	
	
	

	    public static void preOrderTraversal(Node root) {
	        if (root == null) {
	            return;
	        }
	        // 根 + 左子树 + 右子树
	        System.out.println(root.value);
	        preOrderTraversal(root.left);
	        preOrderTraversal(root.right);
	    }
	    public static void inOrderTraversal(Node root) {
	        if (root == null) {
	            return;
	        }

	        // 左子树 + 根 + 右子树
	        inOrderTraversal(root.left);
	        System.out.println(root.value);
	        inOrderTraversal(root.right);
	    }
	 
	public static Node buildTree1 (List<Character> preorder, List<Character> inorder)
	{
		if(preorder.size() == 0) //如果前序遍历没有值,说明此树为空
		{
			return null;
		}
		
		char rootValue = preorder.get(0);//找到第0 个位置
		int leftCount = inorder.indexOf(rootValue); //找到中序中根的位置
		Node root = new Node(rootValue);
		
		//    0 1 2 3 4 5 6 7
		//前序  A B D E G C F H
		//后序  D B G E A C F H
		
		
		List<Character> leftPreorder = preorder.subList(1, 1 + leftCount);
		//从左边找,找到中序的根A后,算离起点的位置,再把位置(leftCount = 4)传给前序,让前序遍历继续走
		List<Character> leftInorder = inorder.subList(0, leftCount);
		Node left = buildTree1(leftPreorder, leftInorder);
		root.left = left;
		
		List<Character> rightPreorder = preorder.subList(1 + leftCount,preorder.size());
		List<Character> rightInorder = inorder.subList(1 + leftCount, inorder.size());
		Node right = buildTree1(rightPreorder, rightInorder);
		root.right = right;
		
		return root;
	}
	
	
	
	
	public static void main(String[] args)
	{
		List<Character> preorder = Arrays.asList('A', 'B', 'D', 'E', 'G', 'C', 'F', 'H');
		List<Character> inorder = Arrays.asList('D', 'B', 'G', 'E', 'A', 'C', 'F', 'H');
		Node root = buildTree1(preorder, inorder);
		System.out.println("如果种树成功,则");
		System.out.println("树的中序为 DBGEACFH");
		System.out.println("======种树后======");
		System.out.println("树的中序为");
        inOrderTraversal(root);
        System.out.println("=======================");
        System.out.println("种树成功!");
		
		
		
	}
	


}



