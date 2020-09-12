package hashing;

import java.util.Arrays;

class HTable {
	int a[],h;
	
	HTable(int h){
		this.h=h;
		a=new int[h];
		Arrays.fill(a, -1);
	}
	
	void insert(int key) throws Exception {
		int index=key%h;
		do {
			if(a[index]==-1) {
				a[index]=key;
				return;
			}
			else if(a[index]==key)
				return;
			else
				index=(index+1)%h;
		}while(index!=key%h);
		throw new Exception("hash table is full");
	}
	
	int search(int key) throws Exception {
		int index=key%h;
		do {
			if(a[index]==-1) {
				return -1;
			}
			else if(a[index]==key)
				return index;
			else
				index=(index+1)%h;
		}while(index!=key%h);
		throw new Exception("Key not found");
	}
	
	void display() {
		for(int i=0;i<h;i++) {
			if(a[i]!=-1)
				System.out.println(a[i] +" " + i );
		}
		System.out.println();
	}
	
}


public class HashTable {

	public static void main(String[] args) {
		HTable ht = new HTable(7);
		try {
			ht.insert(15);
			ht.insert(11);
			ht.insert(25);
			ht.insert(16);
			ht.insert(9);
			ht.insert(8);
			ht.insert(12);
			ht.display();
			
			int index=ht.search(8);
			if(index==-1) 
				System.out.println("Key Not Found");
			else
				System.out.println("Key Found At index " + index);
			
			ht.insert(10);
			ht.display();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
