package node;

import java.util.Scanner;

class Node {
	int data;
	Node next;
}

class CList{
	Node create(int n) {
		Node head=new Node();
		Node cur = new Node();
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
		cur.next=head;
		return head;
	}
	
	void display(Node head) {
		Node cur= head;
		if(head==null) return;
		while(cur.next!=head) {
			System.out.println(cur.data);
			cur=cur.next;
		}
		System.out.println(cur.data);
	}
}

class CSList{
	public static void main(String args[]) {
		CList ob= new CList();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number of nodes in list");
		int n=sc.nextInt();
		ob.display(null);
		Node head= ob.create(n);
		ob.display(head);
	}
}
