package detectCycle;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class GraphWithList {
	int v;
	LinkedList<Integer> a[];
	
	void input() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter No. of vertices");
		v=sc.nextInt();
		a=new LinkedList[v];
		for(int i=0;i<v;i++)
			a[i]=new LinkedList<>();
		for(int i=0;i<v;i++) {
			System.out.println("Enter No of vertices in list " + i);
			int j=sc.nextInt();
			System.out.println("Enter vertices of list " + i);
			for(int k=0;k<j;k++) {
				int u=sc.nextInt();
				a[i].add(u);
			}
		}
	}
	
	boolean detectCycle(int s) {
		boolean visited[]=new boolean[v];
		Queue<Integer> q= new LinkedList<>();
		boolean isCycle=false;
		
		q.add(s);
		visited[s]=true;
		while(!q.isEmpty()) {
			int u=q.remove();
			while(!a[u].isEmpty()) {
				int vertex=a[u].remove();
				if(!visited[vertex]) {
					q.add(vertex);
					visited[vertex]=true;
				}
				else {
					if(q.contains(vertex)) {
						isCycle=true;
						return isCycle;
					}
				}
			}
		}
		return isCycle;
	}
	
}

public class DetectCycleInUndirected {

	public static void main(String[] args) {
		
		GraphWithList g = new GraphWithList();
		g.input();
		boolean isCycle = g.detectCycle(0);
		if(isCycle==true)
			System.out.println("Cycle exist");
		else
			System.out.println("Cycle does not exist");
	}

}
