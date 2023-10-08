package datastructure.cache;

public class DoubleLinkedList {
    int listSize;
    DLLNode head;
    DLLNode tail;

    public DoubleLinkedList() {
        this.listSize = 0;
        this.head = new DLLNode(0, 0);
        this.tail = new DLLNode(0, 0);
        head.next = tail;
        tail.pre = head;
    }

    public void addNode(DLLNode node) {
        DLLNode nextNode = head.next;
        node.next = nextNode;
        node.pre = head;
        head.next = node;
        nextNode.pre = node;
        listSize++;
    }

    public void removeNode(DLLNode node) {
        DLLNode prevNode = node.pre;
        DLLNode nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.pre = prevNode;
        listSize--;
    }
}
