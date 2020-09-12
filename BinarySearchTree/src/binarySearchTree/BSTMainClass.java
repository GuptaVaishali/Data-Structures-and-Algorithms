package binarySearchTree;

public class BSTMainClass {

	public static void main(String[] args) {
		BST bt = new BST();
		System.out.println("BST Insertion");
		bt.insert(9);
		bt.insert(4);
		bt.insert(2);
		bt.insert(11);
		bt.insert(13);
		bt.insert(5);
		bt.insert(7);
		bt.insert(10);
		bt.insert(1);
		bt.levelorder();
		
		System.out.println("BST Deletion");
		bt.deletion(11);
		bt.levelorder();
	}

}
