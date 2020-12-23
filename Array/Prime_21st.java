import java.util.*;
public class Prime_21st {

	public static void main(String[] args) {
		int i=2;
		int count=0;
		while(true) {
			boolean flag = true;
			for(int j=2;j*j<=i;j++) {
				if(i%j==0) {
					flag = false;
					break;
				}
			}
			if(flag==true) {
				count++;
			}
			if(count==21) {
				System.out.println(i);
				break;
			}
			i++;
		}
	}

}
