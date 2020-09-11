package QueueByLinkedList;

class Node{
	int data;
	Node next;
	
	Node(){}
	Node(int data){
		this.data=data;
		next=null;
	}
}
class Queue{
	Node front,rear;
	Queue(){
		front=rear=null;
	}
	
	boolean isEmpty() {
		if(rear==null) return true;
		else return false;
	}
	
	int getSize() {
		if(rear==null) return 0;
		int size=1;
		Node cur = front;
		while(cur!=rear) {
			size++;
			cur=cur.next;
		}
		return size;
	}
	
	void enqueue(int val) {
		Node toAdd = new Node(val);
		if(rear==null) {
			front=rear=toAdd;
		}
		else {
			rear.next=toAdd;
			rear=rear.next;
		}
	}
	
	int dequeue() throws Exception{
		if(rear==null) {
			throw new Exception("Queue is Empty");
		}
		int val=front.data;
		if(front==rear) {
			front=rear=null;
		}
		else {
			front=front.next;
		}
		return val;
	}
	
	void display() {
		if(front==null)  return;
		Node cur = front;
		while(cur!=rear) {
			System.out.print(cur.data + "  ");
			cur=cur.next;
		}
		System.out.print(cur.data + "  ");
		System.out.println();
	}
}

public class QWithLinkedList {

	public static void main(String[] args) {
		
		Queue q = new Queue();
		System.out.println(q.isEmpty());
		System.out.println("size = " + q.getSize());
		q.enqueue(3);
		q.enqueue(6);
		q.enqueue(7);
		q.display();
		
		try {
			System.out.println("deleted element " + q.dequeue());
			System.out.println("size " + q.getSize());
			System.out.println("deleted element " + q.dequeue());
			System.out.println("deleted element " + q.dequeue());
			System.out.println("deleted element " + q.dequeue());
			System.out.println("size " + q.getSize());
			q.display();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(q.isEmpty());
	}

}
