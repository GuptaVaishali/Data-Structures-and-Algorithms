package binaryTree;

import java.util.*;

public class BinaryTreeRepresentation {
	int n;
	char a[];
	
	BinaryTreeRepresentation(int h){
		n= (int) (Math.pow(2,h))-1;
		a=new char[n];
	}
	
	void build(int i) {
		if(i==0) {
			System.out.println("Enter root node value");
		}
		else if(i%2!=0) {
			System.out.println("Enter value of left node of " + (i-1)/2);
		}
		else if(i%2==0) {
			System.out.println("Enter value of right node of " + (i-1)/2);
		}
		
		Scanner sc=new Scanner(System.in);
		a[i]=sc.next().charAt(0);
		
		System.out.println("Does node " + i + " has left child" );
		char ch=sc.next().charAt(0);
		
		if(ch=='y' && 2*(i+1)-1<n) {
			build(2*(i+1)-1);
		}
		
		System.out.println("Does node " + i + " has right child" );
		char ch1=sc.next().charAt(0);
		
		if(ch1=='y' && 2*(i+1)<n) {
			build(2*(i+1));
		}
		
	}
	
	void display() {
		for(int i=0;i<n;i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	} 
	
	void preorder(int i) {
		if(a[i]!='\0')	
			System.out.println(a[i]);
		if(2*(i+1)-1< n && a[2*(i+1)-1] !='\0') {
			preorder(2*(i+1)-1);
		}
		if(2*(i+1)< n && a[2*(i+1)] !='\0') {
			preorder(2*(i+1));
		}
	}
	
	void inorder(int i) {
		if(2*(i+1)-1< n && a[2*(i+1)-1] !='\0') {
			inorder(2*(i+1)-1);
		}
		if(a[i]!='\0')	
			System.out.println(a[i]);
		if(2*(i+1)< n && a[2*(i+1)] !='\0') {
			inorder(2*(i+1));
		}
	}
	
	void postorder(int i) {
		if(2*(i+1)-1< n && a[2*(i+1)-1] !='\0') {
			postorder(2*(i+1)-1);
		}
		if(2*(i+1)< n && a[2*(i+1)] !='\0') {
			postorder(2*(i+1));
		}
		if(a[i]!='\0')					//if root is null
			System.out.println(a[i]);
	}
	
	
	void levelorder(int i) {
		Queue<Integer> q= new LinkedList<>();
		if(a[0]=='\0') return;
		q.add(0);
		while(!q.isEmpty()) {
			i=q.remove();
			System.out.println(a[i]);
			if(2*(i+1)-1 < n && a[2*(i+1)-1] != '\0') {
				q.add(2*(i+1)-1);
			}
			if(2*(i+1) < n && a[2*(i+1)] != '\0') {
				q.add(2*(i+1));
			}
		}
	}
	
	int search(int i,char key) {
		if(a[0]=='\0') return -1;
		if(a[i]==key) {
			return i;
		}
		if(2*(i+1)-1 <n && a[2*(i+1)-1]!='\0') {
			int index=search(2*(i+1)-1,key);
			if(index>0)
				return index;
		}
		if(2*(i+1)<n && a[2*(i+1)]!='\0') {
			int index=search(2*(i+1),key);
			if(index>0)
				return index;
		}
		return -1;
	}
	
	void insert(char key,char val) throws Exception {
		int i=search(0,key);
		if(i==-1)
			throw new Exception("key not found");
		
		if(2*(i+1)-1 > n)
			throw new Exception("No space to insert value");

		if(a[2*(i+1)-1]!='\0' && a[2*(i+1)]!='\0')
			throw new Exception("Both left and right child exist already");
		
		if(a[2*(i+1)-1]=='\0' && a[2*(i+1)]=='\0') {
			Scanner sc=new Scanner(System.in);
			System.out.println("Do you want to insert at left");
			char ans=sc.next().charAt(0);
			if(ans=='y') 
				a[2*(i+1)-1]=val;
			else
				a[2*(i+1)]=val;
		}
		else if(a[2*(i+1)-1]=='\0') 
			a[2*(i+1)-1]=val;
		else
			a[2*(i+1)]=val;
	}
	
	void delete(char key) throws Exception {
		int i=search(0,key);
		if((2*(i+1)-1 < n) && (a[2*(i+1)-1]!='\0' || a[2*(i+1)]!='\0'))
			throw new Exception("it is not a leaf node");
		else
			a[i]='\0';
	}
}
