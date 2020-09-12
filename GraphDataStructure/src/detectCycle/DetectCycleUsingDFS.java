package detectCycle;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

class Graph {
	int v;
	LinkedList<Integer> a[];
	
	Graph(){	
	}
	
	Graph(int v){
		this.v=v;
		a=new LinkedList[v];
		for(int i=0;i<v;i++) {
			a[i] = new LinkedList<>();
		}
	}
	
	void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter No of vertices");
		v=sc.nextInt();
		
		a=new LinkedList[v];
		for(int i=0;i<v;i++) {
			a[i] = new LinkedList<>();
		}
		
		for(int i=0;i<v;i++) {
			System.out.println("Enter No of Adjacent vertices of vertex " + i);
			int u=sc.nextInt();
			for(int j=0;j<u;j++) {
				System.out.println("Enter Adjacent vertices of vertex " + i);
				a[i].add(sc.nextInt());
			}
		}
	}
	
	boolean detectCycle(int s) {
		boolean visited[]=new boolean[v];
		boolean isCycle=false;
		Stack<Integer> stack = new Stack<>();
		stack.push(s);
		visited[s]=true;
		while(!stack.empty()) {
			int u=stack.peek();
			int vertex = a[u].remove();
			if(!visited[vertex]) {
				stack.push(vertex);
				visited[vertex]=true;
			}
			else {
				if(stack.contains(vertex)) {
					isCycle=true;
					return isCycle;
				}
			}
		}
		
		return isCycle;
	}
}
public class DetectCycleUsingDFS {

	public static void main(String[] args) {
		
		Graph g = new Graph();
		g.input();
		if(g.detectCycle(0)) 
			System.out.println("Cycle exists");
		else
			System.out.println("Cycle does not exists");
	}

}
