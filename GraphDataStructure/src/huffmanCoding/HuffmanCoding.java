package huffmanCoding;

import java.util.Comparator;
import java.util.PriorityQueue;

class Node implements Comparator<Node> {
	char ch;
	int freq;
	Node left;
	Node right;
	
	Node(){}
	
	Node(char ch,int freq) {
		this.ch = ch;
		this.freq = freq;
		this.left=null;
		this.right=null;
	} 
	
	public int compare(Node n1 , Node n2) {
		return n1.freq - n2.freq;
	}
}

public class HuffmanCoding {
	
	static Node huffman(char symbol[],int frequency[] ,int n) {
		PriorityQueue<Node> pq = new PriorityQueue<>(n,new Node());
		
		for(int i=0;i<n;i++) {
			char c = symbol[i];
			int f = frequency[i];
			pq.add(new Node(c,f));
		}
		
		while(pq.size()>1) {
			Node n1= pq.remove();
			Node n2 = pq.remove();
			Node r = new Node();
			r.freq = n1.freq + n2.freq;
			r.left = n1;
			r.right = n2;
			r.ch='-';
			pq.add(r);
		}
		Node root = pq.remove();
		return root;
	}
	
	static void findcode(Node root,String s) {
		if(root.left==null && root.right==null) {
			System.out.println(root.ch + "  \t  " + s);
			return;
		}
		findcode(root.left,s+"0");
		findcode(root.right,s+"1");
	}
	
	public static void main(String[] args) {
		
		char symbol[] = {'A','B','C', 'D', 'E'};
		int frequency[]= {3,5,6,4,2};
		Node root = huffman(symbol,frequency,symbol.length);
		System.out.println("character code");
		findcode(root, "");
	}

}
