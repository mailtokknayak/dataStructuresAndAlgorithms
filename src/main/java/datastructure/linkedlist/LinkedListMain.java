package datastructure.linkedlist;

public class LinkedListMain {

    public static void linkedListMain() {
        System.out.println("Inside LinkedListMain");

//["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
//[[],[1],[3],[1,2],[1],[1],[1]]


//        LinkedList ls = new LinkedList();
//        ls.insertAtHead(1);
//        ls.insertAtTail(2);
//        ls.insertAtTail(3);
//        ls.insertAtTail(4);
//        ls.insertAtTail(5);
//        ls.deleteNthNodeFromEnd(1);
//
////[3,2,0,-4]
//
//        ls.insertAtHead(4);
//        ls.insertAtIndex(5, 0);
//        ls.insertAtHead(6);
//
//
//        ls.display();

//        LinkedListLeetCode linkedListLeetCode = new LinkedListLeetCode();
//        linkedListLeetCode.addAtIndex(0,1);
//        linkedListLeetCode.addAtIndex(1,2);
//        linkedListLeetCode.addAtIndex(2,3);
//        linkedListLeetCode.addAtIndex(3,4);
//        linkedListLeetCode.addAtIndex(4,2);
//        linkedListLeetCode.addAtIndex(5,1);

        DoublyLinkedList doublyLinkedList  = new DoublyLinkedList();
        doublyLinkedList.addAtHead(1);
        doublyLinkedList.addAtHead(2);
        doublyLinkedList.addAtTail(3);
        doublyLinkedList.addAtIndex(3,10);
        doublyLinkedList.deleteAtIndex(2);

//        System.out.println(" " +);
        doublyLinkedList.display();

    }
}
