package Node;

import java.util.Scanner;

class Node{
	int data;
	Node next;
} 

class NodeMethods{
	Node create(int n) {
		Node head=new Node();
		Node cur=new Node();
		for(int i=0;i<n;i++) {
			if(i==0) {
				cur=head;
			}
			else {
				cur.next=new Node();
				cur=cur.next;
			}
			System.out.println("Enter Data");
			Scanner sc=new Scanner(System.in);
			cur.data=sc.nextInt();
		}
		cur.next=null;
		return head;
	}
	
	void display(Node head) {
		Node cur=new Node();
		cur=head;
		while(cur!=null) {
			System.out.println(cur.data);
			cur=cur.next;
		}
	}
}


public class CreateNode {
	
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number of nodes in list");
		int n=sc.nextInt();
		NodeMethods ob=new NodeMethods();
		Node h= ob.create(n);
		ob.display(h);
	}
}
