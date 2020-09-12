package spanningTree.kruskalAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
	int s,d,w;
	Edge(int s,int d,int w){
		this.s=s;
		this.d=d;
		this.w=w;
	}
	
	public int compareTo(Edge ed) {
		return this.w-ed.w;
	}
}

class Graph {
	int v,e;
	Edge edge[];
	int p[];
	
	Graph(){
		
	}
	
	void input() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter No of vertices and edges");
		v=sc.nextInt();
		e=sc.nextInt();
		edge=new Edge[e];
		p=new int[v];
		for(int i=0;i<e;i++) {
			System.out.println("Enter Source and Dest vertex of edge " + i);
			int s=sc.nextInt();
			int d=sc.nextInt();
			int w=sc.nextInt();
			edge[i]=new Edge(s,d,w);
		}
		makeset();
	}
	
	void makeset() {
		for(int i=0;i<v;i++) {
			p[i]=-1;
		}
	}
	
	int findParent(int u) {
		if(p[u]<0)
			return u;
		else
			return findParent(p[u]);
	}
	
	void union(int a,int b) {
			if(p[a]<=p[b]) {
				p[a]=p[a]+p[b];
				p[b]=a;
			}else {
				p[b]=p[a]+p[b];
				p[a]=b;
			 }
	}
	
	void kruskal(){
		ArrayList<Edge> result = new ArrayList<>();
		Arrays.sort(edge);
		
		int k=0;
		while(result.size()<v-1) {		
			int a= findParent(edge[k].s);
			int b=findParent(edge[k].d);
	
			if(a!=b) {
				
				result.add(new Edge(edge[k].s,edge[k].d,edge[k].w));
				union(a,b);
			}
			k++;
		} 

		System.out.println("Spanning Tree");
		for(int i=0;i<result.size();i++) {
			System.out.print(result.get(i).s + " -- " + result.get(i).d + 
								" == " + result.get(i).w);
			System.out.println();
		}
	
	}
	
}

public class KruskalAlgo {

	public static void main(String[] args) {
		
		Graph g = new Graph();
		g.input();
		g.kruskal();
	} 

}
