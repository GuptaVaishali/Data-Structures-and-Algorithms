package Lists;

import java.util.Scanner;

class Node{
	int data;
	Node next;
	
	Node(){}
	
	Node(int data){
		this.data=data;
		next=null;
	} 
}

class SLinkedList{
	Node head;
	
	SLinkedList(){
		head=null;
	}
	
	boolean isEmpty() {
		if(head==null) return true;
		else	return false;
	}
	
	int getSize() {
		int size=0;
		Node cur=head;
		while(cur!=null) {
			size++;
			cur=cur.next;
		}
		return size;
	}
	
	void create(int n) {
		head=new Node();
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
	}
	
	void insert(int index,int value) throws Exception {
		if(index<0 || index > getSize()) {
			throw new Exception("index out of bound exception");
		}
		Node toinsert=new Node(value);
		if(index==0) {
			toinsert.next=head;
			head=toinsert;
		}
		else {
			Node cur=head;
			for(int i=0;i<index-1;i++) {
				cur=cur.next;
			}
			toinsert.next=cur.next;
			cur.next=toinsert;
			
		}
	}
	
	int delete(int index)throws Exception {
		if(index<0 || index >= getSize()) {
			throw new Exception("index out of bound exception");
		}
		int delvalue;
		if(index==0) {
			delvalue=head.data;
			head=head.next;
		}
		else {
		Node cur=head;
		for(int i=0;i<index-1;i++) {
			cur=cur.next;
		}
		delvalue=cur.next.data;
		cur.next=cur.next.next;
		}
		return delvalue;
	}  
	
/*	int delete(int index) {
		int delvalue=0;
		
		if(index==0) {
			Node todelete = head;
			delvalue=todelete.data;
			head=todelete.next;
			todelete.next=null;
		}
		else {
			Node cur=head;
			for(int i=0;i<index-1;i++) {
				cur=cur.next;
			}
			Node todelete = cur.next;
			delvalue=todelete.data;
			cur.next=todelete.next;
			todelete.next=null;
		}
		return delvalue;
	} */
	
	
	void merge(SLinkedList l2) {
		
		Node cur=head;
		while(cur.next!=null) {
			cur=cur.next;
		}
		
		cur.next=l2.head;
	}
	
	
	void display() {
		Node cur=head;
		while(cur!=null) {
			System.out.println(cur.data);
			cur=cur.next;
		}
	}
	
	int get(int index) throws Exception {
		if(index<0 || index >= getSize()) {
			throw new Exception("invalid index");
		}
		int val=0;
		Node cur=head;
		for(int i=0;i<index;i++) {
			cur=cur.next;
		}
		val=cur.data;
		return val;
	}
	
	int indexOf(int val) {
		int index=0;
		Node cur=head;
		boolean flag=false;
		while(cur!=null) {
			if(cur.data!=val) {
				cur=cur.next;
				index++;
			}
			else {
				flag=true;
				break;
			}
		}
		if(!flag) {
			index=-1;
		}
		return index;
	}
	
}

public class SingleLinkedList {
	public static void main(String args[]) {
		SLinkedList l1 = new SLinkedList();
		SLinkedList l2 = new SLinkedList();
		System.out.println(l1.isEmpty());
		try {
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Number of nodes in list1");
			int n=sc.nextInt();
			
			l1.create(n);
			
			System.out.println("Enter Number of nodes in list2");
			int n1=sc.nextInt();
			
			l2.create(n1);
			
			l1.merge(l2);
			
			l1.display();
			
			System.out.println("After Insertion");
			
			l1.insert(0, 6);
			l1.insert(1, 7);
			l1.insert(2, 12);
			
			l1.insert(1, 3);
			
			l1.display();
			
			System.out.println("deleted value = " + l1.delete(3));
			l1.display();
			
			System.out.println("size= "+ l1.getSize());
			System.out.println(l1.isEmpty());
			
			System.out.println("value get is = " + l1.get(0));
			
			int index=l1.indexOf(9);
			if(index==-1)	
				System.out.println("Element not found");
			else	
				System.out.println("Element found at index= " +  index);
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
