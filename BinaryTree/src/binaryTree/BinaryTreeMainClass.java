package binaryTree;

public class BinaryTreeMainClass {

	public static void main(String[] args) {
		BinaryTreeRepresentation t= new BinaryTreeRepresentation(3);
		System.out.println("n= " + t.n);
		t.build(0);
		t.display();
		System.out.println("preorder traversal");
		t.preorder(0);
		System.out.println("inorder traversal");
		t.inorder(0);
		System.out.println("postorder traversal");
		t.postorder(0);
		System.out.println("level order traversal");
		t.levelorder(0);
		System.out.println("Search Operation");
		int index=t.search(0,'B');
		if(index==-1)
			System.out.println("Element not found");
		else
			System.out.println("Element found at index " + index);
		
		System.out.println("After Insert Operation");
		try {
			t.insert('B', 'E');
			System.out.println("preorder traversal");
			t.preorder(0);
			System.out.println("After Delete Operation");
			t.delete('D');
			System.out.println("preorder traversal");
			t.preorder(0);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
