package shortestPath.dijikstraUsingPriorityQueue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node{
	int vertex;
	int cost;
	
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
	
	void disjikstra(int s) {
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
	}
	
	void bellmanFord(int s) {
		int dist[] = new int[v];
		for(int i=0;i<v;i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		dist[s] = 0;
		
		for(int i=0;i<v-1;i++) {
			for(int j=0;j<v;j++) {
				for(int k=0;k<a[j].size();k++) {
					Node n = a[j].get(k);
					if( (dist[j] != Integer.MAX_VALUE) &&  (dist[j] + n.cost) < dist[n.vertex] ) {
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
		
	}
	
}

public class DijikstraAlgoUsingPriorityQueue {

	public static void main(String[] args) {
		
		Graph g= new Graph();
		g.input();
		System.out.println("Dijikstra Algorithm");
		g.disjikstra(0);
		System.out.println("bellmanFord Algorithm");
		g.bellmanFord(1);
	}

}
