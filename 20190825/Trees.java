import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Trees {
    public static TreeNode buildTree(List<Integer> inorder, List<Integer> postorder) {
        if (inorder.size() == 0) {
            return null;
        }

        int rootValue = postorder.get(postorder.size() - 1);
        int leftCount = inorder.indexOf(rootValue);

        List<Integer> leftInorder = inorder.subList(0, leftCount);
        List<Integer> leftPostorder = postorder.subList(0, leftCount);

        List<Integer> rightInorder = inorder.subList(leftCount + 1, inorder.size());
        List<Integer> rightPostorder = postorder.subList(leftCount, postorder.size() - 1);

        TreeNode root = new TreeNode();
        root.val = rootValue;
        root.left = buildTree(leftInorder, leftPostorder);
        root.right = buildTree(rightInorder, rightPostorder);

        return root;
    }

    public static TreeNode buildTreeArray(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }

        int rootValue = postorder[postorder.length - 1];
        int leftCount = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                leftCount = i;
            }
        }

        int[] leftInorder = Arrays.copyOfRange(inorder, 0, leftCount);
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, leftCount);
        int[] rightInorder = Arrays.copyOfRange(inorder, leftCount + 1, inorder.length);
        int[] rightPostorder = Arrays.copyOfRange(postorder, leftCount, postorder.length - 1);

        TreeNode root = new TreeNode();
        root.val = rootValue;
        root.left = buildTreeArray(leftInorder, leftPostorder);
        root.right = buildTreeArray(rightInorder, rightPostorder);

        return root;
    }

    public static class ReturnValue {
        TreeNode root;
        int used;
    }

    public static ReturnValue buildTreePreorder(List<Integer> preorder) {
        if (preorder.size() == 0) {
            ReturnValue rv = new ReturnValue();
            rv.root = null;
            rv.used = 0;

            return rv;
        }
        int rootValue = preorder.get(0);
        if (rootValue == '#') {
            ReturnValue rv = new ReturnValue();
            rv.root = null;
            rv.used = 1;

            return rv;
        }
        ReturnValue leftRV = buildTreePreorder(
                preorder.subList(1, preorder.size()));
        ReturnValue rightRV = buildTreePreorder(
                preorder.subList(1 + leftRV.used, preorder.size()));

        TreeNode root = new TreeNode();
        root.val = rootValue;
        root.left = leftRV.root;
        root.right = rightRV.root;

        ReturnValue rv = new ReturnValue();
        rv.root = root;
        rv.used = 1 + leftRV.used + rightRV.used;

        return rv;
    }

    public static void main(String[] args) {
        List<Integer> preorder = Arrays.asList(
                1, 2, 3, (int)'#', (int)'#', (int)'#', 4, (int)'#', 5, (int)'#', (int)'#'
        );

        ReturnValue rv = buildTreePreorder(preorder);
        //tree2str(rv.root);
        levelOrderTraversal(rv.root);
    }

    private static void preorder(StringBuilder sb, TreeNode root) {
        if (root == null) {
            return;
        }
        sb.append("(");
        sb.append(root.val);
        if (root.left == null && root.right != null) {
            sb.append("()");
        } else {
            preorder(sb, root.left);
        }
        preorder(sb, root.right);
        sb.append(")");
    }

    public static String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        preorder(sb, t);
        String r = sb.toString();
        return r.substring(1, r.length() - 1);
    }

    public static void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode front = queue.poll();

            System.out.println(front.val);
            if (front.left != null) {
                queue.add(front.left);
            }
            if (front.right != null) {
                queue.add(front.right);
            }
        }
    }
}






