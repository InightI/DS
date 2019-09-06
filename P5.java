import java.util.*;

public class P5 {
    public static class StringComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }

    Map<String, Integer> count(String[] words) {
        Map<String, Integer> wordToCount = new HashMap<>();
        for (String word : words) {
            int c = wordToCount.getOrDefault(word, 0);
            wordToCount.put(word, c + 1);
        }

        return wordToCount;
    }

    // 每个次数 => 哪些单词
    Map<Integer, List<String>> remap(Map<String, Integer> wordToCount) {
        Map<Integer, List<String>> countToWordList = new HashMap<>();
        for (Map.Entry<String, Integer> e : wordToCount.entrySet()) {
            String word = e.getKey();
            int count = e.getValue();

            List<String> wordList = countToWordList.get(count);
            if (wordList == null) {
                wordList = new ArrayList<>();
                countToWordList.put(count, wordList);
            }

            wordList.add(word);
        }

        return countToWordList;
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordToCount = count(words);
        Map<Integer, List<String>> countToWordList = remap(wordToCount);
        // 目的为了将所有出现次数放到一个 int[] 中
        Set<Integer> keys = countToWordList.keySet();
        int[] counts = new int[keys.size()];
        int i = 0;
        for (int key : keys) {
            counts[i++] = key;
        }
        Arrays.sort(counts);

        List<String> result = new ArrayList<>();
        int j = 0;
        int index = counts.length - 1;
        Comparator<String> comparator = new StringComparator();
        while (j < k) {
            int c = counts[index--];
            List<String> wordList = countToWordList.get(c);
            wordList.sort(comparator);
            if (wordList.size() <= k - j) {
                result.addAll(wordList);
                j += wordList.size();
            } else {
                result.addAll(wordList.subList(0, k - j));
                j = k;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] words = {
                "i", "love", "leetcode",
                "i", "love", "coding"
        };
        List<String> r = new P5().topKFrequent(words, 3);
        System.out.println(r);
    }
}
