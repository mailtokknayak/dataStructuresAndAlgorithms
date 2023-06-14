package datastructure.linkedlist;

public class DoublyLinkedList {

    class DNode {
        int data;
        DNode pre = null;
        DNode next = null;

        DNode(int x) {
            this.data = x;
        }
    }

    DNode head = null;

    public void addAtHead(int data) {
        DNode dNode = new DNode(data);
        if (head != null) {
            head.pre = dNode;
        }
        dNode.next = head;
        head = dNode;
        return;
    }

    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);
            return;
        }
        DNode dNode = new DNode(val);

        DNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = dNode;
        dNode.pre = current;

    }

    public void addAtIndex(int index, int val) {

        if (index == 0)
            addAtHead(val);
        DNode dNode = new DNode(val);
        int counter = 0;
        DNode current = head;
        while (current != null) {
            counter++;
            if (counter == index ) {
                dNode.next = current.next;
                dNode.pre = current;
                current.next = dNode;
                current.next.pre = dNode;
                return;
            }
            current = current.next;
        }

    }

    public void deleteAtIndex(int index) {
        DNode current = head;
       if (index == 0)
       {
           head = head.next;
           current.next = null;
           head.pre = null;
           return;
       }
       int counter = 0 ;
       while(current != null){
           counter++;
           if (counter == index){
               if (current.next != null && current.pre != null) {
                   current.pre.next = current.next;
                   current.next.pre = current.pre;
               }
               return;
           }
       }
    }

    public void display() {
        if (head == null)
            System.out.println("Head Is Null.");

        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
}
