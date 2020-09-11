package stackQuestions;

import java.util.Scanner;

import genericStackWithArray.Stack;

public class ParanthesisBalancing {

	static boolean paranBalancing(String exp) throws Exception {
		Stack<Character> s= new Stack<>(exp.length());
		for(int i=0;i<exp.length();i++) {
			char ch=exp.charAt(i);
			switch(ch) {
				case '{':
				case '[':
				case '(': s.push(ch);
							break;
				case ')': if(s.isEmpty()) return false;
							if(s.pop() != '(')
								return false;
							break;
				case ']': if(s.isEmpty()) return false;
							if(s.pop() != '[')
								return false;
							break;
				case '}': if(s.isEmpty()) return false;
							if(s.pop() != '{')
								return false;
							break;
			
			}
		}
		if(s.isEmpty())
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the bracket expression");
		String expression=sc.next();
		try {
			boolean isBalanced=paranBalancing(expression);
			if(isBalanced) 
				System.out.println("paranthesis are balancing");
			else
				System.out.println("paranthesis are not balancing");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
