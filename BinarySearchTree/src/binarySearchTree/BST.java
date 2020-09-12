package binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;


class Bnode{
	int data;
	Bnode left,right;
	
	Bnode() { }
	
	Bnode(int data){
		this.data=data;
		left=right=null;
	}
}

public class BST {
	Bnode root;
	BST(){
		root=null;
	}
	
	void insert(int x) {
		if(root==null) {
			root=new Bnode(x);
			return;
		}
		Bnode p=null,cur=root;
		while(cur!=null) {
			p=cur;
			if(x<cur.data) 
				cur=cur.left;
			
			else if(x==cur.data) {
				System.out.println("x " + x + " already exists");
				break;
			}
			
			else 
				cur=cur.right;
		}
		
		if(x<p.data) 
			p.left=new Bnode(x);
		else 
			p.right=new Bnode(x);
	}
	

	void levelorder() {
		Queue<Bnode> q= new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			Bnode cur = q.remove();
			System.out.println(cur.data);
			if(cur.left!=null)
				q.add(cur.left);
			if(cur.right!=null)
				q.add(cur.right);
		}
	}
	
	void deletion(int val) {
		System.out.println("inside deletion");
		Bnode cur=root,p=null;
		while( cur!=null && cur.data!=val) {
			System.out.println("inside while loop " + cur.data);
			p=cur;
			if(val<cur.data) {
				cur=cur.left;
				System.out.println("inside while if statement " + cur.data + p.data);
			}
			else {
				System.out.println("else " + p.data);
				cur=cur.right;
				System.out.println("inside while else statement " + p.data);
			}
		}
		
		if(cur==null) {									//key does not exist
			System.out.println("value does not exist");
			return;
		}
		
		if(cur.left==null && cur.right==null) {			//key has no child
			System.out.println("inside outside if statement");
			if(cur==p.left)
				p.left=null;
			else {
				System.out.println("p right");
				p.right=null;
			}
		}
		
		if(cur.left==null || cur.right==null) {		//key has one child only
			if(cur==p.left) {
				if(cur.left!=null) {
					p.left=cur.left;
					cur.left=null;
				}
				else {
					p.left=cur.right;
					cur.right=null;
				}
			}
			else {
				if(cur.left!=null) {
					p.right=cur.left;
					cur.left=null;
				}
				else {
					p.right=cur.right;
					cur.right=null;
				}
			}
		}
		
		else {						//when key node has two childs
			Bnode temp=cur.right;
			Bnode parent=null;
			while(temp.left!=null) {
				parent =temp;
				temp=temp.left;
			}
			cur.data=temp.data;
			if(parent!=null) {
				parent.left=temp.right;
			}
			else
				cur.right=temp.right;
			temp=null;
		}
	}
}
