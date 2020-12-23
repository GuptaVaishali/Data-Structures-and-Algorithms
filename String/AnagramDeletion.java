import java.util.*;
import java.util.Map.*;
public class AnagramDeletion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
	        int t= sc.nextInt();
	        int delop=0;
	        Map<Character,Integer> m  = new HashMap<>();
	        while(t>0){
	            String a = sc.next();
	            String b = sc.next();
	            String str="";
	            String str2="";
	            if(a.length()>b.length()){
	                str = a;
	                str2 = b;
	            }
	            else{
	                str = b;
	                str2 = a;
	            }
	            for(int i=0;i<str.length();i++){
	                char ch  = str.charAt(i);
	                int count=1;
	                if(!m.containsKey(ch)){
	                    m.put(ch,count);
	                }
	                else{
	                    int val = m.get(ch);
	                    m.put(ch,++val);
	                }
	            }
	            for(int i=0;i<str2.length();i++){
	                char ch  = str2.charAt(i);
	                if(m.containsKey(ch)){
	                    int v = m.get(ch);
	                    if(v>0)
	                        m.put(ch,--v);
	                    else
	                        delop++;
	                }
	                else
	                    delop++;  
	            }
	         //    System.out.println(delop);
	            for(Entry<Character,Integer> entry: m.entrySet()){
	                if(entry.getValue()>0)
	                    delop+= entry.getValue();
	            }
	            System.out.println(delop);
	            t--;
	        }
	}

}
