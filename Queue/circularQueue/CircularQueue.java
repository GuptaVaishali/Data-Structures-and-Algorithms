package circularQueue;

class CQueue{
	
	int f,r,length;
	int a[];
	
	CQueue(){
		f=r=-1;
		length=5;
		a=new int[length];
	}
	
	void enqueue(int val) throws Exception {
		if((r+1) % length ==f) throw new Exception("Queue is Full");
		if(r==-1) 
			f=r=0;
		else
			r=(r+1)%length;
		a[r]=val;
	}
	
	int dequeue() throws Exception{
		if(f==-1) throw new Exception("Queue is empty");
		int val=a[f];
		if(r == f)
			r=f=-1;
		else 
			f=(f+1)%length;
		return val;
	}
	
	int getSize() {
		int size=0;
		if(f==-1) return 0;
		if(f>r)
			size=length-f+r+1;
		else
			size=r-f+1;
		return size;
	}
	
	void display() {
		for(int i=f;i<=r%length;i++) {
			System.out.println(a[i] + " ");
		}
		System.out.println();
	}
}

public class CircularQueue {

	public static void main(String[] args) {
		 CQueue cq= new  CQueue();
		 System.out.println("size " + cq.getSize());
		 try {
		 cq.enqueue(4);
		 cq.enqueue(5);
		 cq.enqueue(7);
		 cq.enqueue(8);
		 cq.display();
		 
		 System.out.println("deleted value " + cq.dequeue());
		 System.out.println("deleted value " + cq.dequeue());
		 cq.display();
		 
		 }catch(Exception e) {
			 System.out.println(e.getMessage());
		 }
	}

}
