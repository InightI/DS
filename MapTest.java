package lx20190926;

import java.util.*;
public class MapTest 
{
	public static void main(String[] args) 
	{
		Map<String,String> map = new HashMap<>();
		map.put("1", "瓦喵");
		map.put("2", "兔子");
		map.put("3", "竹鼠栗");
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		System.out.println("Key集合中的元素: ");
		
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		Collection <String> val =  map.values();  
		it = val.iterator();
		System.out.println("values中的元素");
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
		
		
	}

}
