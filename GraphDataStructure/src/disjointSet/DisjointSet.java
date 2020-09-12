package disjointSet;

import java.util.Scanner;

class Graph {
	int v;
	int p[];
	
	Graph(){}
	
	void input() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter No of vertices and edges");
		v=sc.nextInt();
		p=new int[v];
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
	
	void union(int u,int v) {
		int a= findParent(u);
		int b= findParent(v);
		if(a!=b) {
			if(p[a]<=p[b]) {
				p[a]=p[a]+p[b];
				p[b]=a;
			}else {
				p[b]=p[a]+p[b];
				p[a]=b;
			 }
		}
	}
	
}

public class DisjointSet {

	public static void main(String[] args) {
		
		Graph g=new Graph();
		g.input();
		g.union(0, 1);
		g.union(1, 3);
		g.union(2, 5);
		g.union(2, 8);
		g.union(9, 4);
		g.union(6, 9); 
		
		System.out.println(g.findParent(0));
		System.out.println(g.findParent(1));
		System.out.println(g.findParent(2));
		System.out.println(g.findParent(3));
		System.out.println(g.findParent(4));
		System.out.println(g.findParent(5));
		System.out.println(g.findParent(6));
		System.out.println(g.findParent(7));
		System.out.println(g.findParent(8)); 
		System.out.println(g.findParent(9)); 
		
	}

}
