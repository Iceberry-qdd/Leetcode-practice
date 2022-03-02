public class L24 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6};
        ListNode list=new ListNode(arr);
        System.out.println(swapPairs(list));
    }

    public static ListNode swapPairs(ListNode head) {
//        if (head==null) return null;
//        if (head.next==null) return head;
        ListNode list=new ListNode(0,head);
        ListNode cur=list,con,temp,temp2;
        while (cur.next!=null&& cur.next.next!=null){
            temp=cur.next.next;
            temp2=cur.next;
            con=temp.next;
            cur.next=temp;
            temp2.next=con;
            temp.next=temp2;
            cur=cur.next.next;
        }
        return list.next;
    }
}
