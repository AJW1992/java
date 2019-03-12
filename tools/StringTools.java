package tools;

public class StringTools {
	public static String[] matchCase(String[] array, boolean lowerCase) {
		for (String item: array) {
			item = matchCase(item, lowerCase);
		}
		
		return array;
	}
	
	public static String matchCase(String string, boolean lowerCase) {
		if (lowerCase) {
			return string.toLowerCase();
		} else {
			return string.toUpperCase();
		}
	}
	
	public static boolean isPalindrome(char[] entry, int i, int j) {
		if (i == j) {
			return true;
		} else if (entry[i] == entry[j] && i > j) {
			return true;
		} else if (entry[i] == entry[j]) {
			return isPalindrome(entry, i+1, j-1);
		} else {
			return false;
		}
	}
	
	public static int[] hashStrings(String[] array) {
		int[] hashedStrings = new int[array.length];
		
		for (int i = 0; i < array.length; i++) {
			hashedStrings[i] = array[i].hashCode();
		}
		
		return hashedStrings;
	}
}
