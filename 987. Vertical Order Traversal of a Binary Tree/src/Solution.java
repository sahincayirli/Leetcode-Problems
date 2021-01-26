import java.util.*;

public class Solution {
    static TreeNode n1 = new TreeNode(3);
    static TreeNode n2 = new TreeNode(9);
    static TreeNode n3 = new TreeNode(20);
    static TreeNode n4 = new TreeNode(15);
    static TreeNode n5 = new TreeNode(7);


    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Pair>> map = new HashMap<>(); //x -> list (some nodes might have same y in the list)

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0, 0));
        int min = 0, max = 0;
        while (!q.isEmpty()) {
            Pair p = q.remove();

            min = Math.min(min, p.x);
            max = Math.max(max, p.x);

            if (!map.containsKey(p.x))
                map.put(p.x, new ArrayList<>());
            map.get(p.x).add(p);

            if (p.node.left != null) q.add(new Pair(p.node.left, p.x - 1, p.y + 1));
            if (p.node.right != null) q.add(new Pair(p.node.right, p.x + 1, p.y + 1));
        }

        for(int i=min; i<=max; i++)
        {
            Collections.sort(map.get(i), new Comparator<Pair>(){
                public int compare(Pair a, Pair b)
                {
                    if(a.y==b.y) //when y is equal, sort it by value
                        return a.node.val - b.node.val;
                    return 0; //otherwise don't change the order as BFS ganrantees that top nodes are visited first
                }
            });
            List<Integer> list = new ArrayList<>();
            for(int j=0; j<map.get(i).size(); j++)
            {
                list.add(map.get(i).get(j).node.val);
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;

        var caseLength = 1;
        var root = List.of(n1);
        var result = List.of(List.of(9), List.of(3, 15), List.of(20), List.of(7));

        for (int i = 0; i < caseLength; i++) {
            if (!result.get(i).equals(verticalTraversal(root.get(i)))) {
                System.out.println("FAIL");
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
        left = right = null;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Pair {
    TreeNode node;
    int x;  //horizontal
    int y;  //depth

    Pair(TreeNode n, int x, int y) {
        node = n;
        this.x = x;
        this.y = y;
    }


}