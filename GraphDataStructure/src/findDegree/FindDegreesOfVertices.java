package findDegree;

import java.util.Scanner;

class DirectedGraph {
	int v;
	int a[][];
	
	void input() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter No of vertices");
		v=sc.nextInt();
		a=new int[v][v];
		System.out.println("Enter Adjacency matrix");
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
	
	int[] outdegree() {
		int outdeg[]=new int[v];
		for(int i=0;i<v;i++) {
			outdeg[i]=0;
			for(int j=0;j<v;j++) {
				outdeg[i]+=a[i][j];
			}
		}
		return outdeg;
	}
	
}

public class FindDegreesOfVertices {

	public static void main(String[] args) {
		
		DirectedGraph dg =new DirectedGraph();
		dg.input();
		System.out.println("\nindegree of all vertices");
		System.out.println("vertex \t indegree");
		int x[]=dg.indegree();
		for(int i=0;i<dg.v;i++) {
			System.out.println(i + " \t " + x[i]);
		}
		
		System.out.println("\noutdegree of all vertices");
		System.out.println("vertex \t outdegree");
		int y[]=dg.outdegree();
		for(int i=0;i<dg.v;i++) {
			System.out.println(i + " \t " + y[i]);
		}

	}

}
