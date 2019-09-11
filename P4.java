import java.util.*;

public class P4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expected = scanner.nextLine();
        String actual = scanner.nextLine();

        // set 是实际打印出的字符，全部大写
        Set<Character> set = new HashSet<>();

        // 不区分大小写，统一把字符串转为大写
        char[] a = actual.toUpperCase().toCharArray();
        for (char c : a) {
            set.add(c);
        }

        char[] b = expected.toUpperCase().toCharArray();
        // 记录已经打印过的键
        Set<Character> brokenKeys = new HashSet<>();
        for (char c : b) {
            if (!set.contains(c)) {
                // c 对应的键是坏的
                if (!brokenKeys.contains(c)) {
                    System.out.print(c);
                    brokenKeys.add(c);
                }
            }
        }
    }
}
