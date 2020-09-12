package shortestPath.bellmanFord;

import java.util.Scanner;

class Edge {
	int s,d,w;
	
	Edge(int s,int d ,int w){
		this.s=s;
		this.d=d;
		this.w=w;
	}
}

class Graph {
	int v,e;
	Edge edge[];
	
	Graph() {}
	
	Graph(int v,int e){
		this.v=v;
		this.e=e;
		edge=new Edge[e];
	}
	
	void input() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter No of vertices and edges");
		v=sc.nextInt();
		e=sc.nextInt();
		edge=new Edge[e];
		
		for(int i=0;i<e;i++) {
			System.out.println("Add Source and dest vertex and weight of edge " + i);
			int s=sc.nextInt();
			int d=sc.nextInt();
			int w=sc.nextInt();
			edge[i]=new Edge(s,d,w);
		}
	}
	
	void bellmanFord(int source) {
		int dist[]=new int[v];
		for(int i=0;i<v;i++) {
			dist[i]=Integer.MAX_VALUE;
		}
		dist[source]=0;
		for(int j=0;j<v-1;j++) {
			for(int i=0;i<edge.length;i++) {
				if( (dist[edge[i].s]!=Integer.MAX_VALUE) &&  (dist[edge[i].d] > dist[edge[i].s] + edge[i].w)) {
					dist[edge[i].d] = dist[edge[i].s] + edge[i].w;
				}
			}
		}
		
		for(int i=0;i<edge.length;i++) {
			if((dist[edge[i].s]!=Integer.MAX_VALUE) && (dist[edge[i].d] > dist[edge[i].s] + edge[i].w)) {
				System.out.println("Graph contains a negative cycle..can not compute shortest distances");
				return;
			}
		}
		
		for(int i=0;i<v;i++) {
			System.out.print("Shortest distance from vertex " + source + " to vertex " + i + " = ");
			System.out.println(dist[i] + " ");
		}
		System.out.println();
	}
}

public class BellManFordAlgo {

	public static void main(String[] args) {
		
		Graph g=new Graph();
		g.input();
		g.bellmanFord(4);
	}

}
