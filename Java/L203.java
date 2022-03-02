class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int[] arr) {
        ListNode newNode, tail = this;
        for (int i = 0; i < arr.length - 1; i++) {
            tail.val = arr[i];
            newNode = new ListNode(arr[i + 1]);
            tail.next = newNode;
            tail = newNode;
        }
        tail.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode node = this;
        while (node != null) {
            sb.append(node.val).append("->");
            node = node.next;
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }
}

public class L203 {
    public static void main(String[] args) {
        int[] arr = {7, 7, 7, 7};
        ListNode list = new ListNode(arr);
        System.out.println(list);
        System.out.println(removeElements(list, 7));

    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode node = new ListNode();
        node.next = head;
        ListNode prior = node, cur = head;
        while (cur != null) {
            if (cur.val == val) prior.next = cur.next;
            else prior = cur;
            cur = cur.next;
        }
        return node.next;
    }
}
