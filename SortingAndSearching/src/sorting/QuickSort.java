package sorting;

import java.util.Scanner;

class QSort {
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
	
	void quickSort(int low,int high) {
		if(low<high) {
			int p = partition(low,high);
			quickSort(low,p-1);
			quickSort(p+1,high);
		}
	}
	
	int partition(int low,int high) {
		int pe = a[low];
		int j=low;
		for(int i=j+1;i<=high;i++) {
			if(a[i] < pe) {
				j++;
				if(i!=j) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp; 
				}
			}
		}
		int pp=j;
		if(low!=pp) {
			int temp=a[low];
			a[low]=a[pp];
			a[pp]=temp;
		}
		return pp;
	}
	
	void display() {
		System.out.println("After Quick Sort..Sorted Array is");
		for(int i=0;i<n;i++) {
			System.out.println(a[i]+ " ");
		}
		System.out.println();
	}
	
}

public class QuickSort {

	public static void main(String[] args) {
		
		QSort ob = new QSort();
		ob.input();
		ob.quickSort(0, ob.n-1);
		ob.display();
	}

}
