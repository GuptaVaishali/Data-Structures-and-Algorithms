package GenericQueueWithArray;

class Queue<T>{
	int f,r,length;
	T a[];
	
	Queue(){
		f=r=-1;
		length=5;
		a=(T[])new Object[length];
	}
	
	boolean isEmpty() {
		if(r==-1) return true;
		else return false;
	}
	
	int getSize() {
		if(r==-1)
			return 0;
		else
			return r-f+1;
	}
	
	void enqueue(T val) throws Exception {
		if(r==length-1)
			throw new Exception("queue is full");
		if(r==-1) 
			f=r=0;
		else 
			++r;
		
		a[r]=val;
	}
	
	T dequeue() throws Exception {
		if(f==-1) {
			throw new Exception("Queue is empty");
		}
		T val=a[f];
		if(f==r) {
			f=r=-1;
		}
		else f++;
		return val;
	}
	
	void display() {
		if(r==-1) return; 
		for(int i=f;i<=r;i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}

public class GQWithArray {

	public static void main(String[] args) {
		
		Queue<Integer> q=new Queue<Integer>();
		
		try {
			q.enqueue(4);
			q.enqueue(6);
			q.enqueue(7);
			q.enqueue(8);
			q.enqueue(9);
			q.display();
			
		//	q.enqueue(45); //queue is full
			
			System.out.println("deleted value " +  q.dequeue());
			System.out.println("deleted value " +  q.dequeue());
			System.out.println("deleted value " +  q.dequeue());
			System.out.println("deleted value " +  q.dequeue());
			System.out.println("deleted value " +  q.dequeue());
			
			q.display();
			
			System.out.println(q.isEmpty());
			System.out.println("size = " + q.getSize());
			
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
	}

}
