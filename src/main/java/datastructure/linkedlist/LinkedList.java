package datastructure.linkedlist;


public class LinkedList {

    Node head;
    //    Node tail;
    int size = 0;
    public LinkedList() {
    }

    public void insertAtHead(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
        size++;
    }

    public void insertAtTail(int data) {
        Node node = new Node(data);
        if (head == null) {
            insertAtHead(data);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
            size++;
        }
    }

    public void insertAtIndex(int index, int data) {
        if (index > size) return;
        if (index == 0) insertAtHead(data);
        else {
            Node node = new Node(data);
            Node current = head;
            while (index - 1 > 0) {
                current = current.next;
                index--;
            }
            node.next = current.next;
            current.next = node;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < size && index >= 0) {
            size--;
            Node dmy = new Node(0);
            dmy.next = head;
            Node cur = dmy;
            while (index > 0) {
                cur = cur.next;
                index--;
            }
            cur.next = cur.next.next;
            head = dmy.next;
        } else return;
    }

    public int get(int index) {
        if (index > size) return -1;
        Node current = head;
        while (index > 0) {
            current = current.next;
            index--;
        }
        return current.data;
    }

    public boolean isCycle() {

        if (head != null) {
            Node first = head;
            Node second = head;
            do {
                first = first.next;
                second = second.next;
                second = second != null ? second.next : second;
            } while ((second != null && first != null) && first != second);
            return first == second;
        }
        return false;

    }

    public Node cycleBegan() {

        if (head != null && head.next != null) {
            Node first = head;
            Node second = head;
            do {
                first = first.next;
                second = second.next;
                second = second != null ? second.next : second;
            } while ((second != null && first != null) && first != second);

            first = head;
            while (first == second) {
                first = first.next;
                second = second.next;
            }

            return first;
        }
        return null;

    }

    public Node deleteNthNodeFromEnd(int n) {
        Node temp = new Node(-1);
        temp.next = head;
        Node first = temp;
        Node second = temp;

        while (n >= 0) {
            first = first.next;
            n--;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return temp;
    }

    public void display() {
        System.out.println("Size of Linked List " + size);
        System.out.println("Head of Linked List " + head.data);
//        System.out.println("Tail of Linked List " + tail.data);
        while (head != null) {
            System.out.println("Linked List " + head.data);
            head = head.next;
        }
    }

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

}
