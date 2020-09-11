package stackQuestions;

import java.util.Scanner;
import genericStackWithArray.Stack;

	
public class ExpressionEval {
	
	static boolean isOperator(String op) {
		if(op.equals("+") ||op.equals("-") || op.equals("*") || op.equals("/")|| op.equals("%"))
			return true;
		else
			return false;
	}
	
	static int evaluate(String s)throws Exception {
			int n=s.length();
			Stack<Integer> stck = new Stack<>(n);
			String exp[]= s.split(",");
			for(int i=0;i<exp.length;i++) {
				if(isOperator(exp[i])==false) {
					stck.push(Integer.parseInt(exp[i]));
				}
				else {
					int b=stck.pop();
					int a=stck.pop();
					String op= exp[i];
					int res=0;
					switch(op) {
					case "+" : res=a+b;
								break;
					case "-" : res=a-b;
								break;
					case "*" : res=a*b;
								break;
					case "/" : res=a/b;
								break;
					case "%" : res=a%b;
								break;
					}
					stck.push(res);
				} 
			} 
			int val=stck.pop();  
			return val; 
		}  
	

	public static void main(String[] args) {
		ExpressionEval eval = new ExpressionEval();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Expression in comma seperated form(for ex.'4,2,-')");
		String expression = sc.nextLine();
		
		try {
			System.out.println("value = " + eval.evaluate(expression));
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}

}
