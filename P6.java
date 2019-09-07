import java.util.*;

public class P6 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> count = new HashMap<>();
        for (String cp : cpdomains) {
            String[] t = cp.split(" ");
            int n = Integer.valueOf(t[0]);
            String domain = t[1];

            String[] u = domain.split("\\.");
            for (int i = 0; i < u.length; i++) {
                String[] sub = Arrays.copyOfRange(u, i, u.length);
                String d = String.join(".", sub);

                int oldCount = count.getOrDefault(d, 0);
                count.put(d, oldCount + n);
            }
        }

        System.out.println(count);

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> e : count.entrySet()) {
            String d = e.getKey();
            int n = e.getValue();

            result.add(n + " " + d);
        }

        return result;
    }

    public static void main(String[] args) {
        String[] s = { "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org" };
        List<String> r = new P6().subdomainVisits(s);
        System.out.println(r);
    }
}
