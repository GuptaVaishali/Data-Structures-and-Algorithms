package spanningTree.primAlgo;

import java.util.Scanner;

class Graph{
	int v;
	int w[][];
	Graph(){
		
	}
	
	Graph(int v){
		this.v=v;
		w=new int[v][v];
	}
	
	void input() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter No of vertices");
		v=sc.nextInt();
		w=new int[v][v];
		System.out.println("Enter weight matrix");
		for(int i=0;i<v;i++) {
			for(int j=0;j<v;j++) {
				w[i][j]=sc.nextInt();
			}
		}
	}
	
	void prim(int s) {
		boolean visited[]=new boolean[v];
		int d[]=new int[v];
		int p[]=new int[v];
		
		for(int i=0;i<v;i++) {
			d[i]=Integer.MAX_VALUE;
		}
		
		d[s]=0;
		
		for(int j=0;j<v;j++) {
			int min=Integer.MAX_VALUE;
			int mv=-1;
			for(int i=0;i<v;i++) {
				if(!visited[i] && d[i]<min) {
					min=d[i];
					mv=i;
				}
			}
			
			visited[mv]=true;
			if(mv!=s)
				System.out.println(p[mv] + " -> " + mv);
			
			for(int i=0;i<v;i++) {
				if(!visited[i] && w[mv][i]!=0 && w[mv][i]!=Integer.MAX_VALUE && d[i] > w[mv][i]) {
					d[i]=w[mv][i];
					p[i]=mv;
				}
			}
		}
	}
		
	
}


public class PrimAlgo {

	public static void main(String[] args) {
		
		Graph g= new Graph();
		g.input();
		System.out.println("\nEnter Source Vertex");
		Scanner sc = new Scanner(System.in);
		int s= sc.nextInt();
		System.out.println("Minimum Spanning Tree Edges");
		g.prim(s);
	}

}
