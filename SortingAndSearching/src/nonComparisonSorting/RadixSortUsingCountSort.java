package nonComparisonSorting;

import java.util.Scanner;

class RadixSort {
	int n,a[];
	private Scanner sc;
	
	RadixSort(){}
	
	RadixSort(int n){
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
	
	void Csort(int j) {
		int count[]=new int[10];
		int b[]=new int[n];
		
		for(int i=0;i<n;i++) {
			count[(int) ((a[i]/Math.pow(10,j))%10)]++;
		}
		for(int i=1;i<10;i++) {
			count[i]+=count[i-1];
		}
		
		for(int i=n-1;i>=0;i--) {
			b[--count[(int) ((a[i]/Math.pow(10,j))%10)]]=a[i];
		}
		for(int i=0;i<n;i++) {
			a[i]=b[i];
		}
	}
	
	void radixSort() {
		double max=getMax();
		int d=(int) (Math.log10(max)+1);
		System.out.println("digits " + d);
		for(int i=0;i<d;i++) {
			Csort(i);
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

public class RadixSortUsingCountSort {

	public static void main(String[] args) {
		
		RadixSort r= new RadixSort();
		r.input();
		r.inputArray();
		r.radixSort();
		r.display();
	}

}
