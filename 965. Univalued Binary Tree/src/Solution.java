import java.util.List;

public class Solution {
    public static void main(String[] args) {

        TreeNode n6 = new TreeNode(1, null, null);
        TreeNode n5 = new TreeNode(1, null, null);
        TreeNode n4 = new TreeNode(1, null, null);
        TreeNode n3 = new TreeNode(1, null, n6);
        TreeNode n2 = new TreeNode(1, n4, n5);
        TreeNode n1 = new TreeNode(1, n2, n3);

        TreeNode t5 = new TreeNode(2, null, null);
        TreeNode t4 = new TreeNode(5, null, null);
        TreeNode t3 = new TreeNode(2, null, null);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t1 = new TreeNode(2, t2, t3);

        final var caseLength = 2;
        final var root = List.of(n1, t1);
        final var output = List.of(true, false);

        for (int i = 0; i < caseLength; i++) {
            final var expected = output.get(i);
            final var myOutput = isUnivalTree(root.get(i));

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

    public static boolean isUnivalTree(TreeNode root) {
        return helper(root, root.val);
    }

    private static boolean helper(TreeNode root, int val) {
        if (root == null) return true;

        if (root.val != val) return false;

        return helper(root.left, val) && helper(root.right, val);
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