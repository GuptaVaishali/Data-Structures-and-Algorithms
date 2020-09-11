package stackQuestions;

import java.util.Scanner;

import genericStackWithArray.Stack;

public class Gcd {
	
	static int gcd(int m, int n) throws Exception {
		Stack<Integer> s1 = new Stack<>(1);
		Stack<Integer> s2 = new Stack<>(1);
		s1.push(m);
		s2.push(n);
		while(!(s1.isEmpty())) {
			m=s1.pop();
			n=s2.pop();
			if(m%n!=0) {
				s1.push(n);
				s2.push(m%n);
			}
		}
		return n;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter two numbers");
		int a=sc.nextInt();
		int b=sc.nextInt();
		try {
			System.out.println("gcd is = " + gcd(a, b));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
