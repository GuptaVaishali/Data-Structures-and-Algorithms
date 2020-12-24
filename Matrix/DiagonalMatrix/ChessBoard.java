import java.util.Scanner;
public class ChessBoard {

	public static int checkCoordinates(int x1, int y1, int x,int y) {
		int count = 0;
		if(x>=1 && x<=8 && y>=1 && y<=8) {
			if(!(x==x1 || y==y1 || Math.abs(x-x1)== Math.abs(y-y1)))
				count++;
			else {
				if(x==x1 && y==y1) 
				count++;
			}
		}
		return count;
	} 
	
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
	//	int x1 = sc.nextInt();
	//	int y1 = sc.nextInt();
	//	int x2 = sc.nextInt();
	//	int y2 = sc.nextInt();
		String arr[] = {"(3,1)","(4,4)"};
		String fco = arr[0];
		String sco = arr[1];
	//	System.out.println(fco + " " + sco);
		
		String coordinates1[] = fco.split(",");
		
	//	System.out.println(coordinates1[0]);
		
		String coord[] = coordinates1[0].split("");
		int x1 = Integer.parseInt(coord[1]);
		
		String coord1[] = coordinates1[1].split("");
		int y1 = Integer.parseInt(coord1[0]);
		
	//	System.out.println(x1 + " " + y1);
		
		String coordinates2[] = sco.split(",");
		
		String coord2[] = coordinates2[0].split("");
		int x2 = Integer.parseInt(coord2[1]);
		
		String coord3[] = coordinates2[1].split("");
		int y2 = Integer.parseInt(coord3[0]);
		
	//	System.out.println(x2 + " " + y2);
		
		if(!(x1==x2 || y1==y2 ||  Math.abs(x1-x2) == Math.abs(y1-y2))) {
			System.out.println(-1);
		}
		else {
			int a = checkCoordinates(x1,y1,x2+1,y2);
			int b = checkCoordinates(x1,y1,x2-1,y2);
			int c = checkCoordinates(x1,y1,x2,y2+1);
			int d = checkCoordinates(x1,y1,x2,y2-1);
			int e = checkCoordinates(x1,y1,x2+1,y2+1);
			int f = checkCoordinates(x1,y1,x2-1,y2-1);
			int g = checkCoordinates(x1,y1,x2+1,y2-1);
			int h = checkCoordinates(x1,y1,x2-1,y2+1);
			System.out.println(a+b+c+d+e+f+g+h);
		} 
		
		sc.close();
	}
}
