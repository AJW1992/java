package utilities;

public class TypeComparison {
	/*
	 * defines custom implementations for standard type comparison functions
	 * functions impose natural orderings
	 * implementations may produce different results than System defined comparison functions
	 * 
	 */
	public static int boolCompare(boolean flag1, boolean flag2) {
		if (flag1 == flag2) {
			return 1;
		}
		
		return 0;
	}
	
	public static int byteCompare(byte num1, byte num2) {
		return num1 - num2;
	}
	
	public static int shCompare(short num1, short num2) {
		return num1 - num2;
	}
	
	public static int intCompare(int num1, int num2) {
		return num1 - num2;
	}
	
	public static int lgCompare(long num1, long num2) {
		long result = num1 - num2;
		
		if (result < 0) {
			return -1;
		} else if (result > 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static int fltCompare(float num1, float num2) {
		float result = num1 - num2;
		
		if (result < 0) {
			return -1;
		} else if (result > 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static int dblCompare(double num1, double num2) {
		double result = num1 - num2;
		
		if (result < 0) {
			return -1;
		} else if (result > 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static int chCompare(char ch1, char ch2) {
		if (ch1 < ch2) {
			return -1;
		} else if (ch1 > ch2) {
			return 1;
		} else {
			return 0;
		}
	}
	/*
	 * String type comparison is done recursively with char comparison
	 * results are calculated lexicographically (see encoding type for details; defaults to unicode)
	 * boolean value true for case-sensitive comparisons
	 * 
	 */
	public static int strCompare(String str1, String str2, boolean caseSensitive) {
		if (!caseSensitive) {
			return strCompare(str1.toLowerCase(), str2.toLowerCase(), true);
		}
		
		int len1 = str1.length();
		int len2 = str2.length();

		if (len1 == 0 && len2 == 0) {
			return 0;
		}
		if (len1 == 0) {
			return -1;
		}
		if (len2 == 0) {
			return 1;
		}
		
		int result = chCompare(str1.charAt(0), str2.charAt(0));
		
		if (result != 0) {
			return result;
		}
		if (len1 == 1 && len2 == 1) {
			return 0;
		}
		if (len1 == 1 ^ len2 == 1) {
			return len1 < len2 ? -1 : 1;
		}
		
		return strCompare(str1.substring(1), str2.substring(1), caseSensitive);
	}
}
