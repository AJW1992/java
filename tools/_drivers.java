package tools;

import java.util.Comparator;

import datastructs.Generator;
import datastructs.SortType;
import datastructs.TestObj;

import utilities.TypeComparison;

public class _drivers {
	public static void simpleSort() {
		boolean print = false;
		Generator intGen = new Generator(4);
		int[][] lists = new int[20][100000];
		
		for (int i = 0; i < lists.length; i++) {
			intGen.generateAnyArray(lists[i]);
		}
		
		for (int[] list : lists) {
			SortingTools.mergeSort(list);
		}
		
		long time1 = System.currentTimeMillis();
		int[] sortedLists = SortingTools.coalesce(lists);
		long time2 = System.currentTimeMillis();
		
		if (print) {
			for (int i = 0; i < sortedLists.length; i++) {
				if (i % 10 == 0) {
					System.out.println();
				}
				System.out.print(sortedLists[i] + " ");
			}
			System.out.println();
		}
		
		System.out.printf("Elapsed time: %d ms\n", time2-time1);
	}
	
	public static void genericSort() {
		TestObj objs[] = {new TestObj(2, 4444.4, "abc"),
						  new TestObj(4, -99.9, "def"),
						  new TestObj(4, 0, "abc"),
						  new TestObj(3, -0.66, "def"),
						  new TestObj(3, 0, "a"),
						  new TestObj(5, 0, "abc"),
						  new TestObj(6, -2.3, "a"),
						  new TestObj(3, 0, "ab"),
						  new TestObj(4, 0, "def"),
						  new TestObj(-6, 0, "ab")};
		
		SortingTools.quickSort(objs, new TestObj.CMP());
		
		for (TestObj obj : objs) {
			System.out.println(obj.toString());
		}
	}
	
	public static void genericSortAnonymous() {
		TestObj objs[] = {new TestObj(2, 4444.4, "e"),
				  new TestObj(5, 0, "ee"),
				  new TestObj(1, 0, "e"),
				  new TestObj(3, 0.66, "e"),
				  new TestObj(3, 0, "e"),
				  new TestObj(5, 0, "e"),
				  new TestObj(6, -2.3, "e"),
				  new TestObj(6, 0, "d"),
				  new TestObj(-6, -0.44, "e"),
				  new TestObj(-6, 0, "ea")};
		
		SortingTools.quickSort(objs, new Comparator<TestObj>() {
			@Override
			public int compare(TestObj o1, TestObj o2) {
				int result = TypeComparison.intCompare(o1.getX(), o2.getX());
				if (result != 0) {
					return result;
				}
				
				if (TypeComparison.dblCompare(o1.getY(), o2.getY()) <= 0) {
					return -1;
				} else {
					return 1;
				}
			}
		});
		
		for (TestObj obj : objs) {
			System.out.println(obj.toString());
		}
	}
	
	public static void specifiedSort() {
		TestObj objs[] = {new TestObj(2, 4444.4, "abc"),
						  new TestObj(4, -99.9, "def"),
						  new TestObj(4, 0, "abc"),
						  new TestObj(3, -0.66, "def"),
						  new TestObj(3, 0, "a"),
						  new TestObj(5, 0, "abc"),
						  new TestObj(6, -2.3, "a"),
						  new TestObj(3, 0, "ab"),
						  new TestObj(4, 0, "def"),
						  new TestObj(-6, 0, "ab")};
		
		TestObj objsAlt[] = {new TestObj(2, 4444.4, "abc"),
							 new TestObj(4, -99.9, "def"),
							 new TestObj(4, 0, "abc"),
							 new TestObj(3, -0.66, "def"),
							 new TestObj(3, 0, "a"),
							 new TestObj(5, 0, "abc"),
							 new TestObj(6, -2.3, "a"),
							 new TestObj(3, 0, "ab"),
							 new TestObj(4, 0, "def"),
							 new TestObj(-6, 0, "ab")};
		/*
		 * st_class uses the sort method specified in the implementing class
		 * anonymous implementation uses the sort method defined during initialization (more flexible)
		 * 
		 */
		SortType<TestObj> st_class = new SortType<TestObj>(objs, new TestObj.CMP_DBL());
		st_class.sort();
		
		new SortType<TestObj>() {
			@Override
			public void sort() {
				SortingTools.quickSort(objsAlt, new TestObj.CMP());
			}
		}.sort();
		
		
		for (TestObj obj : st_class.getArray()) {
			System.out.println(obj.toString());
		}
		System.out.println();
		for (TestObj obj : objsAlt) {
			System.out.println(obj.toString());
		}
	}
}
