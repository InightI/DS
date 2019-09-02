import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortInJava {
    public static void main(String[] args) {
        Person[] people = new Person[10];
        Arrays.sort(people);
        Arrays.sort(people, new PersonRankComparator());
        List<Person> people1 = new ArrayList<>();
        people1.sort(new PersonRankComparator());
    }
}
