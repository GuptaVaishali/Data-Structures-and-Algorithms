package sorting;

import java.util.Scanner;

class MSort {
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
	
	void mergeSort(int low,int high) {
		if(low<high) {
			int mid=(low+high)/2;
			mergeSort(low,mid);
			mergeSort(mid+1,high);
			merge(low,mid,high);
		}
	}
	
	void merge(int low,int mid,int high) {
		int c[]=new int[high-low+1];
		int k=0;
		int i=low;
		int j=mid+1;
		
		while(i<=mid && j<=high) {
			if(a[i]<a[j]) {
				c[k]=a[i];
				i++;
			}
			else {
				c[k]=a[j];
				j++;
			}
			k++;
		}
		
		if(i<=mid) {
			while(i<=mid) {
				c[k]=a[i];
				i++;
				k++;
			}
		}
		
		if(j<=high) {
			while(j<=high) {
				c[k]=a[j];
				j++;
				k++;
			}
		}
		
		for(int p=0;p<c.length;p++) {
			a[p+low]=c[p];
		}
			
	}
	
	void display() {
		System.out.println("After Merge Sort..Sorted Array is");
		for(int i=0;i<n;i++) {
			System.out.println(a[i]+ " ");
		}
		System.out.println();
	}
}

public class MergeSort {

	public static void main(String[] args) {
		
		MSort ob = new MSort();
		ob.input();
		ob.mergeSort(0, ob.n-1);
		ob.display();

	}

}
