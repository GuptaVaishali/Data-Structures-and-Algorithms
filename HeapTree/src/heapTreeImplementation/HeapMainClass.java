package heapTreeImplementation;

public class HeapMainClass {

	public static void main(String[] args) {
		HeapTree h = new HeapTree(6);
		System.out.println("Building Max Heap");
		h.buildMaxHeap();
		h.display();
		System.out.println("Insertion in Max Heap Tree");
		h.insertion(5);
		h.insertion(7);
//		h.insertion(4);
//		h.insertion(6);
		System.out.println("size= " + h.size());
		System.out.println("Displaying Max Heap Tree");
		h.display();
		
		System.out.println("Deletion from Max Heap Tree");
		int delval=h.delete();
		System.out.println("deleted value = " + delval);
		
		System.out.println("size= "+ h.size());
		System.out.println("Displaying Max Heap Tree");
		h.display();
		
		System.out.println("Heap Sort");
		h.HeapSort();
		h.display();
		
	}

}
