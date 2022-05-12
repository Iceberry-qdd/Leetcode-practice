public class L143 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        ListNode list = new ListNode(arr);
        reorderList(list);
        System.out.println(list);
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // 找链表中点
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 反转后半段链表
        ListNode secondList = slow.next;
        secondList = reverseList(secondList);
        slow.next = null;// 注意此处需要清空，使得head只有前半段，second只有后半段，否则后续连接会陷入死循环

        // 依次连接链表(插入节点)
        ListNode cur = head;
        while (secondList != null && cur != null) {
            // 记录分别的next节点防丢失
            ListNode firstListNext = cur.next;
            ListNode secondListNext = secondList.next;

            // 向cur插入secondList
            cur.next = secondList;
            secondList.next = firstListNext;

            // 重置cur和secondList
            cur = firstListNext;
            secondList = secondListNext;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode pre = null, cur = head, con = head.next;
        while (con != null) {
            cur.next = pre;
            pre = cur;
            cur = con;
            con = cur.next;
        }
        cur.next = pre;
        return cur;
    }
}
