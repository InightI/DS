import java.util.List;

public class MyArrayList<E> {
    private E[] array;
    private int size;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        // 了解：1. 泛型无法定义泛型数组
        // 压制警告的注解
        array = (E[])new Object[100];
        size = 0;
    }

    public void add(E element) {
        array[size++] = element;
    }

    public void remove() {
        array[--size] = null;
        // size--;  这种写法会引发内存泄漏
        //          原本语义上应该死去的对象
        //          因为写法问题，导致没有被 GC 判定为 死掉
        //          Java 中出现的内存泄漏
    }

    public static void print(MyArrayList<Object> list) {
    }

    public static void main1(String[] args) {
        MyArrayList<Object> objectList = null;
        MyArrayList<Integer> integerList = null;

        print(objectList);
        //print(integerList);
    }

    public static void printList(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    private static <E> void swap(E[] array, int i, int j) {
        E t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void main(String[] args) {
        String[] strings = new String[10];
        swap(strings, 0, 3);
        MyArrayList.<String>swap(strings, 0, 10);
    }
}
