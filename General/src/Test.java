import java.text.SimpleDateFormat;
import java.util.Date;


public class Test {
	
	static Date start;
	static Date end;
	static SimpleDateFormat sdf;

	public static float reverse(float num){
		float rev = 0;
		while(num !=0){
			rev = (rev*10) + (num%10);
			num = num / 10;
		}
		return rev;
	}
	
	public static void main(String a[]) throws Exception{
		
		
		Date d = new Date();
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		
		start = sdf.parse("2007-11-30");
		end = sdf.parse("2008-02-01");
		
		System.out.println(isWithin("2007-11-30"));
		System.out.println(isWithin("2007-12-01"));
		System.out.println(isWithin("2007-12-02"));
		System.out.println(isWithin("2008-02-01"));
		
//		System.out.print("Reverse :" + reverse((float) 123.50));
		int i = 2, j =3;
		String s = "++++";
		String temp = s.substring(0,i)+"--"+s.substring(j+1,s.length());
		System.out.print(s.substring(0,i)+"--"+s.substring(j+1,s.length()) + " " + s);
		
	}
	
	
	private static boolean isWithin(String date) throws Exception{
		return valid(sdf.parse(date));
	}
	
	private static boolean valid(Date d){
		return d.after(start) && d.before(end);
	}

}
