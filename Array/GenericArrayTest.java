import java.util.Scanner;

class ArrayTestG<T> {
	int size;
	T a[];
	int length;
	
	ArrayTestG(int length){
		this.size=0;
		this.length=length;
		@SuppressWarnings("unchecked")
		T[] ts = (T[])new Object[length];
		a=ts;
	}
	
	boolean isEmpty() {
		if(size==0) return true;
		else return false;
	}
	
	int size() {
		return size;
	}
	
	void add(int index,T val)throws Exception {
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
	
	T delete(int index)throws Exception {
		if(index<0 || index>=size) {
			throw new Exception("Array index out of bound");
		} 
		else { 
		T val=a[index];
		for(int i=index+1;i<size;i++) {
			a[i-1]=a[i];
		}
	//	a[size-1]=0;
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
public class GenericArrayTest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter length of array");
		int length=sc.nextInt();
		sc.close();
		
	//	ArrayTestG<Integer> a1= new ArrayTestG<>(length);
	//	ArrayTestG<String> a1= new ArrayTestG<>(length);
		ArrayTestG<Double> a1= new ArrayTestG<>(length);
		System.out.println(a1.isEmpty());
		
		try {
			a1.add(0, 98.78);
			a1.add(1, 78.9);
//			a1.add(0, "vaishali");
//			a1.add(1, "shikha");
//			a1.add(0, 45);
//			a1.add(1, 10);
//			a1.add(2, 5);
			a1.print();
			System.out.println("size= "+ a1.size());
		}catch (Exception e1) {
		//e1.printStackTrace();
			System.out.println("Array Index out of bound Exception in add operation");
		}
		
		try {
			System.out.println("deleted element= " + a1.delete(2));
			a1.print();
		}catch (Exception e) {
			System.out.println("Array Index out of bound Exception in delete operation");
		}
	}

}
