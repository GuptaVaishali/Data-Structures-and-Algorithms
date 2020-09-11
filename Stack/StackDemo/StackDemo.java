package stack;

class Stack{
	
	int top;
	int length;
	int a[];
	
	Stack(){
		top=-1;
		length=5;
		a=new int[length];
	}
	
	boolean isEmpty() {
		if(top==-1) return true;
		else return false;
	}
	
	int getSize() {
		return top+1;
	}
	
	void push(int val)throws Exception {
		if(top >= length-1) {
			throw new Exception("Stack is full");
		}
			a[++top]=val;
	}
	
	int pop()throws Exception {
		if(top==-1) {
			throw new Exception("Stack is Empty");
		}
			int val=a[top--];
			return val;
	}
	
	int peek()throws Exception {
		if(top==-1 || top > length-1) {
			throw new Exception("Stack is Empty");
		}
			int val=a[top];
			return val;
	}
	
	int peep(int index) throws Exception {
		if(index<0 || index > top) {
			throw new Exception("Stack is Empty");
		}
			return a[top-index];
	}
	
	void display() {
		for(int i=0;i<=top;i++) {
			System.out.println(a[i]);
		}
	}
}


public class StackDemo {

	public static void main(String[] args) {
		Stack s = new Stack();
		System.out.println(s.isEmpty());
		
		try {
		s.push(3);
		s.push(5);
		s.push(7);
		s.push(8);
		s.push(9);
		
		s.display();
		
	//	s.push(2);  // stack is full here
	//	s.display();
		
		System.out.println("peeked value" + s.peek());
		
		System.out.println("pop value " + s.pop());
		System.out.println("pop value " + s.pop());
		
		System.out.println("peeked value " + s.peek());
		
		System.out.println("pop value " + s.pop());
		
		System.out.println("peeped value " + s.peep(1));
		
		System.out.println("pop value " + s.pop());
		System.out.println("pop value " + s.pop());
		System.out.println("pop value " + s.pop()); 
		
		s.display();
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
