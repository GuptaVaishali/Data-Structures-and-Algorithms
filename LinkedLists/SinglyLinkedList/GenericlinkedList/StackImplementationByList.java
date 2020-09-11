package GenericLinkedList;

class Stack<E>{

	private SLinkedList<E> ll = new SLinkedList<>();
	
	void push(E val) throws Exception {
		
		ll.insert(ll.getSize(),val);
	}
	
	void display() {
		ll.display();
	}
	
	E pop() throws Exception {
		if(ll.isEmpty())
			throw new Exception("Stack is empty");
		return  ll.delete(ll.getSize()-1);
	}
	
	E peek() throws Exception {
		if(ll.isEmpty())
			throw new Exception("Stack is empty");
		return ll.get(ll.getSize()-1);
	}
	
	E peep(int index) throws Exception {
		if(ll.isEmpty())
			throw new Exception("Stack is empty");
		return ll.get(index);
	}
	
}

public class StackImplementationByList {

	public static void main(String args[]) {
		
		Stack<Integer> s = new Stack<>();
		
		Stack<String> s1= new Stack<>();
		try {
		//	s.pop();
			s.push(4);
			s.push(5);
			s.push(6);
			s.display();
			
			s1.push("vaishali");
			s1.push("tanya");
			
			s1.display();
			
			System.out.println("peeped value " + s1.peep(1));
			System.out.println("popping value " + s.pop());
			
			s.display();
			
			System.out.println("peeked value " + s.peek());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
