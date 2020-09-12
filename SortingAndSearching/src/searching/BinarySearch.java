package searching;

import java.util.*;

class BSearch {
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
	}
	
	int bsearch(int val) {
		int index=-1;
		int low=0,high=n-1;
		while(low<=high) {
			int mid=(low+high)/2;
			if(a[mid]==val)
				return mid;
			else if(val<a[mid])
				high=mid-1;
			else
				low=mid+1;
		}
		return index;
	}
	
	int recursiveBSearch(int val,int low,int high) {
		if(low<=high) {
			int mid=(low+high)/2;
			if(a[mid]==val)
				return mid;
			else if(val<a[mid])
				return recursiveBSearch(val,low,mid-1);
			else if(val>a[mid])
				return recursiveBSearch(val,mid+1,high);
		}
		return -1;
	}
	
}


public class BinarySearch {

	public static void main(String[] args) {
		
		BSearch ob =new BSearch();
		ob.input();
		System.out.println("Enter Value to be found");
		Scanner s = new Scanner(System.in);
		int val=s.nextInt();
//		int index=ob.bsearch(val);
		int  index=ob.recursiveBSearch(val,0,ob.n-1);
		s.close();
		if(index==-1) {
			System.out.println("Value not found");
		}
		else {
			System.out.println("Value found at " + index + " index");
		}
		
	}

}
