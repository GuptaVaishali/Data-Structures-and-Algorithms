package sorting;

import java.util.Scanner;

class InsertionClass {
	
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
	
	void insertionSort() {
		for(int i=1;i<n;i++) {
			int j=i-1;int temp=a[i];
			while(j>=0 && a[j]>temp) {
				a[j+1]=a[j];
				j=j-1;
			}
			a[j+1]=temp;
		}
	}
	
	void display() {
		System.out.println("After Insertion Sort..Sorted Array is");
		for(int i=0;i<n;i++) {
			System.out.println(a[i]+ " ");
		}
		System.out.println();
	}
}

public class  InsertionSort{
	public static void main(String[] args) {
		
		InsertionClass ob=new InsertionClass();
		ob.input();
		ob.insertionSort();
		ob.display();
	}
}
