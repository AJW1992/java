package tools;

public class ArrayTools {

	public static <T> void printAll(T[] array, int lineSize) {
		int lineBreak = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (lineBreak < lineSize - 1 && i < array.length - 1) {
				System.out.print(array[i] + ", ");
				lineBreak++;
			} else {
				System.out.println(array[i]);
				lineBreak = 0;
			}
		}
	}
	
	public static <T> void printAll(T[] array) {
		for (T item: array) {
			System.out.println(item);
		}
	}
	
	public static <T> void showAll(T[] array, int lineSize) {
		int lineBreak = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (lineBreak < lineSize - 1 && i < array.length - 1) {
				System.out.print(array[i].toString() + ", ");
				lineBreak++;
			} else {
				System.out.println(array[i].toString());
				lineBreak = 0;
			}
		}
	}
	
	public static <T> void showAll(T[] array) {
		for (T item: array) {
			System.out.println(item.toString());
		}
	}
	
	public static <T> int[] hashAll(T[] array) {
		int[] hashed = new int[array.length];
		
		for (int i = 0; i < array.length; i++) {
			hashed[i] = array[i].hashCode();
		}
		
		return hashed;
	}
}
