package lx20190829;

import java.util.Arrays;
import java.util.Random;

public class Sort 
{
	
	
	private static void swap(int[] array, int i, int j) {
	    int t = array[i];
	    array[i] = array[j];
	    array[j] = t;
	}
	
	public static void bubbleSort(int[] array) {
    
		for (int i = 0; i < array.length - 1; i++) {
    	// 无序区间是 [0, arrya.length - i)
		boolean sorted = true;
        
		for (int j = 0; j < array.length - i - 1; j++) {
            if (array[j] > array[j + 1]) {
                swap(array, j, j + 1);
                sorted = false;
			}
		}

        
			if (sorted) {
        	break;
			}
		}

	}
	
	
	
	public static void quickSort(int[] array) {
	    quickSortInternal(array, 0, array.length - 1);
	}
	
	
	private static void quickSortInternal(int[] array, int left, int right) {
	    if (left >= right) {
	        return;
		}

		// 1. 确定基准值：array[right] 作为基准值
		// 2. 遍历，小的左，大的右
		//int pivotIndex = partition3(array, left, right);
		int[] indices = partition4(array, left, right);

		// 分出的两个小区间
		// [left, pivotIndex - 1]
		// [pivotIndex + 1, right]
		// 3. 治
		//quickSortInternal(array, left, pivotIndex - 1);
		//quickSortInternal(array, pivotIndex + 1, right);
		quickSortInternal(array, left, indices[0] - 1);
		quickSortInternal(array, indices[1] + 1, right);
	}
	
	
	private static int[] partition4(int[] array, int left, int right) {
		int pivot = array[right];
	    int less = left;
	    int great = right;
	    int i = left;

	    while (i < great) {
	        if (array[i] == pivot) {
	        	i++;
			} else if (array[i] < pivot) {
	        	swap(array, i, less);
	        	i++;
	        	less++;
			} else {
	            while (i < great && array[great] > pivot) {
	            	great--;
				}

	            swap(array, i, great);
			}
		}
	    return new int[] {less, great - 1};
	
	}
	
	private static int[] buildRandomArray(int n) {
		Random random = new Random(20190828);
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
		    array[i] = random.nextInt(n);
		}

		return array;
	}
	
	public static void main(String[] args) {
		int [] array;
		array = buildRandomArray(10);
		System.out.println("使用快速排序,随机生成数为");
		System.out.println(Arrays.toString(array));
        long begin = System.nanoTime();	// 纳秒
        quickSort(array);
		long end = System.nanoTime();	// 纳秒
		long a = end - begin;
		System.out.println("用时" + a + "纳秒" );
		
		System.out.println(Arrays.toString(array));
		
	}
	
	
	
}