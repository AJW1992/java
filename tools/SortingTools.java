package tools;

import java.util.Comparator;

public class SortingTools {
	final static int SENTINEL = -0xFFFF;
	/*
	 * coalesce_r recursively merges 'n' sorted arrays into one array
	 * coalesce iteratively merges 'n' sorted arrays into one array
	 * 
	 * the array(s) passed to coalesce, coalesce_r must be sorted
	 * 
	 */
	public static int[] coalesce_r(int[]...sortedArrays) {
		int arrCount = sortedArrays.length;
		
		if (arrCount < 1) {
			return null;
		}
		if (arrCount < 2) {
			return sortedArrays[0];
		}
		
		return mesh(sortedArrays, sortedArrays[0], 1, arrCount);
	}
	
	public static int[] coalesce(int[]...sortedArrays) {
		int arrCount = sortedArrays.length;
		
		if (arrCount < 1) {
			return null;
		}
		if (arrCount < 2) {
			return sortedArrays[0];
		}
		
		return deal(sortedArrays, arrCount);
	}
	
	private static int[] mesh(int[][] sortedArrays, int[] sorted, int arrNext, int arrCount) {
		int len1 = sorted.length;
		int len2 = sortedArrays[arrNext].length;
		int[] meshed = new int[len1 + len2];

		for (int i = 0, j = 0, k = 0; i < meshed.length; i++) {
			if (j == len1) {
				meshed[i] = sortedArrays[arrNext][k++];
				continue;
			}
			if (k == len2) {
				meshed[i] = sorted[j++];
				continue;
			}
			
			int num1 = sorted[j];
			int num2 = sortedArrays[arrNext][k];
			
			if (num1 <= num2) {
				meshed[i] = num1;
				j++;
			} else {
				meshed[i] = num2;
				k++;
			}
		}
		
		if (--arrCount <= 1) {
			return meshed;
		}

		return mesh(sortedArrays, meshed, arrNext+1, arrCount);
	}
	
	private static int[] deal(int[][] sortedArrays, int arrCount) {
		int size = 0;
		int[] indicesHolder = new int[arrCount];
		int[] lengths = new int[arrCount];
		int[] sortedArray;
		
		for (int i = 0; i < arrCount; i++) {
			int subLen = sortedArrays[i].length;
			size += subLen;
			lengths[i] = subLen;
			indicesHolder[i] = 0;
		}
		
		sortedArray = new int[size];
		
		for (int i = 0; i < size; i++) {
			sortedArray[i] = getLowVal(sortedArrays, arrCount, indicesHolder, lengths);
		}
		
		return sortedArray;
	}
	
	private static int getLowVal(int[][] sortedArrays, int arrCount, int[] indices, int[] lengths) {
		/*
		 * sentinel values will always be overwritten
		 * 
		 */
		int lowVal = SENTINEL;
		int modified = SENTINEL;
		
		for (int i = 0; i < arrCount; i++) {
			if (indices[i] < lengths[i]) {
				lowVal = sortedArrays[i][indices[i]];
				modified = i;
				break;
			}	
		}
		
		for (int i = 0; i < arrCount; i++) {
			if (indices[i] < lengths[i] && lowVal > sortedArrays[i][indices[i]]) {
				lowVal = sortedArrays[i][indices[i]];
				modified = i;
			}
		}
		indices[modified]++;
		
		return lowVal;
	}
	
	public static void mergeSort(int[] array) {
		int length = array.length;
		
		if (length < 1) {
			return;
		}
		
		boolean isEven = length % 2 == 0;
		int indexStart = 0;
		int indexEnd = length - 1;
		int indexMid = isEven ? indexEnd / 2 : length / 2;
		
		if (indexStart != indexEnd) {
			int[] left = isEven ? new int[length / 2] : new int[length / 2 + 1];
			int[] right = new int[length / 2];
			buildSubArrays(array, left, right, indexMid);
			
			if (left.length > 1) {
				mergeSort(left);
			}
			if (right.length > 1) {
				mergeSort(right);
			}
			
			sortSubArrays(array, left, right);
		}
	}
	
