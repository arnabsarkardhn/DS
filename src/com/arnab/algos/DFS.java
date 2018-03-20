package com.arnab.algos;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DFS {

	private int v; 
	private List<Integer> adjacent[];

	DFS(int v) {
		this.v = v;
		adjacent = new LinkedList[v];
		for(int i = 0; i < v; i++) {
			adjacent[i] = new LinkedList<>();
		}
	}
	
	public void addEdges(int v, int w) {
		adjacent[v].add(w);
	}
	
	public void dfsTraverse(int start) {

		boolean visited[] = new boolean[v];
		traverse(start, visited);
	}
	
	public void traverse(int start, boolean visited[]) {
		visited[start] = true;
		System.out.println(start);
		Iterator<Integer> iterator = adjacent[start].listIterator();
		while(iterator.hasNext()) {
			Integer next = iterator.next();
			if(!visited[next])
				traverse(next, visited);
		}
	}
	
	public static void main(String[] args) {
		DFS ps = new DFS(13);
		ps.addEdges(0, 1);
		ps.addEdges(0, 2);
		
		ps.addEdges(1, 3);
		ps.addEdges(1, 4);
		ps.addEdges(1, 5);
		
		ps.addEdges(2, 6);
		ps.addEdges(2, 7);
		ps.addEdges(2, 8);
		
		ps.addEdges(6, 9);
		ps.addEdges(6, 10);
		ps.addEdges(6, 11);
		ps.addEdges(6, 12);
		
		ps.dfsTraverse(0);
	}

}
