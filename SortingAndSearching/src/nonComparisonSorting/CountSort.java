package nonComparisonSorting;

import java.util.Scanner;

class CSort {
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
		sc.close();
	}
	
	int getMax() {
		int max=a[0];
		for(int i=1;i<n;i++) {
			if(a[i] > max) {
				max=a[i];
			}
		}
		return max;
	}
	
	void Csort() {
		int k=getMax();
		int count[]=new int[k+1];
		int b[]=new int[n];
		
		for(int i=0;i<n;i++) {
			count[a[i]]++;
		}
		for(int i=1;i<=k;i++) {
			count[i]+=count[i-1];
		}
		
		for(int i=n-1;i>=0;i--) {
			b[--count[a[i]]]=a[i];
		}
		for(int i=0;i<n;i++) {
			a[i]=b[i];
		}
	}
	
	void display() {
		System.out.println("After Count Sort..Sorted Array is");
		for(int i=0;i<n;i++) {
			System.out.print(a[i]+ " ");
		}
		System.out.println();
	}
	
}

public class CountSort {

	public static void main(String[] args) {
		
		CSort ob = new CSort();
		ob.input();
		ob.Csort();
		ob.display();
	}

}
