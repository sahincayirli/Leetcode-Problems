import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {

    // recursive with helper method
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        helper(root,result);
        return result;
    }
    public static void helper(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        helper(root.left,list);
        helper(root.right,list);
    }

    // iterative with stack

    public static List<Integer> way2(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;

        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);
        while (!nodes.empty()) {
            TreeNode visited = nodes.pop();
            result.add(visited.val);
            if (visited.left != null) nodes.push(visited.left);
            if (visited.right != null) nodes.push(visited.right);
        }

        return result;
    }

    public static void main(String[] args) {

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
