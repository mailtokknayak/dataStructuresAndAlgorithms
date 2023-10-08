package datastructure.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LFUCache {

    int capacity;
    int curSize;
    int minFrequency;
    Map<Integer, DLLNode> cache;
    Map<Integer, DoubleLinkedList> frequencyMap;
    Map<Integer, Integer> map = new TreeMap<>();

    public LFUCache(int cap) {
        this.capacity = cap;
        this.curSize = 0;
        this.minFrequency = 0;
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }

    public int get(int key) {
        DLLNode currNode = cache.get(key);
        if (currNode == null)
            return -1;
        updateNode(currNode);
        return currNode.value;
    }


    public void put(int key, int value) {
        if (capacity == 0)
            return;
        if (cache.containsKey(key)) {
            DLLNode curNode = cache.get(key);
            curNode.value = value;
            updateNode(curNode);
        } else {
            curSize++;
            if (curSize > capacity) {
                DoubleLinkedList minFreqList = frequencyMap.get(minFrequency);
                cache.remove(minFreqList.tail.pre.key);
                minFreqList.removeNode(minFreqList.tail.pre);
                curSize--;
            }
            minFrequency = 1;
            DLLNode newNode = new DLLNode(key, value);
            DoubleLinkedList curList = frequencyMap.getOrDefault(1, new DoubleLinkedList());
            curList.addNode(newNode);
            frequencyMap.put(1, curList);
            cache.put(key, newNode);
        }
    }

    private void updateNode(DLLNode currNode) {
        int curFreq = currNode.frequency;
        DoubleLinkedList currList = frequencyMap.get(curFreq);
        currList.removeNode(currNode);
        if (curFreq == minFrequency && currList.listSize == 0) {
            minFrequency++;
        }
        currNode.frequency++;
        DoubleLinkedList newList = frequencyMap.getOrDefault(currNode.frequency, new DoubleLinkedList());
        newList.addNode(currNode);
        frequencyMap.put(currNode.frequency, newList);
    }
}

