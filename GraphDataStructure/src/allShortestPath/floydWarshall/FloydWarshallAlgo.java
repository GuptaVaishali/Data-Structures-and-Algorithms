package allShortestPath.floydWarshall;

import java.util.Arrays;
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
	
}

class AllshortestPaths extends Graph{
	int d[][];
	int p[][];
	
	void floydWarshall() {
		p=new int[v][v];
		d=new int[v][v];
		for(int i=0;i<v;i++) {
			for(int j=0;j<v;j++) {
				d[i][j]=w[i][j];
				p[i][j]=-1;
			}
		}
		
//		Arrays.fill(p,-1);
		for(int k=0;k<v;k++) {
			for(int i=0;i<v;i++) {
				for(int j=0;j<v;j++) {
					if(d[i][j] > d[i][k]+d[k][j]) {
						d[i][j]=d[i][k]+d[k][j];
						p[i][j]=k;
					}
				}
			}
		}
	}
	
	void displayDistance() {
		System.out.println("shortest distances");
		for(int i=0;i<v;i++) {
			for(int j=0;j<v;j++) {
				System.out.print(d[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	void findpath(int p[][],int a,int b) {
		if(p[a][b]==-1)
			return;
		findpath(p,a,p[a][b]);
		System.out.print("->" + p[a][b]);
	}
	
	void pathMatrix() {
		System.out.println("shortest paths");
		for(int i=0;i<v;i++) {
			for(int j=0;j<v;j++) {
				System.out.print(p[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	void detectNegativeCycle() {
		boolean isNgCycle = false;
		for(int i=0;i<v;i++) {
			if(d[i][i]<0) {
				isNgCycle=true;
				break;
			}
		}
		if(isNgCycle==true)
			System.out.println("In this graph Negative Cycle exists");
		else
			System.out.println("In this graph Negative Cycle does not exist");
	}
	
}

public class FloydWarshallAlgo {

	public static void main(String[] args) {
		
		AllshortestPaths g =new AllshortestPaths();
		g.input();
		g.floydWarshall();
		g.displayDistance();
		g.pathMatrix();
		System.out.println("Enter vertex a and b");
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		System.out.println("Shortest path form vertex "+ a + " to vertex b is = " 
		+ a + "->");
		g.findpath(g.p, a, b);
		System.out.println("->" + b);
		g.detectNegativeCycle();
	}

}
