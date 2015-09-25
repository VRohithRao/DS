
public class Test {
	public static int recursionTest(int a, int b){
		int i = 2;
		if(a < 10){
			
			a += i; b = b*i/2;  
			System.out.println("Inside recursion call :" +a);
			return recursionTest(a,b);
			
		}
		else
			return 0;
	}
	public static void main(String arg[]){
		int[] i ={1, 2, 3, 2, 3, 1, 3};
		int a = i[0];
		for(int j = 1;j < i.length;j++)
			a = a ^ i[j];
		
		
		int x = 4, y = 3;
		
		x  = x ^ y;
		System.out.println(x + ":" + y);
		y  = x ^ y;
		System.out.println(x + ":" + y);
		x  = x ^ y;
		System.out.println(x + ":" + y);
		System.out.println(a);		
		System.out.println("recursion"+ recursionTest(3,3));		
		
	}
}
