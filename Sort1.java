package lx20190902;

import java.util.Arrays;
import java.util.Random;

public class Sort1 
{
	
	private static void merge(int[] array, int low, int mid, int high )
	{
		int length = high - low;
		int[] newArray = new int[length];
		int ilow = low;
		int imid = mid;
		int inew = 0;
		
		while(ilow < mid && imid < high)
		{
			if(array[ilow] <= array[imid])
			{
				newArray[inew++] = array[ilow++];
			}
			else
			{
				newArray[inew++] = array[imid++];
			}
		}
		
		while(ilow < mid)
		{
			newArray[inew++] = array[ilow++];
		}
		while(imid < high)
		{
			newArray[inew++] = array[imid++];
		}
		for(int i = 0; i < length; i++)
		{
			array[i + low] = newArray[i];
		}
	}
	
	public static void mergeSortInternal(int[] array, int low, int high)
	{
		if(low + 1 >= high)
		{
			return;
		}
		
		int mid = (high + low) / 2;
		
		mergeSortInternal(array, low, mid);
		mergeSortInternal(array,mid, high);
		merge(array, low ,mid ,high);
	}
	
	public static void mergeSort(int[] array)
	{
		mergeSortInternal(array,0,array.length);
		
	}
	
	public static int[] buildRandomArray(int n)
	{
		int [] array = new int[n];
		Random random  = new Random(20190902);
		for(int i = 0; i < n;i++)
		{
			array[i] = random.nextInt(n);
		}
		return array;
	}
	
	
	
	public static void main(String[] args) 
	{
		int[] array;
		array = buildRandomArray(10);
		System.out.println(Arrays.toString(array));
		System.out.println("随机生成10个数");
		long begin  = System.nanoTime();
		mergeSort(array);
		long end = System.nanoTime();
		System.out.println("采用归并排序,用时为" + (end - begin) + "纳秒");
		System.out.println("排序后数组为 ");
		System.out.println(Arrays.toString(array));
		System.out.println("排序成功! -_-");
		
		
		
	}
		
}








