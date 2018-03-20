package com.arnab.algos;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BFS {

	private int v;
	private List<Integer> adj[];
	
	BFS(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for(int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int from, int to) {
		adj[from].add(to);
	}
	
	void bfs(int start) {
		boolean visited[] = new boolean[v];
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		while(!queue.isEmpty()) {
			Integer value = queue.poll();
			System.out.println(value);
			Iterator<Integer> it = adj[value].listIterator();
			while(it.hasNext()) {
				Integer val = it.next();
				if(!visited[val]) {
					visited[val] = true;
					queue.add(val);
				}
			}
		}
	}
	
	public static void main(String[] args) {

		BFS bfs = new BFS(4);
		bfs.addEdge(0, 1);
		bfs.addEdge(0, 2);
		bfs.addEdge(1, 2);
		bfs.addEdge(2, 0);
		bfs.addEdge(2, 3);
		bfs.addEdge(3, 3);
		
		bfs.bfs(2);
	}

}
