package datastructure.cache;

public class CacheMain {
    public static void main() {
        System.out.println("In CacheMain !!");

//        LRUCache lruCache = new LRUCache(2);
//        System.out.println(lruCache.get(2));
//        lruCache.put(2,6);
//        System.out.println(lruCache.get(1));
//        lruCache.put(1,5);
//        lruCache.put(1,2);
//        System.out.println(lruCache.get(1));
//        System.out.println(lruCache.get(2));
//["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        lfuCache.get(1);
        lfuCache.put(3, 3);
        lfuCache.get(2);
        lfuCache.get(3);
        lfuCache.put(4, 4);
        lfuCache.get(1);
        lfuCache.get(3);
        lfuCache.get(4);

    }
}
