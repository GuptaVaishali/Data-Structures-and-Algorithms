package connectedComponents;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

class ConnComponents {
	int v;
	LinkedList<Integer> a[];
	
	ConnComponents(){	
	}
	
	ConnComponents(int v){
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
	
	void findConnectedComponents() {
		int cnt=0;
		boolean visited[]=new boolean[v];
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<v;i++) {
			if(!visited[i]) {
				cnt++;
				DFS(i,stack,visited);
			}
		}
		
		System.out.println("No of connected components " + cnt);
	}
	
	void DFS(int s, Stack<Integer> stack,boolean visited[]) {
		stack.push(s);
		visited[s]=true;
		
		while(!stack.empty()) {
			boolean flag=false;
			int u=stack.peek();
			
			while(a[u].size()>0) {
				int vertex = a[u].remove();
				if(!visited[vertex]) {
					stack.push(vertex);
					visited[vertex] = true;
					flag=true;
					break;
				}
			}
			
			if(!flag) {
				stack.pop();
			}
		}
	}
	
}

public class NoOfConnectedComponents {

	public static void main(String[] args) {
		
		ConnComponents g = new ConnComponents();
		g.input();
		g.findConnectedComponents();
	}

}
