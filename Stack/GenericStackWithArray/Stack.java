package genericStackWithArray;

public class Stack<T> {
	int top;
	int length;
	T a[];
	
	@SuppressWarnings("unchecked")
	public Stack(int length){
		top=-1;
		this.length=length;
		a=(T[])new Object[length];
	}
	
	public boolean isEmpty() {
		if(top==-1) return true;
		else return false;
	}
	
	public int getSize() {
		return top+1;
	}
	
	public void push(T val)throws Exception {
		if(top >= length-1) {
			throw new Exception("Stack is full");
		}
			a[++top]=val;
	}
	
	public T pop()throws Exception {
		if(top==-1) {
			throw new Exception("Stack is Empty");
		}
			T val=a[top--];
			return val;
	}
	
	public T peek()throws Exception {
		if(top==-1 || top > length-1) {
			throw new Exception("Stack is Empty");
		}
			T val=a[top];
			return val;
	}
	
	public T peep(int index) throws Exception {
		if(index<0 || index > top) {
			throw new Exception("Stack is Empty");
		}
			return a[top-index];
	}
	
	public void display() {
		for(int i=0;i<=top;i++) {
			System.out.println(a[i]);
		}
	}
}

