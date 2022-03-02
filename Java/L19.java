public class L19 {
    public static void main(String[] args) {
        int[] arr = {1, 2};
        ListNode list = new ListNode(arr);
        System.out.println(removeNthFromEnd(list, 1));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode list = new ListNode(0, head);
        ListNode del = list, cur = list, pre = null;
        while (cur != null) {
            cur = cur.next;
            if (n == 0) {
                pre = del;
                del = del.next;
            } else n--;
        }
        if (pre != null) pre.next = del.next;
        return list.next;
    }
}
