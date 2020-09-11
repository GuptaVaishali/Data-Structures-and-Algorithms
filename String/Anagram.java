import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CheckAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Character,Integer> m= new HashMap<>();
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter First String");
		String s1=sc.next();
		System.out.println("Enter Second String");
		String s2=sc.next();
		sc.close();
		
		if(s1.length()!=s2.length()) {
			System.out.println("Not Anagrams");
		}
		else {
			for(int i=0;i<s1.length();i++) {
				char ch=s1.charAt(i);
				int value=0;
				if(m.containsKey(s1.charAt(i))) {
					int val=m.get(ch);
					m.put(ch,++val);
				//	System.out.println(m);
					
				}
				else
					m.put(s1.charAt(i),++value);
				
			}
			System.out.println(m);
			boolean flag=true;
			for(int j=0;j<s2.length();j++) {
				char ch1=s2.charAt(j);
				if(m.containsKey(ch1)) {
					int val2= m.get(ch1);
					if(val2<=0) {
						flag=false;
						break;
					}
					m.put(ch1, --val2);
				}
				else {
					flag=false;
				}
			}
			
			System.out.println(m);
			if(flag)
				System.out.println("Anagrams");
			else
				System.out.println("Not Anagrams");
		}
		
	}

}
