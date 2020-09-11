import java.util.Scanner;

class ArrayTest {
	int size;
	int a[];
	int length;
	
	ArrayTest(int length){
		this.size=0;
		this.length=length;
		a=new int[length];
	}
	
	boolean isEmpty() {
		if(size==0) return true;
		else return false;
	}
	
	int size() {
		return size;
	}
	
	void add(int index,int val)throws Exception {
		if(index<0 || index>size) {
			throw new Exception("Array index out of bound");
		} 
		else {
		for(int i=size-1;i>=index;i--) {
			a[i+1]=a[i];
		}
		a[index]=val;
		size++;
		}
	}
	
	int delete(int index)throws Exception {
		if(index<0 || index>=size) {
			throw new Exception("Array index out of bound");
		} 
		else { 
		int val=a[index];
		for(int i=index+1;i<size;i++) {
			a[i-1]=a[i];
		}
		a[size-1]=0;
		size--;
		return val;
		}
	}
	
	void print() {
		for(int i=0;i<size;i++) {
			System.out.print(a[i]+ "  ");
		}
		System.out.println();
	}
}
class ArrayMain{
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter length of array");
		int length=sc.nextInt();
		sc.close();
	//	System.out.println("Enter size of array");
	//	int size=sc.nextInt();
		ArrayTest a1= new ArrayTest(length);
		System.out.println(a1.isEmpty());
		
		try {
			a1.add(0, 45);
		a1.add(1, 10);
		a1.add(2, 5);
		a1.print();
		System.out.println(a1.size());
		a1.add(1, 24);
		a1.print();
		a1.add(0, 8);
		a1.print();
		a1.add(4, 89);
		a1.print();
		a1.add(6, 90);
		a1.print();
	}catch (Exception e1) {
		//e1.printStackTrace();
		System.out.println("Array Index out of bound Exception in add operation");
	}
		
		try {
			System.out.println(a1.delete(2));
		a1.print();
		System.out.println(a1.delete(0));
		a1.print();
		System.out.println(a1.delete(a1.size()-1));
		a1.print();
		System.out.println(a1.delete(a1.size()));
		a1.print();
		}catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Array Index out of bound Exception in delete operation");
		}
		
	}
}
