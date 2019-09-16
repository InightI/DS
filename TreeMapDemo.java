import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

class CardComparator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        return o1.value - o2.value;
    }
}

public class TreeMapDemo {
    public static void main(String[] args) {
        Card p = new Card(1, "黑桃");
        Card q = new Card(1, "黑桃");

        CardComparator cmptor = new CardComparator();
        TreeSet<Card> set = new TreeSet<>(cmptor);
        set.add(p);
        System.out.println(set.contains(q));

        TreeMap<Card, String> map = new TreeMap<>(cmptor);
        map.put(p, "黑桃A");
        System.out.println(map.get(q));

        Majiang m1 = new Majiang("万", "一");
        Majiang m2 = new Majiang("万", "一");
        TreeMap<Majiang, String> map2 = new TreeMap<>();
        map2.put(m1, "胡了");
        System.out.println(map2.get(m2));
    }
}