	private static void sortSubArrays(int[] array, int[] left, int[] right) {
		int lengthLeft = left.length;
		int lengthRight = right.length;
		
		for (int i = 0, j = 0, k = 0; i < lengthLeft + lengthRight; i++) {
			if (j < lengthLeft && k < lengthRight) {
				array[i] = left[j] < right[k] ? left[j++] : right[k++];
			} else {
				if (j == lengthLeft) {
					array[i] = right[k++];
				} else {
					array[i] = left[j++];
				}
			}
		}
	}
	
	private static void buildSubArrays(int[] array, int[] left, int[] right, int indexBreak) {
		int lengthLeft = left.length;
		int lengthRight = right.length;
		
		for (int i = 0, j = indexBreak + 1; i < lengthRight; i++, j++) {
			left[i] = array[i];
			right[i] = array[j];
		}
		
		if (lengthLeft != lengthRight) {
			left[lengthLeft - 1] = array[lengthLeft - 1];
		}
	}
	
	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length-1);
	}
	
	private static void quickSort(int[] array, int indexStart, int indexEnd) {
		if (indexEnd - indexStart < 1) {
			return;
		}
		
		int indexPivot = partition(array, indexStart, indexEnd);
		
		if (indexPivot - indexStart > 1) {
			quickSort(array, indexStart, indexPivot-1);
		}
		if (indexEnd - indexPivot > 1) {
			quickSort(array, indexPivot+1, indexEnd);
		}
	}
	
	private static int partition(int[] array, int indexStart, int indexEnd) {	
		int pivotVal = array[indexEnd];
		int indexPivot = indexStart;
		int indexCompare = indexEnd - indexStart > 1 ? indexEnd - 1 : indexEnd;
		
		for (int i = 0, j = indexStart, k = indexCompare; i < indexEnd - indexStart; i++) {
			if (array[j] <= pivotVal) {
				indexPivot++;
				j++;
			} else {
				swap(array, j, k--);
			}
		}
		
		if (indexEnd - indexStart > 1) {
			swap(array, indexPivot, indexEnd);
		}
		
		return indexPivot;
	}
	
	public static void radixSort(int[] array) {	
		int len = array.length;
		
		if (len < 1) {
			return;
		}
		
		int maxNum = array[0];
		int maxIterations = 1;
		
		for (int i = 1; i < len; i++) {
			if (array[i] >= array[i - 1]) {
				maxNum = array[i];
			}
		}
		
		while (maxNum / 10 > 0) {
			maxIterations++;
			maxNum /= 10;
		}
		
		radixSort(array, maxIterations);
	}
	
	public static void radixSort(int[] array, int maxIterations) {	
		for (int i = 0; i < maxIterations; i++) {
			countingSort(array, (int) Math.pow(10, i));
		}
	}
	
	private static void countingSort(int[] array, int placeVal) {
		int[] counts = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int[] sortRef = new int[array.length];
		
		for (int num : array) {
			counts[(num / placeVal) % 10]++;
		}
		
		for (int i = 1; i < counts.length; i++) {
			counts[i] += counts[i - 1]; 
		}
		
		for (int i = array.length - 1; i >= 0; i--) {
			sortRef[counts[(array[i] / placeVal) % 10] - 1] = array[i];
			counts[(array[i] / placeVal) % 10]--;
		}
		
		for (int i = 0; i < array.length; i++) {
            array[i] = sortRef[i];
		}

	}
	
	public static void bubbleSort(int[] array) {
		int comparisons = array.length - 1;
		
		for (int i = 0, j = 1; i < comparisons; i++, j++) {
			if (array[i] > array[j]) {
				swap(array, i, j);
			}
		}
		
		if (--comparisons > 1) {
			bubbleSort(array, comparisons);
		}
	}
	
	private static void bubbleSort(int[] array, int comparisons) {
		for (int i = 0, j = 1; i < comparisons; i++, j++) {
			if (array[i] > array[j]) {
				swap(array, i, j);
			}
		}
		
		if (--comparisons > 1) {
			bubbleSort(array, comparisons);
		}
	}
	
	public static void gnomeSort(int[] array) {
		int length = array.length;
		
		if (length <= 1) {
			return;
		}
		
		for (int i = 0, next = 1; next < length;) {
			if (array[i] > array[next]) {
				swap(array, i, next);
				
				if (i != 0) {
					i--;
					next--;
				}
			} else {
				i++;
				next++;
			}
		}
	}
	
	private static void swap(int[] array, int i, int j) {
		int current = array[i];
		array[i] = array[j];
		array[j] = current;
	}
	/*
	 * Generic sorts require the type to have an implementation of Comparable or Comparator
	 * 
	 */
	public static <T> void quickSort(T[] array, Comparator<T> cmp) {
		quickSort(array, cmp, 0, array.length-1);
	}
	
	private static <T> void quickSort(T[] array, Comparator<T> cmp, int indexStart, int indexEnd) {
		if (indexEnd - indexStart < 1) {
			return;
		}
		
		int indexPivot = partition(array, cmp, indexStart, indexEnd);
		
		if (indexPivot - indexStart > 1) {
			quickSort(array, cmp, indexStart, indexPivot-1);
		}
		if (indexEnd - indexPivot > 1) {
			quickSort(array, cmp, indexPivot+1, indexEnd);
		}
	}
	
	private static <T> int partition(T[] array, Comparator<T> cmp, int indexStart, int indexEnd) {	
		T pivotVal = array[indexEnd];
		int indexPivot = indexStart;
		int indexCompare = indexEnd - indexStart > 1 ? indexEnd - 1 : indexEnd;
		
		for (int i = 0, j = indexStart, k = indexCompare; i < indexEnd - indexStart; i++) {
			if (cmp.compare(array[j], pivotVal) <= 0) {
				indexPivot++;
				j++;
			} else {
				swap(array, j, k--);
			}
		}
		
		if (indexEnd - indexStart > 1) {
			swap(array, indexPivot, indexEnd);
		}
		
		return indexPivot;
	}
	
	public static <T> void selectionSort(T[] array, Comparator<T> cmp) {
		int len = array.length;
		
		if (len < 1) {
			return;
		}
		
		int indexMin = 0;
		int indexCompare = 1;
		int indexHolder = indexMin;
		
		for (int j = indexCompare; j < len; j++) {
			if (cmp.compare(array[j], array[indexHolder]) < 0) {
				indexHolder = j;
			}
		}
		swap(array, indexMin, indexHolder);
		
		if (indexCompare < len - 1) {
			selectionSort(array, cmp, ++indexMin, ++indexCompare);
		}
	}
	
	private static <T> void selectionSort(T[] array, Comparator<T> cmp, int indexMin, int indexCompare) {
		int len = array.length;
		int indexHolder = indexMin;
		
		for (int j = indexCompare; j < len; j++) {
			if (cmp.compare(array[j], array[indexHolder]) < 0) {
				indexHolder = j;
			}
		}
		swap(array, indexMin, indexHolder);
		
		if (indexCompare < len - 1) {
			selectionSort(array, cmp, ++indexMin, ++indexCompare);
		}
	}
	
	public static <T> void insertionSort(T[] array, Comparator<T> cmp) {
		int len = array.length;
		
		if (len < 2) {
			return;
		}
		
		int indexCurrent = 0;
		int indexNext = 1;
		int indexEnd = len - 1;
		int comparisonsMax = 1;
		
		while (indexNext <= indexEnd) {
			sortNext(array, cmp, indexCurrent++, indexNext++, comparisonsMax++);
		}
	}
	
	private static <T> void sortNext(T[] array, Comparator<T> cmp, int indexCurrent, int indexNext, int comparisonsMax) {
		while (comparisonsMax-- >= 1) {
			if (cmp.compare(array[indexNext], array[indexCurrent]) >= 0) {
				break;
			}
			
			swap(array, indexCurrent--, indexNext--);
		}
	}
	
	private static <T> void swap(T[] array, int i, int j) {
		T current = array[i];
		array[i] = array[j];
		array[j] = current;
	}
}
