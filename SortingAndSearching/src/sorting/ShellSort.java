package sorting;

import java.util.Scanner;

class Ssort {
	int n;
	int a[];
	private Scanner sc;
	
	Ssort(){}
	
	Ssort(int n){
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
	
	void shellSort() {
		for(int gap=n/2;gap>=1;gap/=2) {
			for(int j=gap;j<n;j++) {
				int temp=a[j];
				while(j>=gap && a[j-gap]>temp) {
					a[j]=a[j-gap];
					j=j-gap;
				}
				a[j]=temp;
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

public class ShellSort {

	public static void main(String[] args) {
	
		Ssort ss = new Ssort();
		ss.input();
		ss.inputArray();
		ss.shellSort();
		ss.display();

	}

}
