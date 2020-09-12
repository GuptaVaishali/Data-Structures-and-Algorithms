package linkedListBinaryTree;

public class BinaryTreeListMainClass {

	public static void main(String[] args) {
		BinaryTreeList t = new BinaryTreeList();
		t.build(null, null);
		System.out.println("Preorder operation");
		t.preorder(t.root);
		System.out.println("Inorder operation");
		t.inorder(t.root);
		System.out.println("Postorder operation");
		t.postorder(t.root);
		System.out.println("levelorder operation");
		t.levelorder(t.root);
		System.out.println("Finding Height operation");
		int h= t.getHeight(t.root);
		System.out.println("Height= " + h);
		
		System.out.println("Search operation");
		BNode i = t.search(t.root, 'C');
		System.out.println("in main  " + i+ "  "  +i.data);
		
		System.out.println("Insert operation");
		t.insert( 'C', 'E');
		
		System.out.println("levelorder operation");
		t.levelorder(t.root);
		
		System.out.println("Delete operation");
		t.delete('B');
		
		System.out.println("levelorder operation");
		t.levelorder(t.root);
		
	}

}
