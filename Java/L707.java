class MyLinkedList {
    int val;
    MyLinkedList next;

    public MyLinkedList() {
    }

    public int get(int index) {
        MyLinkedList list = this.next;
        int _index = -1;
        while (list != null) {
            if (++_index == index) return list.val;
            list = list.next;
        }
        if (_index < index) return -1;
        return _index;
    }

    public void addAtHead(int val) {
        MyLinkedList list = this.next;
        MyLinkedList newNode = new MyLinkedList();
        MyLinkedList head = this;
        newNode.val = val;
        newNode.next = list;
        head.next = newNode;
    }

    public void addAtTail(int val) {
        MyLinkedList list = this.next;
        MyLinkedList newNode = new MyLinkedList();
        MyLinkedList preNode = this;
        newNode.val = val;
        newNode.next = null;
        while (list != null) {
            preNode = list;
            list = list.next;
        }
        preNode.next = newNode;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0) {
            addAtHead(val);
            return;
        }
        MyLinkedList list = this.next;
        MyLinkedList preNode = this;
        int _index = -1;
        while (list != null) {
            if (++_index == index) {
                MyLinkedList newNode = new MyLinkedList();
                newNode.val = val;
                newNode.next = list;
                preNode.next = newNode;
                return;
            }
            preNode = list;
            list = list.next;
        }
        if (_index + 1 == index) addAtTail(val);
    }

    public void deleteAtIndex(int index) {
        if (index < 0) return;
        MyLinkedList list = this.next;
        MyLinkedList preNode = this;
        int _index = -1;
        while (list != null) {
            if (++_index == index) {
                list = list.next;
                preNode.next = list;
                return;
            }
            preNode = list;
            list = list.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        MyLinkedList list = this;
        while (list != null) {
            sb.append(list.val).append("->");
            list = list.next;
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }
}

public class L707 {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList(); //带头节点
        linkedList.addAtHead(4);
        System.out.println(linkedList.get(1));
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);
        linkedList.get(1);
        linkedList.deleteAtIndex(0);
        linkedList.get(0);
//        System.out.println(linkedList.get(1));
//        linkedList.addAtTail(2);
//        linkedList.addAtTail(3);
//        linkedList.addAtTail(6);
//        linkedList.addAtHead(1);
//        linkedList.addAtTail(5);
//        linkedList.addAtTail(7);
//        linkedList.addAtTail(9);

        //linkedList.addAtIndex(7, 100);   //链表变为1-> 2-> 3
        //System.out.println(linkedList.get(1));//返回2
        //linkedList.deleteAtIndex(0);  //现在链表是1-> 3
        //linkedList.get(0);            //返回3
    }
}
