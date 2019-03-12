package datastructs;

import java.util.Comparator;

import tools.Sort;
import tools.SortingTools;

public class SortType<E> implements Sort {
	private E[] array;
	private Comparator<E> cmp;
	
	public SortType() {}
	
	public SortType(E[] array, Comparator<E> cmp) {
		this.array = array;
		this.cmp = cmp;
	}
	
	@Override
	public void sort() {
		SortingTools.insertionSort(array, cmp);
	}
	
	public E[] getArray() {
		return array;
	}
	
	public Comparator<E> getCmp() {
		return cmp;
	}
}
