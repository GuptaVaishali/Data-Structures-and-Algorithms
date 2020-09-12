package sorting;

import java.util.Scanner;

class QSort2 {
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
	
	void swap(int i,int j) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
	int partition(int low,int high) {
		int pe=a[low];
	//	int pp=low;
		int start=low;
		int end=high;
		System.out.println("pe = " + pe + "  start "+start+"  end= "+end);
		while(start<end) {
			System.out.println("inside while loop = " + start+ " end= "+end);
			while(start<n && a[start] <= pe)
				start++;
			System.out.println("inside while start = " + start+ " end= "+end);
			while(a[end] > pe)
				end--;
			System.out.println("inside while end = " + start + " end= "+end);
			if(start<end) 
				swap(start,end);
			System.out.println("while loop end");
			
		}
		if(low!=end) {
			swap(low,end);
		}
		return end;
	}
	
	void display() {
		System.out.println("After Quick Sort..Sorted Array is");
		for(int i=0;i<n;i++) {
			System.out.println(a[i]+ " ");
		}
		System.out.println();
	}
	
}


public class QuickSort2 {

	public static void main(String[] args) {
		QSort2 ob = new QSort2();
		ob.input();
		ob.quickSort(0, ob.n-1);
		ob.display();

	}

}
