
public class NumberOccuringOddNoOfTimes {
	public static void oddNumber(int i[]){
		
		int a = i[0];
		for(int j = 1;j < i.length;j++)
			a = a ^ i[j];
		
		System.out.print(a);
	}
	public static void main(String arg[]){
		int[] i ={1, 2, 3, 2, 3, 1, 3};
		oddNumber(i);
	}
}
