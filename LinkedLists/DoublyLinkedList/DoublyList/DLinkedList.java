package DoublyList;

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

class DoublyLinkedList{
	Node head;
	DoublyLinkedList(){
		head=null;
	}
	
	boolean isEmpty(){
		return head==null;
	}
	
	int getSize() {
		int size=0;
		Node cur=head;
		while(cur!=null) {
			cur=cur.next;
			size++;
		}
		return size;
	}
	
	void create(int n) {
		Node cur=new Node();
		head=new Node();
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
	}
	 
	void insert(int index,int val) throws Exception {
		if(index<0 || index > getSize()) {
			throw new Exception("index out of bound exception");
		}
		
		Node toinsert=new Node(val);
		if(index==0) {
			toinsert.next=head;
			toinsert.prev=null;
			if(head!=null) {
				head.prev=toinsert;
			}
			head=toinsert;
		}
		else {
			Node cur=head;
			for(int i=0;i<index-1;i++) {
				cur=cur.next;
			}
			toinsert.next=cur.next;
			toinsert.prev=cur;
			toinsert.prev=cur;
			cur.next=toinsert;
		}
	}
	
	int delete(int index)throws Exception {
		if(index<0 || index >= getSize()) {
			throw new Exception("index out of bound exception");
		}
		int delvalue;
		Node todelete;
		if(index==0) {
			todelete=head;
			delvalue=todelete.data;
			head=todelete.next;
			if(head!=null) {
				head.prev=null;
			}
			todelete.prev=todelete.next=null;
		}
		else {
			Node cur=head;
			for(int i=0;i<index-1;i++) {
				cur=cur.next;
			}
			todelete=cur.next;
			delvalue=todelete.data;
			cur.next=todelete.next;
			if(todelete.next!=null) {
				todelete.next.prev=cur;
				todelete.next=null;
			}
			todelete.prev=null;
		}
		return delvalue;
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
		int index=-1,i=0;
		if(head==null) return index;
		Node cur=head;
		while(cur.next!=null && cur.data!=val) {
			cur=cur.next;
			i++;
		}
		index=i;
		return index;
	}
	
	void display() {
		Node cur=head;
		while(cur!=null) {
			System.out.println(cur.data);
			cur=cur.next;
		}
	}
	
}


public class DLinkedList {

	public static void main(String[] args) {
		
		DoublyLinkedList dl = new DoublyLinkedList();
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the no of elements in list");
			int n=sc.nextInt();
			
			dl.create(n);
			dl.display();
			
			System.out.println("After insertion operation");
			dl.insert(0,5);
			dl.insert(2,7);
			
			dl.display();
			System.out.println("size = " + dl.getSize());
			
			System.out.println("Enter index on which you want to find value");
			
			int ind=sc.nextInt();
			System.out.println("value found is = " + dl.get(ind));
			
			System.out.println("Enter index on which you want to delete value");
			
			int ind1=sc.nextInt();
			
			System.out.println("deleted value = " + dl.delete(ind1));
			dl.display();
			
			System.out.println(dl.isEmpty());
			System.out.println("size = " + dl.getSize());
			
			System.out.println("which value's index do you want to search?");
			int val=sc.nextInt();
			int index= dl.indexOf(val);
			if(index==-1) {
				System.out.println("Element not found");
			}
			else {
				System.out.println("Element found at index = " + index);
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
