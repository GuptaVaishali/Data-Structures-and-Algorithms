package sorting;

import java.util.*;

public class SelectionSort {
	static int a[],n;
	
	static void input() {
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
	
	static void selectionSort() {
		for(int i=0;i<n-1;i++) {
			int min=i;
			for(int j=i+1;j<n;j++) {
				if(a[j]<a[min]) {
					min=j;
				}
			}
			if(i!=min) {
				int temp=a[i];
				a[i]=a[min];
				a[min]=temp;
			}
		}
	}
	
	static void display() {
		System.out.println("After Selection Sort..Sorted Array is");
		for(int i=0;i<n;i++) {
			System.out.println(a[i]+ " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		input();
		selectionSort();
		display();
	}

}
