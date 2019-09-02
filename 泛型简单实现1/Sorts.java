import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Sorts {
    public static void mergeSort(Person[] array) {
        mergeSort1(array, 0, array.length);
    }

    // [low, high)
    private static void mergeSort1(Person[] array, int low, int high) {
        int length = high - low;
        if (length <= 1) {
            return;
        }

        int mid = (high + low) / 2;
        // [low, mid)
        mergeSort1(array, low, mid);
        // [mid, high)
        mergeSort1(array, mid, high);

        // 合并两个有序区间
        merge(array, low, mid, high);
    }

    private static void merge(Person[] array, int low, int mid, int high) {
        int length = high - low;
        Person[] extra = new Person[length];

        int iLeft = low;
        int iRight = mid;
        int iExtra = 0;

        while (iLeft < mid && iRight < high) {
            int r = array[iLeft].compareTo(array[iRight]);
            if (r <= 0) {
                extra[iExtra++] = array[iLeft++];
            } else {
                extra[iExtra++] = array[iRight++];
            }
        }

        while (iLeft < mid) {
            extra[iExtra++] = array[iLeft++];
        }

        while (iRight < high) {
            extra[iExtra++] = array[iRight++];
        }

        for (int i = 0; i < length; i++) {
            array[i + low] = extra[i];
        }
    }

    public static void simpleDemo() {
        Person p1 = new Person();
        p1.age = 18;
        Person p2 = new Person();
        p2.age = 28;

        int comparator = p1.compareTo(p2);
        if (comparator < 0) {
            System.out.println("p1 指向的对象比较小");
        } else if (comparator == 0) {
            System.out.println("p1 和 p2 是相等的");
        } else {
            System.out.println("p1 指向的对象比较大");
        }
    }

    public static void mergeSortWithComparator(Person[] array, Comparator<Person> comparator) {
        mergeSort1WithComparator(array, 0, array.length, comparator);
    }

    // [low, high)
    private static void mergeSort1WithComparator(Person[] array, int low, int high, Comparator<Person> comparator) {
        int length = high - low;
        if (length <= 1) {
            return;
        }

        int mid = (high + low) / 2;
        // [low, mid)
        mergeSort1WithComparator(array, low, mid, comparator);
        // [mid, high)
        mergeSort1WithComparator(array, mid, high, comparator);

        // 合并两个有序区间
        mergeWithComparator(array, low, mid, high, comparator);
    }

    private static void mergeWithComparator(Person[] array, int low, int mid, int high, Comparator<Person> comparator) {
        int length = high - low;
        Person[] extra = new Person[length];

        int iLeft = low;
        int iRight = mid;
        int iExtra = 0;

        while (iLeft < mid && iRight < high) {
            int r = comparator.compare(array[iLeft], array[iRight]);
            if (r <= 0) {
                extra[iExtra++] = array[iLeft++];
            } else {
                extra[iExtra++] = array[iRight++];
            }
        }

        while (iLeft < mid) {
            extra[iExtra++] = array[iLeft++];
        }

        while (iRight < high) {
            extra[iExtra++] = array[iRight++];
        }

        for (int i = 0; i < length; i++) {
            array[i + low] = extra[i];
        }
    }

    public static void main(String[] args) {
        Person[] people = new Person[20];
        Random random = new Random(201909020);
        for (int i = 0; i < people.length; i++) {
            people[i] = new Person();
            people[i].age = random.nextInt(100);
            people[i].rank = random.nextInt(50);
        }

        System.out.println(Arrays.toString(people));
        //mergeSort(people);
        //System.out.println(Arrays.toString(people));
        mergeSortWithComparator(people, new PersonRankComparator());
        System.out.println(Arrays.toString(people));
    }

    public static void bubbleSort(Person[] array, Comparator<Person> comparator) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                int r = comparator.compare(array[j], array[j + 1]);
                //int r = array[j].compareTo(array[j + 1]);
                if (r > 0) {
                    swap(array, j , j + 1);
                }
            }
        }
    }

    private static void swap(Person[] array, int i, int j) {
        Person t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void testBubbleSort(Person[] people) {
        bubbleSort(people, new PersonRankComparator());
    }
}
