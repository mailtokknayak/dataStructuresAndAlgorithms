package datastructure.linkedlist;

public class LinkedListLeetCode {

    private Node head = null;
    private int size;

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedListLeetCode() {
    }

    public void addAtHead(int data) {
        Node node = new Node(data);
        if (head != null)
            node.next = head;
        head = node;
    }

    public void addAtTail(int data) {
        Node node = new Node(data);
        if (head == null) {
            addAtHead(data);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    }

    public void addAtIndex(int index, int data) {
        Node node = new Node(data);
        Node current = head;
        int count = 0;
        if (index == 0)
            addAtHead(data);

        while (current != null) {
            count++;
            if (count == index) {
                node.next = current.next;
                current.next = node;
                return;
            } else {
                current = current.next;
            }

        }
    }


    public void deleteAtIndex(int index) {

        Node current = head;
        Node previous = head;
        int count = 0;
        if (index == 0) {
            head = head.next;
            return;
        }


        while (current != null) {

            if (count == index) {
                previous.next = current.next;
                current.next = null;
                return;
            } else {
                previous = current;
                current = current.next;
            }
            count++;
        }
    }

    public int get(int index) {
        Node current = head;
        int count = 0;
        while (current != null) {

            if (count == index) {
                return current.data;
            } else {
                current = current.next;
            }
            count++;
        }
        return -1;
    }

    public void display() {
        Node pointer = head;
        while (pointer != null) {
            System.out.println(pointer.data);
            pointer = pointer.next;
        }
    }


    //tow pointer technique
    public boolean hasCycle(Node headNode) {
        Node slow = head;
        Node fast = head;

        while (fast != null) {
            slow = slow != null ? slow.next : null;
            fast = fast.next != null ? fast.next.next : null;

            if (slow == fast)
                return true;
        }

        return false;
    }

    public Node detectCycle(Node head) {
        if (head == null)
            return null;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                Node temp = head;
                while (temp != null) {
                    if (slow == temp)
                        return slow;

                    temp = temp.next;
                    slow = slow.next;


                }
            }
        }
        return null;
    }

    //method 1
    public Node getIntersectionNode(Node headA, Node headB) {

        if (headA == null || headB == null)
            return null;


        Node first = headA;
        Node second = headB;

        while (first != second) {

            first = first != null ? first.next : headB;
            second = second != null ? second.next : headA;
        }
        return first;

    }

    //method 2(find length and build logic)
    public Node getIntersectionNodeM2(Node headA, Node headB) {

        if (headA == null || headB == null)
            return null;


        Node first = headA;
        Node second = headB;

        while (first != second) {

            first = first != null ? first.next : headB;
            second = second != null ? second.next : headA;
        }
        return first;

    }

    public Node removeNthFromEnd(int n) {

        if (head == null)
            return null;
        Node dummy = new Node(-1);
        dummy.next = head;

        Node fast = dummy;
        Node slow = dummy;
        while (n > 0) {
            fast = fast.next;
            n--;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public Node reverseLinkedList() {
        Node pre = null;
        Node current = null;
        Node next = head;

        while (next != null) {
            pre = current;
            current = next;
            next = next.next;
            current.next = pre;
        }
        head = current;
        return head;
    }

    public Node removeElements(int value) {
        if (head == null)
            return null;
        Node current = head;
        Node pre = null;
        while (current != null) {
            if (current.data == value) {
                if (pre == null) head = current.next;
                else pre.next = current.next;
            } else
                pre = current;
            current = current.next;
        }
        return head;
    }

    public Node oddEvenList() {
        if (head == null) return null;

        int count = 0;
        Node end = head;
        while (end.next != null) {
            end = end.next;
            count += 1;
        }

        //if count is even that means we have odd number of node
        count = count % 2 == 0 ? (count / 2) : count / 2 + 1;
        Node temp = head;

        while (count-- > 0) {
            end.next = temp.next;
            temp.next = temp.next.next;
            end.next.next = null;
            temp = temp.next;
            end = end.next;
        }

        return head;
    }

    public boolean isPalindrome() {

        if (head == null)
            return false;

        if (head.next == null)
            return true;


        Node slow = head;
        Node fast = head;

        while (fast != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        Node pre = null;
        Node current = null;
        Node next = slow;

        while (next != null) {
            pre = current;
            current = next;
            next = next.next;
            current.next = pre;
        }
        slow = current;

        Node temp = head;
        while (temp != null && slow != null) {
            if (temp.data != slow.data)
                return false;
            temp = temp.next;
            slow = slow.next;
        }

        return true;

    }

    public Node oddEvenLinkedList() {
        if (head == null || head.next == null || head.next.next == null) return head;

        Node oddHead = null;
        Node evenHead = null;
        Node oddTail = null;
        Node evenTail = null;
        Node current = head;

        int index = 1;

        while (current != null) {
            if (index % 2 == 0) {
                if (evenHead == null) {
                    evenHead = current;
                    evenTail = current;
                } else {
                    evenTail.next = current;
                    evenTail = evenTail.next;
                }
            } else {
                if (oddHead == null) {
                    oddHead = current;
                    oddTail = current;
                } else {
                    oddTail.next = current;
                    oddTail = oddTail.next;
                }
            }
            current = current.next;
            index++;
        }

        if (evenHead == null)
            return oddHead;
        if (oddHead == null)
            return evenHead;


        evenTail.next = null;
        oddTail.next = evenHead;
        return oddHead;
    }
}
