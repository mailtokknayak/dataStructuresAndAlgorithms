package datastructure.linkedlist;

public class LinkedListMain {

    public static void linkedListMain() {

//["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
//[[],[1],[3],[1,2],[1],[0],[0]]


        LinkedList ls = new LinkedList();
        ls.insertAtHead(1);
        ls.insertAtTail(2);
        ls.insertAtTail(3);
        ls.insertAtTail(4);
        ls.insertAtTail(5);
        ls.deleteNthNodeFromEnd(1);

//[3,2,0,-4]

        ls.insertAtHead(4);
        ls.insertAtIndex(5, 0);
        ls.insertAtHead(6);


        ls.display();

    }
}
