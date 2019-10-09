
import java.util.*;
public class thirdTree
{


    //层序遍历1
    public static void levelOrder1(TreeNode root)
    {
        if(root == null)
        {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty())
        {
            TreeNode front = queue.poll();
            System.out.println(front.val);
            if(front.left != null)
            {
                queue.add(front.left);
            }

            if(front.right != null)
            {
                queue.add(front.right);
            }
        }
    }

    private static class Element
    {
        int level;
        TreeNode node;
    }

    //层序遍历2
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> retList = new ArrayList<>();
        if(root == null)
        {
            return retList;
        }
        Queue<Element> queue = new LinkedList<>();
        Element e = new Element();
        e.node = root;
        e.level = 0;
        queue.add(e);

        while(!queue.isEmpty())
        {
            Element front = queue.poll();
            if(front.level == retList.size())
            {
                retList.add(new ArrayList<>());
            }

            retList.get(front.level).add(front.node.val);

            if(front.node.left != null)
            {
                Element l = new Element();
                l.node = front.node.left;
                l.level = front.level + 1;
                queue.add(l);
            }
            if(front.node.right != null)
            {
                Element r = new Element();
                r.node = front.node.right;
                r.level = front.level + 1;
                queue.add(r);
            }

        }
        return retList;
    }

    //判断完全二叉树
    public static boolean isCompleteTree(TreeNode root)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(true)
        {
            TreeNode front = queue.poll();
            if(front == null)
            {
                break;
            }
            queue.add(front.left);
            queue.add(front.right);
        }

        while(!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            if(node != null)
            {
                return false;
            }
        }
        return true;

    }
    //非递归前序遍历
    public static void preorderNoR(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(!stack.empty() || cur != null)
        {
            while(cur != null)
            {
                System.out.println(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            cur = top.right;
        }
    }

    //非递归后序遍历
    public static void postorderNoR(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;//第一根针,负责向下深入
        TreeNode last = null;//第三根针,负责从右子树返回

        while(!stack.empty() || cur != null)
        {
            while(cur!= null)
            {
                stack.push(cur);//把第一次接触到的值装进栈里
            }

            TreeNode top = stack.peek();
            //top为第二根针,负责返回cur指向的值
            if(top.right == null || top.right == last)
            //指如果从右边返回,要么没有值,要么由第三根针记录top位置,进而返回
            {
                stack.pop();//开始返回
                System.out.println(top.val);
                last = top;//top上移,last跟上
            }
            else
            {
                cur = top.right;
                //否则没有要返回的,cur继续深入向下走
            }
        }
    }

    //非递归中序遍历
    public static void inorderNoR(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(!stack.empty() || cur != null)
        {
            while(cur != null)
            {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode top = stack.pop();
            System.out.println(top.val);
            cur = top.right;
        }
    }

    public static void main(String[] args)
    {
        TreeNode n1 = new TreeNode();
        n1.val = 1;
        n1.left = new TreeNode();
        n1.left.val = 2;
        n1.right = new TreeNode();
        n1.right.val = 3;
        n1.left.left = new TreeNode();
        n1.left.left.val = 4;
        postorderNoR(n1);
        System.out.println("asdsadas");
    }
}
