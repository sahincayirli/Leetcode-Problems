import java.util.List;

public class Solution {

    public static void main(String[] args) {

        TreeNode n6 = new TreeNode(7,null,null);
        TreeNode n5 = new TreeNode(4,null,null);
        TreeNode n4 = new TreeNode(2,null,null);
        TreeNode n3 = new TreeNode(6,null,n6);
        TreeNode n2 = new TreeNode(3,n4,n5);
        TreeNode n1 = new TreeNode(5,n2,n3);

        TreeNode t5 = new TreeNode(7,null,null);
        TreeNode t4 = new TreeNode(4,null,null);
        TreeNode t3 = new TreeNode(6,null,t5);
        TreeNode t2 = new TreeNode(2,null,t4);
        TreeNode t1 = new TreeNode(5,t2,t3);

        final var caseLength = 2;
        final var root = List.of(n1,t1);
        final var key = List.of(3,0);

        for (int i = 0; i < caseLength; i++) {
            System.out.printf("##### CASE %d #####\n",(i + 1));
            display(deleteNode(root.get(i),key.get(i)));
            System.out.println();
        }



    }

    public static void display(TreeNode root) {
        if (root == null) return;
        display(root.left);
        System.out.print(root.val + " ");
        display(root.right);
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private static TreeNode findMin(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
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