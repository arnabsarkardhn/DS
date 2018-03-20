package com.arnab.algos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class MinHeap<K> {
	public K [] mH;
	
	private boolean isMultivalue;

	public boolean isMultivalue() {
		return isMultivalue;
	}

	public void setMultivalue(boolean isMultivalue) {
		this.isMultivalue = isMultivalue;
	}

}

public class MinHeapImpl {

	public static void main(String[] args) {
		
		List<String> a = new ArrayList<String>();
		a.add("hi");
		a.add(null);
		System.out.println(a);
		
	}

}
