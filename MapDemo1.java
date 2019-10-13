package com.lx20191013;

import java.util.*;
public class MapDemo1 {
    public static void main(String[] args) {
        Map();
    }

    public static void Map() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Sikadi", 18);
        map.put("nami", 20);
        map.put("gumi", 16);
        map.put("yeying", 22);
        map.put("shanling", 25);
        System.out.println(map);

        Map<String, Integer> map2 = new LinkedHashMap<>();
        map2.put("lafei", 18);
        map2.put("biaoqiang", 20);
        map2.put("gumi", 16);
        map2.put("miaomiao", 22);
        map2.put("shanling", 25);
        System.out.println(map2);

        Map<String, Integer> map3 = new TreeMap<>(new MyTreeComparator(map));
        map3.putAll(map);
//        map3.put("Sikadi", 18);
//        map3.put("nami", 20);
//        map3.put("gumi",16);
//        map3.put("yeying",22);
//        map3.put("shanling",25);
        System.out.println(map3);

        System.out.println("第一种遍历方式,通过Map.keySet 遍历");
        for (String key : map3.keySet()) {
            System.out.println(key + "---" + map3.get(key));
        }
        System.out.println("=======================");

        System.out.println("第二种遍历方式,通过迭代器");
        Set<Map.Entry<String,Integer>> entrySet = map3.entrySet();
        Iterator<Map.Entry<String,Integer>> entrySetIt = entrySet.iterator();
        while(entrySetIt.hasNext())
        {
            Map.Entry<String,Integer> entry = entrySetIt.next();
            System.out.println(entry.getKey() + " ===="+ entry.getValue());
        }
        System.out.println("第三种方式遍历");
        for(Map.Entry<String,Integer> entry : map3.entrySet())
        {
            System.out.println(entry.getKey() + "----" + entry.getValue());
        }

    }
}


class MyTreeComparator implements Comparator<String> {

    public Map<String, Integer> map;

    public MyTreeComparator(Map<String, Integer> map) {
        this.map = map;
    }

    public int compare(String key1, String key2) {
        //if(key1.compareTo(key2) > 0 ) return -1;
        //if(key1.compareTo(key2) < 0) return 1;
        if (map.get(key1).intValue() > map.get(key2).intValue()) {
            return 1;
        }
        if (map.get(key1).intValue() < map.get(key2).intValue()) {
            return -1;
        }
        return 0;
    }

}




