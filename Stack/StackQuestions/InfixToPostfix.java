package stackQuestions;

import java.util.Scanner;

import genericStackWithArray.Stack;

public class InfixToPostfix {
	
	static int precedence(char op) {
		if(op=='/' || op=='*' || op=='%')
			return 3;
		else if(op=='+' || op=='-')
			return 2;
		else
			return 1;
	}
	
	static boolean isOperator(char c) {
		if(c=='+' || c== '-' || c== '*' || c=='/' || c=='%')
			return true;
		else
			return false;
	}

	static String infixToPostfix(String infix) throws Exception {
		String p="";
		Stack<Character> s= new Stack<>(infix.length());
		s.push('(');
		infix=infix+')';
		
		for(int i=0;i<infix.length();i++) {
			char ch=infix.charAt(i);
			if(ch=='(')
				s.push(ch);
			
			else if(ch==')') {
				while(s.peek()!='(') {
					p=p+s.pop();
				}
			}
			
			else if(! isOperator(ch)) {
				p=p+ch;
			}
			else {
				if(isOperator(s.peek()) && precedence(s.peek()) >= precedence(ch) ) {
					p=p+s.pop();
				}
				s.push(ch);
			}
		}
		return p;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the infix operation");
		String expression=sc.next();
	//	String expression= "A+B*C";
		
		try {
			String postfix= infixToPostfix(expression);
			System.out.println(postfix);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
