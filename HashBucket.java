import java.util.Random;

public class HashBucket {
    private static class Node {
        private int key;
        private int value;
        private Node next;
    }

    private Node[] array;
    private int size;

    public HashBucket() {
        array = new Node[8];
        size = 0;
    }

    public int get(int key) {
        int index = hashFunction(key, array.length);
        // 在该链表中查找指定的 key
        Node head = array[index];
        Node cur = head;
        while (cur != null) {
            if (key == cur.key) {
                return cur.value;
            }

            cur = cur.next;
        }

        return -1;
    }

    // 作业
    // keySet
    // values
    // entrySet
    // containsKey
    // containsValue
    // getOrDefault

    public int put(int key, int value) {
        int index = hashFunction(key, array.length);
        // 在该链表中查找指定的 key
        Node head = array[index];
        Node cur = head;
        while (cur != null) {
            if (key == cur.key) {
                int oldValue = cur.value;
                cur.value = value;
                return oldValue;
            }

            cur = cur.next;
        }

        Node node = new Node();
        node.key = key;
        node.value = value;

        node.next = head;
        // head = node;
        array[index] = node;
        size++;

        if ((double)size / array.length > 0.75) {
            resize();
        }

        return -1;
    }

    private void resize() {
        Node[] newArray = new Node[array.length * 2];
        /*
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
         */
        // 随着 array.length 变大，index 会变化
        for (int i = 0; i < array.length; i++) {
            Node head = array[i];
            Node cur = head;
            while (cur != null) {
                int index = hashFunction(cur.key, newArray.length);
                Node node = new Node();
                node.key = cur.key;
                node.value = cur.value;
                node.next = newArray[index];
                newArray[index] = node;

                cur = cur.next;
            }
        }

        array = newArray;
    }

    private int hashFunction(int key, int capacity) {
        return key % capacity;
    }

    public int remove(int key) {
        // 1. 根据 key 得到一个下标 index
        int index = hashFunction(key, array.length);
        // 2. 从 数组 array 中取链表的第一个结点
        Node head = array[index];
        // 3. 在链表中删除 key-value
        Node prev = null;
        Node cur = head;
        while (cur != null) {
            if (cur.key == key) {
                int oldValue = cur.value;
                if (cur == head) {
                    array[index] = head.next;
                } else {
                    prev.next = cur.next;
                }
                size--;
                return oldValue;
            }

            prev = cur;
            cur = cur.next;
        }

        return -1;
    }

    public static void main(String[] args) {
        HashBucket map = new HashBucket();
        Random random = new Random(20190912);
        for (int i = 0; i < 5; i++) {
            //int r = random.nextInt(100);
            System.out.println(random.nextInt(52));
            //map.put(r, r + 1000);
        }
        return;
        /*
        System.out.println("Success");

        map.remove(42);
        map.remove(45);
        map.remove(0);
        map.remove(1);
        System.out.println("Success");
         */
    }
}
