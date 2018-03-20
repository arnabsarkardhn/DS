package com.arnab.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * https://www.youtube.com/watch?v=fAuF0EuZVCk
 * https://www.geeksforgeeks.org/minimum-cost-connect-cities/
 *
 * There are n cities and there are roads in between some of the cities. 
 * Somehow all the roads are damaged simultaneously. 
 * We have to repair the roads to connect the cities again. 
 * There is a fixed cost to repair a particular road. 
 * Find out the minimum cost to connect all the cities by repairing roads. 
 * Input is in matrix(city) form, if city[i][j] = 0 then there is not any road between city i and city j, if city[i][j] = a > 0 then the cost to rebuild the path between city i and city j is a. 
 * Print out the minimum cost to connect all the cities.
 * It is sure that all the cities were connected before the roads were damaged.
 * 
 * @author arnasarkar
 *
 */

public class MinimumSpanningTreeKruskalAlgo {

	class Edge implements Comparable<Edge> {

		int src;
		int dest;
		int weight;
		
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
		
		@Override
		public String toString() {
			return src + ":" + dest + ":" + weight;
		}
	}
	
	Edge edge[];
	int V, E;
	Map<Integer, List<Integer>> disjointSet = new HashMap<Integer, List<Integer>>();
	
	
	MinimumSpanningTreeKruskalAlgo(int v, int e) {
		this.V = v;
		this.E = e;
		edge = new Edge[E];
		for(int i = 0; i < e; i++) {
			edge[i] = new Edge();
		}
	}
	
	public void createDisjointSet() {
		for(int i = 0; i < V; i++) {
			Integer set = new Integer(i);
			List<Integer> listSet = new ArrayList<Integer>();
			listSet.add(set);
			disjointSet.put(set, listSet);
		}
	}
	
	public Boolean findSet(Integer firstV, Integer secondV) {
		Integer firstSetName = null, secondSetName = null;
		for(Map.Entry<Integer, List<Integer>> listOfValue : disjointSet.entrySet()) {
			if(listOfValue.getValue().contains(firstV)) 
				firstSetName = listOfValue.getKey();
			if(listOfValue.getValue().contains(secondV))
				secondSetName = listOfValue.getKey();
		}
		if(firstSetName.equals(secondSetName))
			return true;
		else 
			return false;
	}
	
	public void mergeSet(Integer key, Integer key2) {
		Integer firstSetName = null, secondSetName = null;
		for(Map.Entry<Integer, List<Integer>> listOfValue : disjointSet.entrySet()) {
			if(listOfValue.getValue().contains(key)) 
				firstSetName = listOfValue.getKey();
			if(listOfValue.getValue().contains(key2))
				secondSetName = listOfValue.getKey();
		}
		List<Integer> temp = new ArrayList<>();
		temp.addAll(disjointSet.get(firstSetName));
		temp.addAll(disjointSet.get(secondSetName));
		disjointSet.put(key, temp);
		disjointSet.remove(secondSetName);
	}
	
	public void kruskalStartMST() {
		//1st sort the edges in decreasing order by their weight
		Arrays.sort(edge);
		//Result to store the pair of final edges
		Edge resultant[] = new Edge[V];
		/*for(int i = 0; i < V; i++) {
			resultant[i] = new Edge();
		}*/
		createDisjointSet();
		int k = 0;
		//Start to iterate the edges
		for(int i = 0; i < edge.length; i++) {
			int source = edge[i].src;
			int destination = edge[i].dest;
			Boolean inSameSet = findSet(source, destination);
			if(!inSameSet) {
				resultant[k] = edge[i];
				mergeSet(source, destination);
				k++;
			}
		}
		
		for(int i = 0; i < k; i++) {
			System.out.println(resultant[i].toString());
		}
		
	}
	
	public static void main(String args[]) {
		int V = 6;  
        int E = 9;  
        MinimumSpanningTreeKruskalAlgo graph = new MinimumSpanningTreeKruskalAlgo(V, E);
        
        
       /* // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;
 
        // add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;
 
        // add edge 0-3
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;
 
        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;
 
        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;*/
        
        // add edge 0-3
        graph.edge[0].src = 0;
        graph.edge[0].dest = 3;
        graph.edge[0].weight = 1;
 
        // add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 1;
 
        // add edge 0-3
        graph.edge[2].src = 2;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 1;
 
        // add edge 1-3
        graph.edge[3].src = 4;
        graph.edge[3].dest = 5;
        graph.edge[3].weight = 2;
 
        // add edge 2-3
        graph.edge[4].src = 1;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 3;
        
        // add edge 2-3
        graph.edge[5].src = 0;
        graph.edge[5].dest = 1;
        graph.edge[5].weight = 3;
        
        graph.edge[6].src = 2;
        graph.edge[6].dest = 5;
        graph.edge[6].weight = 4;
        
        graph.edge[7].src = 2;
        graph.edge[7].dest = 4;
        graph.edge[7].weight = 5;
        
        graph.edge[8].src = 3;
        graph.edge[8].dest = 4;
        graph.edge[8].weight = 6;
        
        graph.kruskalStartMST();
	}
}
