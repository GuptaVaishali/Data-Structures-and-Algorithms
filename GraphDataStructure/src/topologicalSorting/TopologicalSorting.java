package topologicalSorting;

import java.util.Scanner;

class Graph{
	int v,a[][];
	
	Graph(){}
	
	Graph(int v) {
		this.v=v;
		a=new int[v][v];
	}
	
	void input() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter No. of vertices");
		v=sc.nextInt();
		a=new int[v][v];
		
		System.out.println("Enter Adjacency Matrix");
		for(int i=0;i<v;i++) {
			for(int j=0;j<v;j++) {
				a[i][j]=sc.nextInt();
			}
		}
	}
	
	int[] indegree() {
		int indeg[]=new int[v];
		for(int i=0;i<v;i++) {
			indeg[i]=0;
			for(int j=0;j<v;j++) {
				indeg[i]+=a[j][i];
			}
		}
		return indeg;
	}
	
	void tsorting() {
		boolean visited[]=new boolean[v];
		int cnt=0;
		boolean flag=false;
		while(cnt<=v) {
			int b[]=indegree();
			for(int i=0;i<v;i++) {
				if(b[i]==0 && !visited[i]) {
					visited[i]=true;
					System.out.println(i + " ");
					cnt++;
					for(int j=0;j<v;j++) {
						if(a[i][j]==1) {
							a[i][j]=0;
						}
					}
					flag=true;
				}
				if(!flag) {
					System.out.println("cycle exist..topological sorting is not possible");
					return;
				}
			}
		}
	}
}

public class TopologicalSorting {
	
	public static void main(String args[]) {
		Graph g=new Graph();
		g.input();
		g.tsorting();
	}
	
}
