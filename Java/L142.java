public class L142 {
    public static void main(String[] args) {
        /*
        int[] arr = {3, 2, 0, -4};
        ListNode list = new ListNode(arr);
        ListNode head = list;
        while (list.next != null) list = list.next;
        list.next = head.next;
        System.out.println(detectCycle(head));

         */

        int[] arr={};
        ListNode list=new ListNode(arr);
        System.out.println(detectCycle(list));
    }

    public static ListNode detectCycle(ListNode head) {
        //if (head == null) return null;
        ListNode list = new ListNode(0, head);
        ListNode fast = list.next, slow = list.next, first = list.next;
        do {
            if (fast == null) return null;
            fast = fast.next;
            if (fast == null) return null;
            fast= fast.next;
            slow = slow.next;
        } while (fast != slow);

        while (first != slow) {
            first = first.next;
            slow = slow.next;
        }
        return first;
    }
}
