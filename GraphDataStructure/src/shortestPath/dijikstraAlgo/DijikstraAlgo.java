package shortestPath.dijikstraAlgo;

import java.util.Scanner;

class Graph{
	int v;
	int w[][];
	Graph(){}
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
class ShortestPath extends Graph{
	int d[];
	int p[];
	int s;
	
	void inputSourceVertex() {
		System.out.println("Enter Source Vertex");
		Scanner sc=new Scanner(System.in);
		s= sc.nextInt();
		
	}
	void ShowVertex() {
		System.out.println("source vertex " + s);
	}
	void dijikstra() {
		d=new int[v];
		p=new int[v];
		boolean visited[]=new boolean[v];
		for(int i=0;i<v;i++) {
			d[i]=Integer.MAX_VALUE;
		}
		d[s]=0;
		for(int j=0;j<v;j++) {
			int min=Integer.MAX_VALUE;int mv=-1;
			for(int i=0;i<v;i++) {
				if(!visited[i] && d[i]<min) {
					min=d[i];
					mv=i;
				}
			}
			visited[mv]=true;
			for(int i=0;i<v;i++) {
				if(w[mv][i]>0 && w[mv][i]<Integer.MAX_VALUE) {
					if(!visited[i] && d[i]>d[mv]+w[mv][i]) {
						d[i]=d[mv] + w[mv][i];
						p[i]=mv;
					}
				}
			}
		}
		
	}
	
	void displayShortestDistance() {
		for(int i=0;i<v;i++) {
			System.out.println("The Shortest Distance from vertex "
								+ s + " to vertex " + i + " is = " + d[i]);
			System.out.println("The Shortest path from vertex "
					+ s + " to vertex " + i + " is = " + p[i]);
		}
	}
	
	
	void Path(int u, int p[]) {
		if(p[u]==s)
			return;
		else
			Path(p[u],p);
		System.out.print(p[u] + " -> ");
			
	}
	
}

public class DijikstraAlgo {

	public static void main(String[] args) {
		ShortestPath g=new ShortestPath();
		g.input();
		g.inputSourceVertex();
		g.dijikstra();
		g.ShowVertex();
		g.displayShortestDistance();
		for(int u=0;u<g.v;u++) {
			System.out.println("The Shortest path from vertex "+ g.s +
								" to vertex " + u);
			System.out.print(g.s + " -> ");
			g.Path(u, g.p);
			System.out.println(u);
		}
	}

}
