import java.util.Scanner;


public class IfAnagrams {
	/*	
	 * Given two strings, find if they are anagrams. Or simple if the permutation
	 * of one can be the other string.
	*/
	
	public String sort(String given){
		char[] content = given.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}
	
	public boolean ifPermutation(String a, String b){
		// idea is to break both the string into characters, sort them and check
		// if they are equal.
		
		if(a.length() != b.length())
			return false;
		
		return sort(a).equals(sort(b));
	}
	
	public static void main(String a[]){
		IfAnagrams ana = new IfAnagrams();
		Scanner in = new Scanner(System.in);
		boolean check = ana.ifPermutation(in.next(), in.next());
		System.out.print(check);
	}
}
