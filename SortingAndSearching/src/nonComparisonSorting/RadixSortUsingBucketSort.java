package nonComparisonSorting;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

class RBSort {
	int n;
	int a[];
	private Scanner sc;
	
	RBSort(){}
	
	RBSort(int n){
		this.n=n;
		a=new int[n];
	}
	
	void input() {
		sc = new Scanner(System.in);
		System.out.println("Enter No of Elements of Array");
		n=sc.nextInt();
		a=new int[n];
	}
	
	void inputArray() {
		System.out.println("Enter Elements of array");
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
	}
	
	double getMax() {
		double max=a[0];
		for(int i=1;i<n;i++) {
			if(a[i] > max) {
				max=a[i];
			}
		}
		return max;
	}
	
	void BSort(int j,LinkedList<Integer> b[]) {
		for(int i=0;i<n;i++) {
			b[(int) ((a[i]/Math.pow(10, j))%10)].add(a[i]);
		}
		int k=0;
		for(int i=0;i<10;i++) {
			while(!b[i].isEmpty()) {
				a[k++]=b[i].remove();
			}
		}
	}
	
	void radixSort() {
		double max=getMax();
		int d=(int) (Math.log10(max)+1);
		System.out.println("digits " + d);
		
		LinkedList<Integer> b[]=new LinkedList[10];
		for(int i=0;i<10;i++) 
			b[i]=new LinkedList<>();
		
		for(int i=0;i<d;i++) {
			BSort(i,b);
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


public class RadixSortUsingBucketSort {

	public static void main(String[] args) {
		RBSort rb = new RBSort();
		rb.input();
		rb.inputArray();
		rb.radixSort();
		rb.display();

	}

}
