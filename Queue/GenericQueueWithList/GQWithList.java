package genericQueuewithList;

class Node<T>{
	T data;
	Node<T> next;
	
	Node(){}
	Node(T data){
		this.data=data;
		next=null;
	}
}
class Queue<T>{
	Node<T> front,rear;
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
		Node<T> cur = front;
		while(cur!=rear) {
			size++;
			cur=cur.next;
		}
		return size;
	}
	
	void enqueue(T val) {
		Node<T> toAdd = new Node<>(val);
		if(rear==null) {
			front=rear=toAdd;
		}
		else {
			rear.next=toAdd;
			rear=rear.next;
		}
	}
	
	T dequeue() throws Exception{
		if(rear==null) {
			throw new Exception("Queue is Empty");
		}
		T val=front.data;
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
		Node<T> cur = front;
		while(cur!=rear) {
			System.out.print(cur.data + "  ");
			cur=cur.next;
		}
		System.out.print(cur.data + "  ");
		System.out.println();
	}
}


public class GQWithList {

	public static void main(String[] args) {
		
		Queue<Integer> q = new Queue<>();
		System.out.println(q.isEmpty());
		System.out.println("size = " + q.getSize());
		q.enqueue(3);
		q.enqueue(6);
		q.enqueue(7);
		q.display();
		
		try {
			System.out.println("deleted element " + q.dequeue());
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
