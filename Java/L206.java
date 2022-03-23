//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}

public class L206 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        ListNode list = new ListNode(arr);
        System.out.println(reverseList(list));
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode pre = null, cur = head, con = cur.next;
        while (con != null) {
            cur.next = pre;
            pre = cur;
            cur = con;
            con = cur.next;
        }
        cur.next = pre;
        return pre;
    }
}
