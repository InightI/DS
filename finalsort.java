package lx20190830;

import java.util.Arrays;
import java.util.Random;

public class finalsort {
	
	private static int[] buildRandomArray(int n) {
		Random random = new Random(20190828);
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
		    array[i] = random.nextInt(n);
		}

		return array;
	}

	

	public static void mergeSort(int[] array) {
	    mergeSortInternal(array, 0, array.length);
	}

	private static void mergeSortInternal(int[] array, int low, int high) {
	    if (low + 1 >= high) {
	    	return;
		}

		int mid = (low + high) / 2;
		// [low, mid)
		// [mid, high)
		mergeSortInternal(array, low, mid);
		mergeSortInternal(array, mid, high);
		merge(array, low, mid, high);
	}

	private static void merge(int[] array, int low, int mid, int high) {
		int length = high - low;
		int[] extra = new int[length];
		// [low, mid)
		// [mid, high)

		int iLeft = low;
		int iRight = mid;
		int iExtra = 0;

		while (iLeft < mid && iRight < high) {
			if (array[iLeft] <= array[iRight]) {
				extra[iExtra++] = array[iLeft++];
			} else {
				extra[iExtra++] = array[iRight++];
			}
		}

		while (iLeft < mid) {
			extra[iExtra++] = array[iLeft++];
		}

		while (iRight < high) {
			extra[iExtra++] = array[iRight++];
		}

		for (int i = 0; i < length; i++) {
			array[low + i] = extra[i];
		}
	}
	

	
	
	public static void main(String[] args) {
		int[]  array;
		System.out.println("随机生成八个数为");
		array = buildRandomArray(8);
		System.out.println(Arrays.toString(array));
        long begin = System.nanoTime();	// 纳秒
        System.out.println("采用归并排序");
        mergeSort(array);
        long end = System.nanoTime();	// 纳秒
		System.out.println("用时" +(end - begin) +"纳秒" );
		System.out.println(Arrays.toString(array));
		
	}
}
