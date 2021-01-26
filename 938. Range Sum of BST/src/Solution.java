import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {

        TreeNode n6 = new TreeNode(18, null, null);
        TreeNode n5 = new TreeNode(7, null, null);
        TreeNode n4 = new TreeNode(3, null, null);
        TreeNode n3 = new TreeNode(15, null, n6);
        TreeNode n2 = new TreeNode(5, n4, n5);
        TreeNode n1 = new TreeNode(10, n2, n3);

        TreeNode t9 = new TreeNode(6, null, null);
        TreeNode t8 = new TreeNode(1, null, null);
        TreeNode t7 = new TreeNode(18, null, null);
        TreeNode t6 = new TreeNode(13, null, null);
        TreeNode t5 = new TreeNode(7, t9, null);
        TreeNode t4 = new TreeNode(3, t8, null);
        TreeNode t3 = new TreeNode(15, t6, t7);
        TreeNode t2 = new TreeNode(5, t4, t5);
        TreeNode t1 = new TreeNode(10, t2, t3);

        final var caseLength = 2;
        final var root = List.of(n1, t1);
        final var low = List.of(7,6);
        final var high = List.of(15,10);
        final var output = List.of(32, 23);

        for (int i = 0; i < caseLength; i++) {
            final var expected = output.get(i);
            final var myOutput = rangeSumBST2(root.get(i),low.get(i),high.get(i));

            if (expected != myOutput) {
                System.out.println("FAIL");
                System.out.println("Case: " + (i + 1));
                System.out.println("Expected: " + expected);
                System.out.println("MyOutput: " + myOutput);
                return;
            }
        }

        System.out.println("SUCCESS");

    }

    public static int rangeSumBST2(TreeNode root, int low, int high) {

        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            var node = stack.pop();

            if (node.val >= low && node.val <= high)
                sum += node.val;

            if (node.right != null)
                stack.push(node.right);

            if (node.left != null)
                stack.push(node.left);

        }

        return sum;
    }

    //recusive
    public static int rangeSumBST(TreeNode root, int low, int high) {
        return helper(root,low,high,0);
    }

    private static int helper(TreeNode root, int low, int high,int sum) {
        if (root == null) return sum;

        if (root.val >= low && root.val <= high) sum += root.val;

        int left = helper(root.left, low,high,sum);
        sum = 0;
        int right = helper(root.right, low,high,sum);

        return left + right;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}