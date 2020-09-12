package searching;

import java.util.Scanner;

class Tsearch {
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
	
	int tsearch(int val) {
		int l=0,r=n-1;
		while(l<=r) {
			int mid1 = l+(r-l)/3;
			int mid2 = mid1+(r-l)/3;
			if(val==a[mid1])
				return mid1;
			else if(val==a[mid2])
				return mid2;
			else if(val<a[mid1])
				r=mid1-1;
			else if(val>a[mid2])
				l=mid2+1;
			else {
				l=mid1+1;
				r=mid2-1;
			}
		}
		return -1;
	}
}

public class TernarySearch {

	public static void main(String[] args) {
		
		Tsearch ob =new Tsearch();
		ob.input();
		System.out.println("Enter Value to be found");
		Scanner s = new Scanner(System.in);
		int val=s.nextInt();
		int index=ob.tsearch(val);
		s.close();
		if(index==-1) {
			System.out.println("Value not found");
		}
		else {
			System.out.println("Value found at " + index + " index");
		}
	}

}
