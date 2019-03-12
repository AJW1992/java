package tools;

import java.util.Comparator;
/*
 * Arrays passed into binarySearch() must be sorted to produce meaningful results
 * 
 */
public class SearchTools {
	public static <T> T binarySearch(T[] sortedArray, Comparator<T> cmp, T item) {		
		int len = sortedArray.length;
		
		if (len == 0) {
			return null;
		} else if (len == 1) {
			return cmp.compare(sortedArray[0], item) == 0 ? item : null;
		} else {
			return splitArray(sortedArray, cmp, item, 0, len-1);
		}
	}
	
	private static <T> T splitArray(T[] sortedArray, Comparator<T> cmp, T item, int indexStart, int indexEnd) {
		int indexBreak =  indexStart + (indexEnd - indexStart) / 2;
		
		if (cmp.compare(item, sortedArray[indexBreak]) == 0) {
			return item;
		} else if (cmp.compare(item, sortedArray[indexBreak]) < 0) {
			return search(sortedArray, cmp, item, indexStart, indexBreak);
		} else {
			return search(sortedArray, cmp, item, ++indexBreak, indexEnd);
		}
	}
	
	private static <T> T search(T[] sortedArray, Comparator<T> cmp, T item, int indexStart, int indexEnd) {
		if (indexStart != indexEnd) {
			return splitArray(sortedArray, cmp, item, indexStart, indexEnd);
		}
		
		if (cmp.compare(sortedArray[indexStart], item) == 0) {
			return item;
		} else {
			return null;
		}
	}
	
	public static <T> T linearSearch(T[] sortedArray, T item) {
		for (T obj : sortedArray) {
			if (obj.equals(item)) {
				return obj;
			}
		}
		
		return null;
	}
}

