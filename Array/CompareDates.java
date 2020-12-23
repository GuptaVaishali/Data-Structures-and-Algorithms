import java.util.Date;
import java.text.*;
import java.util.*;
public class CompareDates {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdformat =  new SimpleDateFormat("dd/mm/yyyy");
		Scanner sc =  new Scanner(System.in);
		String date1 = sc.next();
		String date2 = sc.next();
		Date d1 = sdformat.parse(date1);
		Date d2 =  sdformat.parse(date2);
		if(d1.compareTo(d2)<0) {
			System.out.println("S");
		}
		
		else if(d1.compareTo(d2)>0) {
			System.out.println("L");
		}
		
		else if(d1.compareTo(d2)==0)
			System.out.println("E");
		
	}

}
