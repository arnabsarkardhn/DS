package com.arnab.algos;

import java.util.ArrayList;
import java.util.List;

class TransitiveGraph {
	private int vertices;
	private List<Integer>[] adjList;
	private int [][]tc;
	
	public TransitiveGraph(int vertices) {
		this.vertices = vertices;
		this.tc = new int[this.vertices][this.vertices];
		adjList = new ArrayList[vertices];
		for(int i = 0; i < vertices; i++) {
			adjList[i] = new ArrayList<>();
		}
	}
	
	public void addEdges(int from, int to) {
		adjList[from].add(to);
	}
	
	public void findTransitiveDependency() {
		for(int i = 0; i < vertices; i++) {
			dfsUtils(i, i);
		}
	}
	
	public void dfsUtils(int from, int to) {
		tc[from][to] = 1;
		for(int adj : adjList[to]) {
			if(tc[from][adj] == 0) {
				dfsUtils(from, adj);
			}
		}
	}
}

public class TransitiveDependencyForNodes {

	
	
	
}
