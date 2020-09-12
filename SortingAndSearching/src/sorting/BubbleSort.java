package sorting;

import java.util.Scanner;

public class BubbleSort {

	static int[] bubblesort(int a[],int n) {
		for(int i=0;i<n-1;i++) {
			boolean issorted=true;
			for(int j=0;j<n-i-1;j++) {
				if(a[j]>a[j+1]) {
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
					issorted=false;
				}
			}
			if(issorted)
				break;
		}
		return a;
	}
	
	public static void main(String[] args) {

		System.out.println("Enter Number Of Elements of array");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		System.out.println("Enter elements of array");
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		sc.close();
		int b[]= bubblesort(a,n);
		System.out.println("After Bubble Sorting");
		for(int i=0;i<n;i++) {
			System.out.print(b[i]+" ");
		}
	}

}
