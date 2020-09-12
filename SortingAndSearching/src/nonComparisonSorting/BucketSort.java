package nonComparisonSorting;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

class BSort {
	
	int n;
	double a[];
	private Scanner sc;
	
	BSort(){}
	
	BSort(int n){
		this.n=n;
		a=new double[n];
	}
	
	void input() {
		sc = new Scanner(System.in);
		System.out.println("Enter No of Elements of Array");
		n=sc.nextInt();
		a=new double[n];
	}
	
	void inputArray() {
		System.out.println("Enter Elements of array");
		for(int i=0;i<n;i++)
			a[i]=sc.nextDouble();
	}
	
	void BucketSort() {
		LinkedList<Double> b[]=new LinkedList[n];
		for(int i=0;i<n;i++) 
			b[i]=new LinkedList<>();
		for(int i=0;i<n;i++) {
			b[(int) (a[i]*n)].add(a[i]);
		}
		
		for(int i=0;i<n;i++) {
			Collections.sort(b[i]);
		}
		int k=0;
		for(int i=0;i<n;i++) {
			while(!b[i].isEmpty()) {
				a[k++]=b[i].remove();
			}
		}
	}
	
	void display() {
		System.out.println("After Radix Sort...Sorted Array is");
		for(int i=0;i<n;i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
}

public class BucketSort {

	public static void main(String[] args) {
		
		BSort b = new BSort();
		b.input();
		b.inputArray();
		b.BucketSort();
		b.display();
	}

}
