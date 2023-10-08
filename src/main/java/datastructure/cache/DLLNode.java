package datastructure.cache;

public class DLLNode {
    int key;
    int value;
    int frequency;
    DLLNode pre;
    DLLNode next;

    public DLLNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.frequency = 1;
    }
}
