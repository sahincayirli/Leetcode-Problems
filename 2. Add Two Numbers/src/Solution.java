public class Solution {

    public static void main(String[] args) {
        ListNode n10 = new ListNode(9, null);
        ListNode n9 = new ListNode(9, n10);
        ListNode n8 = new ListNode(9, n9);
        ListNode n7 = new ListNode(9, n8);
        ListNode n6 = new ListNode(9, n7);
        ListNode n5 = new ListNode(9, n6);
        ListNode n4 = new ListNode(9, n5);
        ListNode n3 = new ListNode(9, n4);
        ListNode n2 = new ListNode(9, n3);
        ListNode n1 = new ListNode(1, n2);

        ListNode l1 = new ListNode(9, null);

        display(addTwoNumbers(l1,n1));

    }

    private static void display(ListNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        display(node.next);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;

    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
