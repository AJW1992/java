package datastructs;

import java.util.Comparator;

import utilities.TypeComparison;

public class TestObj implements Comparable<TestObj> {
	private int x;
	private double y;
	private String str;
	/*
	 * custom ordering(s) for TestObj
	 * sorting available on all defined orderings
	 * 
	 */
	public static class CMP implements Comparator<TestObj> {
		@Override
		public int compare(TestObj o1, TestObj o2) {
			int result = TypeComparison.strCompare(o1.str, o2.str, false);

			if (result < 0) {
				return -1;
			}
			if (result > 0) {
				return 1;
			} 
			
			result = TypeComparison.dblCompare(o1.y, o2.y);

			if (result < 0) {
				return -1;
			}
			if (result > 0) {
				return 1;
			}
			
			return TypeComparison.intCompare(o1.x, o2.x);
		}
	}
	
	public static class CMP_INT implements Comparator<TestObj> {
		@Override
		public int compare(TestObj o1, TestObj o2) {
			return TypeComparison.intCompare(o1.x, o2.x);
		}
	}

	public static class CMP_DBL implements Comparator<TestObj> {	
		@Override
		public int compare(TestObj o1, TestObj o2) {
			return TypeComparison.dblCompare(o1.y, o2.y);
		}
	}
	
	public static class CMP_STR implements Comparator<TestObj> {
		@Override
		public int compare(TestObj o1, TestObj o2) {
			return TypeComparison.strCompare(o1.str, o2.str, false);
		}
	}
	
	public TestObj(int x, double y, String str) {
		this.x = x;
		this.y = y;
		this.str = str;		
	}
	/*
	 * natural ordering of TestObj
	 * used primarily for search
	 * sorting with compareTo is restricted to one implementation
	 * 
	 */
	@Override
	public int compareTo(TestObj o) {
		/*
		 * TypeComparison defines natural ordering functions for system types
		 * defining a natural ordering that differs from TypeComparison should be noted
		 * 
		 */
		return TypeComparison.intCompare(this.x, o.x);
	}
	
	public int getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
		
	public String getStr() {
		return str;
	}
	
	public String toString() {
		return this.str + ", " + this.y + ", " + this.x;
	}
}
