import java.util.Objects;

public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {

        String tree1 = preorder(s,true);
        String tree2 = preorder(t,true);

        return tree1.contains(tree2);
    }

    public static String preorder(TreeNode node, boolean left) {
        if (node == null) {
            if (left)
                return "lnull";
            else
                return "rnull";
        }

        return "#" + node.val + " " + preorder(node.left, true) + " " + preorder(node.right, false);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val &&
                left.equals(treeNode.left) &&
                right.equals(treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }
}