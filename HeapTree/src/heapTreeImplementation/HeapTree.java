package heapTreeImplementation;

import java.util.Scanner;

public class HeapTree {
	int a[];
	int n;
	int capacity;
	
	HeapTree(int n){
		this.n=n;
		capacity=15;
		a=new int[capacity];
		System.out.println("Enter a array");
		try (Scanner sc = new Scanner(System.in)) {
			for(int i=0;i<n;i++) {
				a[i]=sc.nextInt();
			}
		}
	}
	
	void insertion(int val) {
		int i=n;
		a[i]=val;
		while(i>0 && a[(i-1)/2]<a[i]) {
			int temp=a[i];
			a[i]=a[(i-1)/2];
			a[(i-1)/2]=temp;
			i=(i-1)/2;
		}
		a[i]=val;
		n++;
	}
	
	void display() {
		for(int i=0;i<n;i++) {
			System.out.print(a[i]+ " ");
		}
		System.out.println();
	}
	
	int delete() {
		int val=a[0];
		a[0]=a[n-1];
//		System.out.println("val = " + val + "a[0]= "+ a[0] + " before heapify");
		MaxHeapify(0,n-1);
//		System.out.println("after heapify");
		n--;
		return val;
	}
	
	int size() {
		return n;
	}
	
	void MaxHeapify(int i,int n) {
		while(i<n-1) {
//			System.out.println(i);
			int left=2*(i+1)-1;
			int right=2*(i+1);
//			System.out.println(i + " " + left + " " + right);
			if(left>=n && right>=n)          // if i node is a leaf..that is no left and right child
				break;
			int max=i;
			
			if(right>=n && left<n)			// if there is no right child.. only left child
				max=left;
//			System.out.println("before max left "+ a[left] + " " + a[right]);
			if(left< n && a[left] > a[right]) {
//				System.out.println("max left "+ a[left] + " " + a[right]);
				max=left;
				
			}
			if(right<n && a[right] >  a[left])
				max=right;
//			System.out.println("max= " + max);
			if(a[i]<a[max]) {
				int temp=a[i];
				a[i]=a[max];
				a[max]=temp;
//				System.out.println(a[i] + " " + a[max]);
			}
			else
				break;
			i=max;
		}
	}
	
	void buildMaxHeap() {
		for(int i=(n-2)/2 ; i>=0 ;i--) {
			MaxHeapify(i,n);
		}
	}
	
	void HeapSort() {
		buildMaxHeap();
//		System.out.println("After build max heap...before loop");
//		int count=0;
		for(int i=n-1;i>=1;i--) {
//			System.out.println("in loop i = " + i);
			int temp=a[i];
			a[i]=a[0];
			a[0]=temp;
			MaxHeapify(0,i);
//			System.out.println("loop over " + ++count + " time");
		}
	}
}
