import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class Solution {

    // Best Solution
    public int best(TreeNode root) {
        return sum(root, 0);
    }

    public int sum(TreeNode n, int s){
        if (n == null) return 0;
        if (n.right == null && n.left == null) return s*10 + n.val;
        return sum(n.left, s*10 + n.val) + sum(n.right, s*10 + n.val);
    }

    // my solution
    public static int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        List<Integer> results = new ArrayList<>();
        fillPaths(root, new ArrayList<>(), results);
        return results.stream().reduce(0, Integer::sum);
    }

    private static void fillPaths(TreeNode root, ArrayList<Integer> list, List<Integer> leafSum) {

        list.add(root.val);

        if (root.left == null && root.right == null) {

            int num = 0;
            for (int i = 0; i < list.size(); i++) {
                num += list.get(i) * Math.pow(10, list.size() - i - 1);
            }
            leafSum.add(num);

        } else {
            if (root.left != null) {
                fillPaths(root.left, list, leafSum);
                list.remove(list.size() - 1);
            }

            if (root.right != null) {
                fillPaths(root.right, list, leafSum);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {

        var root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        var root2 = new TreeNode(4);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(0);
        root2.left.left = new TreeNode(5);
        root2.left.right = new TreeNode(1);

        var root = List.of(root1, root2);
        var result = List.of(25, 1026);
        var caseLength = 2;

        for (int i = 0; i < caseLength; i++) {
            if (result.get(i) != sumNumbers(root.get(i))) {
                System.out.println("FAIL");
                System.out.println("CASE : " + (i + 1));
                return;
            }
        }

        System.out.println("SUCCESS");


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
