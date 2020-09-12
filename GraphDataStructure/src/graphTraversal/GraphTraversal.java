package graphTraversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Graph {
	int v,a[][];
	
	Graph(){}
	
	Graph(int v){
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
	
	void BFSTraversal(int s) {
		boolean visited[]=new boolean[v];
		Queue<Integer> q=new LinkedList<>();
		q.add(s);
		visited[s]=true;
		while(!q.isEmpty()) {
			int e= q.remove();
			System.out.println(e);
			for(int i=0;i<v;i++) {
				if(a[e][i]==1 && visited[i]!=true) {
					q.add(i);
					visited[i]=true;
				}
			}
		}
	}
	
	void DFSTraversal(int s) {
		boolean visited[]= new boolean[v];
		Stack<Integer> stack = new Stack<>();
		stack.push(s);
		System.out.println(s);
		visited[s]=true;
		while(!stack.empty()) {
			int e=stack.peek();
			boolean flag=true;
			for(int i=0;i<v;i++) {
				if(a[e][i]==1 && visited[i]==false) {
					stack.push(i);
					visited[i]=true;
					System.out.println(i);
					flag=false;
					break;
				}
			}
			if(flag==true) {		//for dead end..for backtracking
				stack.pop();
			}
		}
	}
	
	
	
}

public class GraphTraversal {

	public static void main(String[] args) {
		
		Graph g=new Graph();
		g.input();
		System.out.println("BFS Traversal");
		g.BFSTraversal(0);
		System.out.println("DFS Traversal");
		g.DFSTraversal(0);
		
	}

}
