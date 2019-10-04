public class StringDemo {
    public static void main(String[] args) {
        String p = "hello";
        String q = "hello";
        String o = new String("hello");
        System.out.println(p.equals(q));
        System.out.println(p == q);

        System.out.println(p.equals(o));
        System.out.println(p == o);

        Integer i = 300;
        Integer j = 300;
        System.out.println(i.equals(j));
        System.out.println(i == j);
    }
}
