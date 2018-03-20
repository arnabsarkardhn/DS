package com.arnab.algos;

class Graph {
	
	int E, V;
	Edge edge[];
	
	class Edge {
		int src, dest, weight;
		Edge() {
			src = dest = weight = 0;
		}
		
		@Override
		public String toString() {
			return src + ":" + dest + ":" + weight;
		}
	}
	
	Graph(int v, int e) {
		E = e;
		V = v;
		edge = new Edge[e];
		for(int i = 0; i < e; i++)
			edge[i] = new Edge();
	}
	
	public void findShortestPath(int start) {
		int dist[] = new int[V];
		for(int i = 0; i < V; i++)
			dist[i] = Integer.MAX_VALUE;
		dist[0] = 0;
		
		for(int i = 1; i < V; i++) {
		
			for(int j = 0; j < E; j++) {
				int source = edge[j].src;
				int destination = edge[j].dest;
				int weight = edge[j].weight;
				if(dist[source] != Integer.MAX_VALUE && dist[destination] > dist[source] + weight)
					dist[destination] = dist[source] + weight; 
			}
		}
	}
	
	@Override
	public String toString() {
		return edge.toString();
	}
}

public class BellmanFord {

	public static void main(String[] args) {
		Graph graph = new Graph(5, 8);
		
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = -1;
 
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;
 
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 3;
 
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 2;
 
        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].weight = 2;
 
        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].weight = 5;
 
        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].weight = 1;
 
        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].weight = -3;
		
	}

}
