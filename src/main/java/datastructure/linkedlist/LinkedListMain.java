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
//        linkedListLeetCode.addAtIndex(0,4);
//        linkedListLeetCode.addAtIndex(1,1);
//        linkedListLeetCode.addAtIndex(2,8);
//        linkedListLeetCode.addAtIndex(3,4);
//        linkedListLeetCode.addAtIndex(4,5);
//
        LinkedListLeetCode linkedListLeetCode1 = new LinkedListLeetCode();
        linkedListLeetCode1.addAtIndex(0,1);
        linkedListLeetCode1.addAtIndex(1,3);
        linkedListLeetCode1.addAtIndex(2,5);
        linkedListLeetCode1.addAtIndex(3,7);

        LinkedListLeetCode linkedListLeetCode2 = new LinkedListLeetCode();
        linkedListLeetCode2.addAtIndex(0,2);
        linkedListLeetCode2.addAtIndex(1,4);
        linkedListLeetCode2.addAtIndex(2,6);
        linkedListLeetCode2.addAtIndex(3,8);


//
//        LinkedListLeetCode linkedListLeetCode2  = new LinkedListLeetCode();
//
//        linkedListLeetCode2.getIntersectionNode(linkedListLeetCode1, linkedListLeetCode2)

//        linkedListLeetCode1.reverse(linkedListLeetCode1.head, 4);
        linkedListLeetCode1.mergeLists(linkedListLeetCode1.head , linkedListLeetCode2.head);
//        DoublyLinkedList doublyLinkedList  = new DoublyLinkedList();
//        doublyLinkedList.addAtHead(1);
//        doublyLinkedList.addAtHead(2);
//        doublyLinkedList.addAtTail(3);
//        doublyLinkedList.addAtIndex(3,10);
//        doublyLinkedList.deleteAtIndex(2);

//        System.out.println(" " +);
//        doublyLinkedList.display();
//        doublyLinkedList.display();

    }
}
