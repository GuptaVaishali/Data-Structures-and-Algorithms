package CSList;

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

class CSList{
	Node head;
	
	CSList(){
		head=null;
	}
	
	boolean isEmpty() {
		return head==null;
	}
	
	int getSize() {
		if(head==null)
			return 0;
		int size=1;
		Node cur=head;
		while(cur.next!=head) {
			size++;
			cur=cur.next;
		}
		return size;
	}
	
	void create(int n) {
		head=new Node();
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
	//	return head;
	}
	
	void insert(int index,int val)throws Exception {
		
		if(index<0 || index>getSize()) {
			throw new Exception("invalid index");
		}
		Node toinsert = new Node(val);
		if(index==0) {
			if(head==null) {
				toinsert.next=toinsert;
				head=toinsert;
			}
			else {
				toinsert.next=head;
				Node cur = head;
				while(cur.next!=head) {
					cur=cur.next;
				}
				cur.next=toinsert;
				head=toinsert;
			}
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
	
	int delete(int index) throws Exception {
		if(index<0 || index>=getSize()) {
			throw new Exception("invalid index");
		}
		int delvalue=0;
		Node todelete;
		if(index==0) {
			Node cur=head;
			while(cur.next!=head) {
				cur=cur.next;
			}
			
			todelete = head;
			delvalue=todelete.data;
			if(head.next==head) {
				head=null;
			}
			else {
				cur.next=todelete.next;
				head=todelete.next;
			}
		}
		else {
			Node cur=head;
			for(int i=0;i<index-1;i++) {
				cur=cur.next;
			}
			todelete=cur.next;
			delvalue=todelete.data;
			cur.next=todelete.next;
		}
		todelete.next=null;
		return delvalue;
	}
	
	int get(int index) throws Exception {
		
		if(index<0 || index>=getSize()) {
			throw new Exception("invalid index");
		}
		Node cur=head;
		for(int i=0;i<index;i++) {
			cur=cur.next;
		}
		return cur.data;
	}
	
	int indexOf(int val) {
		int index=-1,i=0;
		if(head==null) return -1;
		Node cur=head;
		while(cur.next!=head && cur.data!=val) {
			cur=cur.next;
			i++;
		}
		
		if(cur.data==val) index=i;
		return index;
	}
	
	void merge(CSList l2) {
		Node cur=head;
		while(cur.next!=head) {
			cur=cur.next;
		}
		cur.next=null;
		cur.next=l2.head;
		
		Node cur1 = l2.head;
		while(cur1.next!=l2.head) {
			cur1=cur1.next;
		}
		cur1.next=head;
	}
	
//	void merge(CSList l2) {
//		Node temp=head.next;
//		head.next=l2.head.next;
//		l2.head.next=temp;
//	}
	
	void display() {
		if(head==null) return;
		Node cur=head;
		while(cur.next!=head) {
			System.out.println(cur.data);
			cur=cur.next;
		}
		System.out.println(cur.data);
	}
}
public class SCircularLinkedList {

	public static void main(String[] args) {
		
		CSList cll = new CSList();
		CSList cll2 = new CSList();
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Number of nodes in list1");
			int n1=sc.nextInt();
			
			cll.create(n1);
			
			System.out.println("Enter Number of nodes in list2");
			int n2=sc.nextInt();
			cll2.create(n2);
			
			cll.merge(cll2);
			
			cll.display();
			
			cll.insert(0, 15);
			cll.insert(1, 67);
			cll.insert(2, 34);
			
			
			System.out.println("Size = " + cll.getSize());
			System.out.println(cll.isEmpty());
			
			cll.display();
			
			System.out.println("value = " + cll.get(0));
			System.out.println("value = " + cll.get(1));
			
			System.out.println("deleted value = " + cll.delete(0));
			cll.display();
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		int index = cll.indexOf(3);
		if(index==-1) {
			System.out.println("Element not found");
		}
		else {
			System.out.println("Element found at index = "+ index);
		}

	}

}
