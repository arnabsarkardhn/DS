package com.arnab.algos;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * You are given a graph with N vertices and M edges. Master parent is the vertex which has no parent but may have 0 or more children. 
 * In any connected component of the graph,vertex with the lowest value in that component serves as the master parent. 
 * A vertex is called happy if it has more children than its parent. Count the number of happy vertices in the given graph.
 * The graph has no cycles or self loops.
 *
 * Input Format:
 *
 * First line consists of two space separated integers denoting N and M and the following 
 * M lines consist of two space separated integers X and Y denoting there is an edge between vertices X and Y.
 *
 * Output Format:
 *
 * Print the number of happy vertices in the graph.
 *
 * @author arnasarkar
 *
 */
class Parent {
	private int noOfHumans;
	private List<Integer> humans[];
	
	Parent(int noOfHuman) {
		this.noOfHumans = noOfHuman;
		humans = new LinkedList[noOfHuman];
		for(int addHumans = 0; addHumans < noOfHumans; addHumans++) {
			humans[addHumans] = new LinkedList<Integer>();
		}
	}
	
	public void addChildren(int parent, int children) {
		humans[parent].add(children);
	}
	
	public void happyParent(int start) {
		boolean visited[] = new boolean[noOfHumans];
		int happyParentList[] = new int[noOfHumans];
		happyParentList = findHappyParent(visited, start, 0, happyParentList);
		for(int count = 0; count < noOfHumans;  count++) {
			if(happyParentList[count] == 1)
				System.out.println(count);
		}
	}
	
	public int[] findHappyParent(boolean visited[], int currentHuman, int noOfChildForParent, int happyParentsList[]) {
		visited[currentHuman] = true;
		int noOfChildForCurrentParent = humans[currentHuman].size();
		if(noOfChildForCurrentParent > noOfChildForParent && noOfChildForParent != 0)
  			happyParentsList[currentHuman] = 1;
		Iterator<Integer> iterate = humans[currentHuman].listIterator();
		while(iterate.hasNext()) {
			Integer child = iterate.next();
			if(!visited[child])
				findHappyParent(visited, child, noOfChildForCurrentParent, happyParentsList);
		}
		return happyParentsList;
	}
	
}

public class HappyParent {

	public static void main(String[] args) {

		Parent ps = new Parent(8);
		ps.addChildren(0, 1);
		ps.addChildren(1, 2);
		ps.addChildren(1, 3);
		ps.addChildren(3, 4);
		ps.addChildren(3, 5);
		ps.addChildren(3, 6);
		/*ps.addChildren(0, 1);
		ps.addChildren(0, 2);
		
		ps.addChildren(1, 3);
		ps.addChildren(1, 4);
		ps.addChildren(1, 5);
		
		ps.addChildren(2, 6);
		ps.addChildren(2, 7);
		ps.addChildren(2, 8);
		
		ps.addChildren(6, 9);
		ps.addChildren(6, 10);
		ps.addChildren(6, 11);
		ps.addChildren(6, 12);*/
		
		ps.happyParent(0);
		
	}

}
