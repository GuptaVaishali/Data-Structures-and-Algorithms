package allShortestPath.johnsonAlgo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;


class Node{
	int vertex;
	int cost;
	
	Node(){}
	
	Node(int vertex,int cost){
		this.vertex=vertex;
		this.cost=cost;
	}
}

class CompareByCost implements Comparator<Node> {
	public int compare(Node n1, Node n2) {
		return n1.cost-n2.cost;
	}
}

class Graph {
	int v;
	LinkedList<Node> a[];
	
	Graph(){}
	
	Graph(int v){
		this.v=v;
		a=new LinkedList[v];
		for(int i=0;i<v;i++) {
			a[i]=new LinkedList<Node>();
		}
	}
	
	void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter No. of vertices");
		v=sc.nextInt();
		a=new LinkedList[v];
		
		for(int i=0;i<v;i++) 
			a[i]=new LinkedList<Node>();
		
		for(int i=0;i<v;i++) {
			System.out.println("Enter No of adjacency vertices of vertex " + i);
			int n=sc.nextInt();
			for(int j=0;j<n;j++) {
				System.out.println("Enter dest vertex and weight");
				int d = sc.nextInt();
				int w = sc.nextInt();
				a[i].add(new Node(d,w));
			}
		}
	}
	
	void johnson() {
		int d[][] = new int[v][v];
		
		LinkedList<Node> a1[] = new LinkedList[v+1];
		for(int i=0;i<v+1;i++) 
			a1[i]=new LinkedList<Node>();
		
		for(int i=0;i<v;i++) {
			for(int j=0;j<a[i].size();j++) {
				a1[i].add(new Node(a[i].get(j).vertex,a[i].get(j).cost));
			}
		}
		for(int i=0;i<v;i++)
			a1[v].add(new Node(i,0));
		
	/*	System.out.println("New linkedList");
		for(int i=0;i<v+1;i++) {
			for(int j=0;j<a1[i].size();j++) {
				System.out.println(i + " " + a1[i].get(j).vertex + " " + a1[i].get(j).cost);
			}
		}  */
		
		int db[]=bellmanFord(v,a1, v+1);
		
		for(int i=0;i<v;i++) {
			for(int j=0;j<a[i].size();j++) {
				a[i].get(j).cost+=db[i]-db[a[i].get(j).vertex];
			}
		}
		
	/*	System.out.println("old linkedList");
		for(int i=0;i<v;i++) {
			for(int j=0;j<a[i].size();j++) {
				System.out.println(i + " " + a[i].get(j).vertex + " " + a[i].get(j).cost);
			}
		} */
		
		int dd[] = new int[v];
		for(int i=0;i<v;i++) {
			dd= dijikstra(i);
			for(int j=0;j<v;j++)
				d[i][j]=dd[j];
		}
		
		for(int i=0;i<v;i++) {
			for(int j=0;j<v;j++) {
				System.out.print(d[i][j] + " ");
			}
			System.out.println();
		} 
	}
	
	
	int[] dijikstra(int s) {
		int dist[] = new int[v];
		for(int i=0;i<v;i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		dist[s] = 0;
		
		boolean visited[] = new boolean[v]; 
		
		PriorityQueue<Node> pq = new PriorityQueue<>(v,new CompareByCost());
		pq.add(new Node(s,0));
		
		while(!pq.isEmpty()) {
			Node n = pq.remove();
			int mv = n.vertex;
	//		int d = n.cost;
			
			visited[mv] = true;
			
	//		System.out.println("pq remove node " + mv + " " + d);
			
			for(int j=0;j<a[mv].size();j++) {
				Node  node = a[mv].get(j);
				int v = node.vertex;
				int w = node.cost;
				
	//			System.out.println("Adjacency vertices " + v + " " + w);
				
				if( !visited[v] && ((dist[mv] + w) < dist[v]) ) {
					dist[v] = dist[mv] + w;
	//				System.out.println("pq added " + v + " " + dist[v]);
					pq.add(new Node(v,dist[v]));
				}
			}
		}
		
		System.out.println("shortest distances form vertex " + s);
		System.out.println("vertex\tdistance");
		for(int i=0;i<v;i++) {
			System.out.println(i + "\t" + dist[i]);
		}
		
		return dist;
	}
	
	int[] bellmanFord(int s,LinkedList<Node> b[],int v) {
		int dist[] = new int[v];
		for(int i=0;i<v;i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		dist[s] = 0;
		
		for(int i=0;i<v-1;i++) {
			for(int j=0;j<v;j++) {
				for(int k=0;k<b[j].size();k++) {
					Node n = b[j].get(k);
					if((dist[j] != Integer.MAX_VALUE) && (dist[j] + n.cost) < dist[n.vertex]) {
						dist[n.vertex] = dist[j] + n.cost;
					}
				}
			}
		}
		
		System.out.println("shortest distances form vertex " + s);
		System.out.println("vertex\tdistance");
		for(int i=0;i<v;i++) {
			System.out.println(i + "\t" + dist[i]);
		} 
		
		return dist;
		
	} 
	
}

public class JohnsonAlgo {

	public static void main(String[] args) {
		
		Graph g= new Graph();
		g.input();
		g.johnson();
		
	}

}
