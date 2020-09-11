package GenericLinkedList;

import java.util.Scanner;

class Node<E>{
	E data;
	Node<E> next;
	
	Node(){}
	
	Node(E data){
		this.data=data;
		next=null;
	} 
}

class SLinkedList<E>{
	Node<E> head;
	
	SLinkedList(){
		head=null;
	}
	
	boolean isEmpty() {
		if(head==null) 
			return true;
		else	
			return false;
	}
	
	int getSize() {
		int size=0;
		Node<E> cur=head;
		while(cur!=null) {
			size++;
			cur=cur.next;
		}
		return size;
	}
	
	void create(int n) {
		head=new Node<>();
		Node<E> cur=new Node<>();
		for(int i=0;i<n;i++) {
			if(i==0) {
				cur=head;
			}
			else {
				cur.next=new Node<E>();
				cur=cur.next;
			}
			System.out.println("Enter Data");
			Scanner sc=new Scanner(System.in);
//			if(cur.data instanceof Integer)
			cur.data=(E) sc.next();
		}
		cur.next=null;
	}
	
	void insert(int index,E value) throws Exception {
		if(index<0 || index > getSize()) {
			throw new Exception("index out of bound exception");
		}
		Node<E> toinsert=new Node<E>(value);
		if(index==0) {
			toinsert.next=head;
			head=toinsert;
		}
		else {
			Node<E> cur=head;
			for(int i=0;i<index-1;i++) {
				cur=cur.next;
			}
			toinsert.next=cur.next;
			cur.next=toinsert;
			
		}
	}
	
	E delete(int index)throws Exception {
		if(index<0 || index >= getSize()) {
			throw new Exception("index out of bound exception");
		}
		E delvalue;
		if(index==0) {
			delvalue=head.data;
			head=head.next;
		}
		else {
		Node<E> cur=head;
		for(int i=0;i<index-1;i++) {
			cur=cur.next;
		}
		delvalue=cur.next.data;
		cur.next=cur.next.next;
		}
		return delvalue;
	}  
	
	
	void display() {
		Node<E> cur=head;
		while(cur!=null) {
			System.out.println(cur.data);
			cur=cur.next;
		}
	}
	
	E get(int index) throws Exception {
		if(index<0 || index >= getSize()) {
			throw new Exception("invalid index");
		}
		E val;
		Node<E> cur=head;
		for(int i=0;i<index;i++) {
			cur=cur.next;
		}
		val=cur.data;
		return val;
	}
	
	int indexOf(E val) {
		int index=0;
		Node<E> cur=head;
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
	
	void merge(SLinkedList<E> l2) {
		
		Node<E> cur=head;
		while(cur.next!=null) {
			cur=cur.next;
		}
		
		cur.next=l2.head;
	}
	
}

public class SingleLinkedList {
	public static void main(String args[]) {
		SLinkedList<String> l1 = new SLinkedList<>();
		SLinkedList<String> l3 = new SLinkedList<>();
	//	SLinkedList<Integer> l2 = new SLinkedList<>();
		System.out.println(l1.isEmpty());
		try {
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Number of nodes in list1");
			int n=sc.nextInt();
			
			l1.create(n);
			
			System.out.println("Enter Number of nodes in list2");
			int n1=sc.nextInt();
			
			l3.create(n1);
			
			l1.merge(l3);
			
			l1.display();
			
//			System.out.println("After Insertion");
//			
//			l1.insert(0, 6);
//			l1.insert(1, 7);
//			l1.insert(2, 12);
//			
//			l1.insert(1, 3);
//			
//			l1.display();
//			
////			l3.insert(0, "vaishali");
////			l3.insert(1, "Tanya");
////			
////			l3.display();
//			
//			
			System.out.println("deleted value = " + l1.delete(3));
			l1.display();
			
			System.out.println("size= "+ l1.getSize());
			System.out.println(l1.isEmpty());
			
			System.out.println("value get is = " + l1.get(0));
			
//			int index=l1.indexOf(6);
//			if(index==-1)	
//				System.out.println("Element not found");
//			else	
//				System.out.println("Element found at index= " +  index);
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
