package DNode;

import java.util.Scanner;

class Node{
	int data;
	Node prev;
	Node next;
	
	Node(){}
	
	Node(int data){
		this.data=data;
		this.prev=null;
		this.next=null;
	}
}

class DoublyListNode{
	Node create(int n) {
		Node cur=new Node();
		Node head=new Node();
		for(int i=0;i<n;i++) {
			if(i==0) {
				head=cur;
			}
			else {
				cur.next=new Node();
				cur.next.prev=cur;
				cur=cur.next;
			}
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter data");
			cur.data=sc.nextInt();
		}
			head.prev=null;
			cur.next=null;
			return head;
	}
	
	void display(Node head) {
		Node cur=head;
		while(cur!=null) {
			System.out.println(cur.data);
			cur=cur.next;
		}
	}
	
}

public class DoublyNode {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		DoublyListNode ob=new DoublyListNode();
		Node head= ob.create(n);
		ob.display(head);

	}

}
