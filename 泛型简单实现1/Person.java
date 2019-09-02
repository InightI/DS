public class Person implements Comparable<Person> {
    public String name;
    public int age;
    public int sex;
    public int rank;

    /**
     * @param o
     * @return 如果 < 0 表示 this 指向的 Person 小于 o 指向的 Person 对象
     *          如果 == 0 表示两个对象是相等的
     *          如果 > 0 表示 this 指向的 Person 是大的那个
     */
    @Override
    public int compareTo(Person o) {
        if (age < o.age) {
            return -1;
        } else if (age == o.age) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return String.format("Person{age=%d, rank=%d}", age, rank);
    }
}
