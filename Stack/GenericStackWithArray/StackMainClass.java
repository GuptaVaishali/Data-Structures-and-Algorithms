package genericStackWithArray;

public class StackMainClass {

	public static void main(String[] args) {
		Stack<String> s = new Stack<>(10);
		System.out.println(s.isEmpty());
		
		try {
//		s.push(3);  //for integer
//		s.push(5);
//		s.push(7);
//		s.push(8);
//		s.push(9);
		
		s.push("vaishali");
		s.push("tanya");
		s.push("ritika");
		s.push("shikha");
	//	s.push(9);
		
		s.display();
		
	//	s.push(2);  // stack is full here
	//	s.display();
		
		System.out.println("peeked value " + s.peek());
		
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
