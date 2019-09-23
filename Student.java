import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Student {
    String major;
    int gender;

    Student(String major, int gender) {
        this.major = major;
        this.gender = gender;
    }

    public static void main(String[] args) {
        String[] majors = {
                "计算机", "数学", "自动化",
                "网络", "物联网"};
        Student[] students = new Student[1000];
        Random majorRandom = new Random(20190921);
        Random genderRandom = new Random(20190921);
        for (int i = 0; i < 1000; i++) {
            int m = majorRandom.nextInt(5);
            int g = genderRandom.nextInt(2);
            students[i] = new Student(majors[m], g);
        }

        Map<String, int[]> counts = new HashMap<>();
        for (String major : majors) {
            counts.put(major, new int[2]);
        }

        for (Student student : students) {
            counts.get(student.major)[student.gender]++;
        }
        for (Map.Entry<String, int[]> e : counts.entrySet()) {
            String major = e.getKey();
            int[] cnt = e.getValue();
            System.out.printf("专业: %s, 男生: %d, 女生: %d%n", major, cnt[0], cnt[1]);
        }
    }
}
