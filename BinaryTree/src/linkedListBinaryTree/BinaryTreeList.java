package linkedListBinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BNode{
	char data;
	BNode left,right;
	
	BNode() { }
	
	BNode(char data) {
		this.data=data;
		left=right=null;
	}
}

public class BinaryTreeList {
	BNode root;
	BinaryTreeList(){
		root=null;
	}
	
	void build(BNode cur,BNode p) {
		if(cur==null) {
			cur=root=new BNode();
			System.out.println("Enter data of root node");
		}
		else if(cur==p.left) {
			System.out.println("Enter data of left child of parent node " + p.data);
		}
		else {
			System.out.println("Enter data of right child of parent node " + p.data);
		}
		try (Scanner sc = new Scanner(System.in)) {
			cur.data=sc.next().charAt(0);
			
			System.out.println("Does cur node "+ cur.data +" has left child");
			char ans=sc.next().charAt(0);
			if(ans=='y') {
				cur.left=new BNode();
				p=cur;
				BNode cur1;
				cur1=p.left;
				build(cur1,p);
			}
			
			System.out.println("Does cur node " + cur.data + " has right child");
			char ans1=sc.next().charAt(0);
			if(ans1=='y') {
				cur.right=new BNode();
				p=cur;
				BNode cur1;
				cur1=p.right;
				build(cur1,p);
			}
		}
	}
	
	void preorder(BNode root) {
		BNode cur=root;
		if(cur!=null)
			System.out.println(cur.data);
		if(cur.left!=null) {
			preorder(cur.left);
		}
		if(cur.right!=null) {
			preorder(cur.right);
		}
	}
	
	void inorder(BNode root) {
		BNode cur=root;
		if(cur.left!=null) {
			inorder(cur.left);
		}
		if(cur!=null)
			System.out.println(cur.data);
		if(cur.right!=null) {
			inorder(cur.right);
		}
	}
	
	void postorder(BNode root) {
		BNode cur=root;
		if(cur.left!=null) {
			postorder(cur.left);
		}
		if(cur.right!=null) {
			postorder(cur.right);
		}
		if(cur!=null)
			System.out.println(cur.data);
	}
	
	void levelorder(BNode root) {
		Queue<BNode> q= new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			BNode cur = q.remove();
			System.out.println(cur.data);
			if(cur.left!=null)
				q.add(cur.left);
			if(cur.right!=null)
				q.add(cur.right);
		}
	}
	
	int getHeight(BNode root) {
		int hl=1,hr=1;
		if(root.left!=null) {
			hl= getHeight(root.left)+1;
		}
		if(root.right!=null) {
			hr = getHeight(root.right)+1;	
		}
		
		if(hr>hl) 
			return hr;
		else
			return hl;
	}
	
	BNode search(BNode root,char key) {
		if(root.data==key) return root;
		if(root.left!=null) {
			if(search(root.left,key)!=null)
				return search(root.left,key);
		}
		if(root.right!=null) {
			if(search(root.right,key)!=null)
				return search(root.right,key);
		}
		return null;
	}
	
	void insert(char tosearch,char key) {
		BNode index=search(root,tosearch);
	//	System.out.println("insert function before if " + index);
		if(index==null)
			return;
		
	//	System.out.println("insert function after if "+index.data + " " + index);
		try (Scanner sc = new Scanner(System.in)) {
			if(index.left!=null && index.right!=null) {
				System.out.println("insertion not possible");
			}
				
			if(index.left==null && index.right==null) {
				System.out.println("Do you want to insert left child");
				char ans=sc.next().charAt(0);
				if(ans=='y') 
					index.left=new BNode(key);
				else 
					index.right=new BNode(key);

			}
			else if(index.left==null) 
				index.left=new BNode(key);

			else
				index.right=new BNode(key);
		}
	}
	
	void delete(char key) {
		BNode cur = search(root,key);
	//	System.out.println("before if " + cur+ "  " + cur.data);
		if(cur==null)
			return;
	//	System.out.println("after if " + cur+ "  " + cur.data);
		if(cur.left==null && cur.right==null) {
	//		System.out.println("it is leaf");
			cur.data='\0';
			cur=null;
	//		System.out.println("it is leaf after");
		}
		else
			System.out.println("Node is not leaf node");
	}
}
