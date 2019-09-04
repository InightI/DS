import java.util.*;

public class Count 
{
	static Map<Integer, Integer> count(int[] numbers)
	{
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int n : numbers)
		{
			int c = map.getOrDefault(n, 0);
			map.put(n,  c + 1);
		}
		
		return map;
	}
	
	public static void main(String[] args)
	{ 
		int[] numbers = { 3, 1, 2, 4, 9, 2, 3, 1, 5, 8, 7, 2, 3 };
		Map<Integer, Integer> map = count(numbers);
		System.out.println(map);
		
		for(Map.Entry<Integer,Integer> entry :map.entrySet())
		{
			int number = entry.getKey();
			int cnt = entry.getValue();
			if(cnt == 2)
			{
				System.out.println(number);
			}
			
		}
	}
	
	

}
