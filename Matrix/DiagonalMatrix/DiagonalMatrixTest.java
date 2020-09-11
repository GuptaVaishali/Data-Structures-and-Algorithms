package Matrix;

import java.util.Scanner;

class DiagonalMatrix{
	float a[];
	int n;
	
	DiagonalMatrix(int n){
		this.n=n;
		a=new float[n];
	}
	
	void read() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Diagonal Elements of array");
		for(int i=0;i<n;i++) {
			a[i]=sc.nextFloat();
		}
	//	sc.close();
	}
	
	DiagonalMatrix add(DiagonalMatrix d) {
		DiagonalMatrix d3= new DiagonalMatrix(n);
		for(int i=0;i<n;i++) {
			d3.a[i]=a[i]+d.a[i];
		}
		return d3;
	}
	
	DiagonalMatrix multiply(DiagonalMatrix d) {
		DiagonalMatrix d3= new DiagonalMatrix(n);
		for(int i=0;i<n;i++) {
			d3.a[i]=a[i]*d.a[i];
		}
		return d3;
	}
	
	float determinant() {
		float det=1;
		for(int i=0;i<n;i++) {
			det*=a[i];
		}
		return det;
	}
	
	DiagonalMatrix inverse() throws Exception{
		DiagonalMatrix d3=new DiagonalMatrix(n);
		if(determinant()==0) {
			throw new Exception("Inverse of matrix does not exist");
		}
		for(int i=0;i<n;i++) {
			d3.a[i]=1/a[i];
		}
		return d3;
	}
	
	void print() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==j)
					System.out.print(a[i]+" ");
				else
					System.out.print(0.0+ " ");
			}
			System.out.println();
		}
	}
}


public class DiagonalMatrixTest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter dimension of array");
		int n=sc.nextInt();
		DiagonalMatrix d1 = new DiagonalMatrix(n);
		DiagonalMatrix d2 = new DiagonalMatrix(n);
		
		d1.read();
		System.out.println("\nThe matrix is");
		d1.print();
		
		d2.read();
		System.out.println("\nThe matrix is");
		d2.print();
		
		System.out.println("\nAddition of matrix");
		DiagonalMatrix d3= d1.add(d2);
		d3.print();
		
		System.out.println("\nMultiplication of matrix");
		DiagonalMatrix d4= d1.multiply(d2);
		d4.print();
		
		System.out.println("\nInverse of matrix");
		try {
			DiagonalMatrix d5=d1.inverse();
			d5.print();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
				
		float det= d1.determinant();
		System.out.println("\ndeterminant= "+ det);
		
	}

}
