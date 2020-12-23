import java.util.*;
import java.util.Map.*;
public class CountDupWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc  = new Scanner(System.in);
		String input = sc.nextLine();
		input= input.toLowerCase();
		String regex = "[' '|','|'.'|' .'|', ']";
		String words[] = input.split(regex);
		for(String i : words)
			System.out.println(i+ " ");
		Map<String,Integer> m = new HashMap<>();
		for(int i=0;i<words.length;i++) {
			String st = words[i];
			int count=1;
			if(!m.containsKey(st)){
				m.put(st,count);
			}
			else {
				int val = m.get(st);
				m.put(st,++val);
			}
		}
		for(Entry<String,Integer> entry: m.entrySet()) {
			if(entry.getValue() > 1)
				System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

}
