package com.lx20191008;

import java.util.*;
public class SetDemo1
{
    public static void main(String[] args)
    {
        TreeSet();
    }

    public static void HashSetDemo()
    {
        Set<String> citySet = new LinkedHashSet<>();
        citySet.add("London");
        citySet.add("Paris");
        citySet.add("New York");
        citySet.add("Bei Jing");
        citySet.add("shang Hai");
        citySet.forEach(str -> System.out.println(str + ","));
    }

    public static void TreeSet()
    {
        Set<String> citySet = new TreeSet<>(new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                if(o1.compareTo(o2) > 0) return -1;
                if(o1.compareTo(o2) < 0) return 1;
                return 0;
            }
        });
        citySet.add("London");
        citySet.add("Paris");
        citySet.add("New York");
        citySet.add("Bei Jing");
        citySet.add("shang Hai");
        citySet.forEach(str -> System.out.println(str + ","));

    }

}
