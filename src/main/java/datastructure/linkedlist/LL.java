package datastructure.linkedlist;

class MyLinkedList {
    class Node{
        int val;
        Node next;
        public Node(int v){
            val = v;
        }
    }
    int length;
    Node head;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        length = 0;
        head = null;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index<length&&index>=0){
            Node cur = head;
            while(index>0){
                cur = cur.next;
                index--;
            }
            return cur.val;
        }
        else return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newnode = new Node(val);
        newnode.next = head;
        head = newnode;
        length++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node newnode = new Node(val);
        length++;
        if(head==null){
            head = newnode;
            /*head.next = null;*/
        }else{
            Node cur = head;
            while(cur.next!=null){
                cur = cur.next;
            }
            cur.next = newnode;
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index>length) return;
        if(index<0) {
            addAtHead(val);
            length++;
        }
        else{
            Node dmy = new Node(-1);
            dmy.next = head;
            Node cur = dmy;
            while(index>0)
            {
                cur = cur.next;
                index--;
            }
            Node newnode = new Node(val);
            Node temp = cur.next;
            cur.next = newnode;
            newnode.next = temp;
            head = dmy.next;
            length++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index<length&&index>=0){
            length--;
            Node dmy = new Node(0);
            dmy.next = head;
            Node cur = dmy;
            while(index>0){
                cur = cur.next;
                index--;
            }
            cur.next = cur.next.next;
            head = dmy.next;
        }
        else return;
    }
}


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 package datastructure.linkedlist;

 public class LinkedList {

 class Node {
 int data;
 Node next;

 public Node(int data) {
 this.data = data;
 this.next = null;
 }
 }

 Node head;
 Node tail;
 int size = 0;

 public LinkedList() { }


 public void insertAtHead(int data) {
 Node node = new Node(data);
 if (head == null) {
 head = node;
 tail = node;
 } else {
 node.next = head;
 head = node;
 }
 size++;
 }

 public void insertAtTail(int data) {
 Node node = new Node(data);
 if (head == null) {
 head = node;
 tail = node;
 } else {

 tail.next = node;
 tail = node;
 }
 size++;
 }

 public void insertAtIndex(int index, int data) {
 if (index > size)
 return;
 Node node = new Node(data);

 if (head == null || index == 0) {
 insertAtHead(data);
 } else {
 Node current = head;
 while (--index > 0 && current != null) {
 current = current.next;
 }
 node.next = current.next;
 current.next = node;
 size++;

 if (node.next == null)
 tail = node;
 }
 }

 public void deleteAtIndex(int index) {
 if (head == null || index >= size)
 return;
 Node current = head;
 Node pre = head;
 int counter = 0;
 if (index == 0) {
 head = current.next;
 size--;
 return;
 }
 while (current != null) {
 if (index  == counter) {
 pre.next = current.next;

 }
 pre = current;
 current = current.next;
 counter++;
 }
 size--;
 }

 public int get(int index) {

 if (index >= size || index < 0) {
 return -1;
 }
 Node current = head;
 int count = 0;
 while (current != null){
 if (index == count)
 return current.data;
 current = current.next;
 count++;
 }
 return -1;

 }

 public void display() {
 System.out.println("Size of Linked List " + size);
 System.out.println("Head of Linked List " + head.data);
 System.out.println("Tail of Linked List " + tail.data);
 while (head != null) {
 System.out.println("Linked List " + head.data);
 head = head.next;
 }
 }

 }
*/

