import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {

        TreeNode t4 = new TreeNode(5,null,null);
        TreeNode t3 = new TreeNode(2,null,null);
        TreeNode t2 = new TreeNode(3,t4,null);
        TreeNode t1 = new TreeNode(1,t2,t3);

        TreeNode n5 = new TreeNode(7,null,null);
        TreeNode n4 = new TreeNode(4,null,null);
        TreeNode n3 = new TreeNode(3,null,n5);
        TreeNode n2 = new TreeNode(1,null,n4);
        TreeNode n1 = new TreeNode(2,n2,n3);

        display(mergeTrees(t1,n1));

    }

    public static void display(TreeNode root) {
        if (root == null) return;

        display(root.left);
        System.out.print(root);
        display(root.right);
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null)
            
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;

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
    public String toString() {
        return val + " ";
    }
}