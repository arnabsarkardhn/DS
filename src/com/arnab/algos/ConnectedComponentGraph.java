package com.arnab.algos;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * Calculate no of disconnected graphs 
 * 
 * @author arnasarkar
 *
 */
class ConnectedGraph {
	private int noOfPoint;
	private List<Integer> points[];
	
	public ConnectedGraph(int noOfPoint) {
		this.noOfPoint = noOfPoint;
		points = new LinkedList[noOfPoint];
		for(int point = 0; point < noOfPoint; point++) {
			points[point] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int from, int to) {
		points[from].add(to);
	}
	
	public void findNoOfConnectedGraphs(int start) {
		boolean[] visited = new boolean[noOfPoint];
		 
		for(int i = 0; i < points.length; i++) {
			List<Integer> graphsList = new LinkedList<Integer>();
			graphsList.add(i);
			if(!visited[i]) {
				countConnectedGraphs(i, visited, graphsList);
				if(graphsList.size() > 1)
					System.out.println(graphsList);
			}
		}
		
	}
	
	public void countConnectedGraphs(int point, boolean[] visited, List<Integer> graphsList) {
		
		Iterator<Integer> it = points[point].listIterator();
		while(it.hasNext()) {
			Integer value = it.next(); 
			if(!visited[value]) {
				visited[point] = true;
				graphsList.add(value);
				countConnectedGraphs(value, visited, graphsList);
			}
		}
 	}
}

public class ConnectedComponentGraph {

	public static void main(String[] args) {
		ConnectedGraph cs = new ConnectedGraph(11);
		/*cs.addEdge(0, 1);
		cs.addEdge(2, 3);
		cs.addEdge(3, 4);
		cs.addEdge(7, 8);
		cs.addEdge(7, 9);
		cs.addEdge(9, 10);
		*/
	
		
		
		cs.addEdge(7, 0);
		cs.addEdge(7, 2);
		cs.addEdge(1, 5);
		cs.addEdge(6, 3);
		cs.addEdge(6, 4);
		cs.addEdge(9, 6);
		cs.addEdge(1, 7);
		cs.addEdge(9, 8);
//		cs.addEdge(1, 9);
		cs.addEdge(4, 9);
		
		
		/*cs.addEdge(0, 1);
		cs.addEdge(0, 2);
		cs.addEdge(3, 0);
		cs.addEdge(2, 3);
		cs.addEdge(3, 4);*/
		
		cs.findNoOfConnectedGraphs(0);
		
	}

}
