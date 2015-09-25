import java.text.SimpleDateFormat;
import java.util.Date;


public class Test {
	
	static Date start;
	static Date end;
	static SimpleDateFormat sdf;
	
	public static void main(String a[]) throws Exception{
		
		
		Date d = new Date();
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		
		start = sdf.parse("2007-11-30");
		end = sdf.parse("2008-02-01");
		
		System.out.println(isWithin("2007-11-30"));
		System.out.println(isWithin("2007-12-01"));
		System.out.println(isWithin("2007-12-02"));
		System.out.println(isWithin("2008-02-01"));
		
		
		
	}
	
	
	private static boolean isWithin(String date) throws Exception{
		return valid(sdf.parse(date));
	}
	
	private static boolean valid(Date d){
		return d.after(start) && d.before(end);
	}

}
