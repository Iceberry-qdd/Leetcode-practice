public class M0207 {
    public static void main(String[] args) {
        /*
        int[] arrA = {4, 1}, arrB = {5, 0, 1}, arrC = {8, 4, 5};
        ListNode listA = new ListNode(arrA);
        ListNode listB = new ListNode(arrB);
        ListNode headA = listA, headB = listB;

        while (listA.next != null) listA = listA.next;
        while (listB.next != null) listB = listB.next;
        ListNode listC = new ListNode(arrC);

        listA.next = listC;
        listB.next = listC;
        System.out.println(getIntersectionNode(headA, headB));

         */



        /*
        int[] arrA={2},arrB={0,9,1},arrC={4};

        ListNode listB=new ListNode(arrB);
        ListNode listD=new ListNode(2);
        ListNode headB = listB;
        while (listB.next != null) listB = listB.next;

        ListNode listC=new ListNode(4);
        listB.next=listD;
        listB=listB.next;
        listB.next=listC;
        ListNode listA=new ListNode(2);

        System.out.println(getIntersectionNode(listA,headB));

         */


        int[] arrA={0,9,1},arrC={2,4};
        ListNode listA=new ListNode(arrA);
        ListNode listB=new ListNode(3);
        ListNode headA=listA,headB=listB;

        while (listA.next!=null) listA=listA.next;

        ListNode listC=new ListNode(arrC);

        listA.next=listC;
        listB.next=listC;

        System.out.println(getIntersectionNode(headA,headB));

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA, curB = headB;
        int lenA = 0, lenB = 0, i;

        while (curA != null) {
            lenA++;
            curA = curA.next;
        }

        while (curB != null) {
            lenB++;
            curB = curB.next;
        }

        i = lenA - lenB;
        curA = headA;
        curB = headB;

        if (i > 0) while (i-- != 0) curA = curA.next;
        else while (i++ != 0) curB = curB.next;

        while (curA != null && curB != null) {
            if (curA == curB) return curA;
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
