package searching;

import java.util.Scanner;

class LSearch {
	int a[],n;
	
	void input() {
		System.out.println("Enter no of elements in array");
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		a=new int[n];
		System.out.println("Enter Elements of array");
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
	}
	
	int lsearch(int val) {
		int index=-1;
		for(int i=0;i<n;i++) {
			if(a[i]==val)
				return i;
		}
		return index;
	}
	
}


public class LinearSearch {

	public static void main(String[] args) {
		LSearch ob =new LSearch();
		ob.input();
		System.out.println("Enter Value to be found");
		Scanner s = new Scanner(System.in);
		int val=s.nextInt();
		int index=ob.lsearch(val);
		s.close();
		if(index==-1) {
			System.out.println("Value not found");
		}
		else {
			System.out.println("Value found at " + index + " index");
		}
	}

}
