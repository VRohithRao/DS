
public class CheckCharCount {
	
	public boolean ifPermutation(String a, String b){
		// idea is to break both the string into characters, sort them and check
		// if they are equal.
		
		if(a.length() != b.length())
			return false;
		
		int letters[] = new int[256];
		char[] s_array = a.toCharArray();
		for(char c:s_array){
			letters[c]++;
		}
		return true;
	}
	
	public static void main(String a[]){
		IfAnagrams ana = new IfAnagrams();
		boolean check = ana.ifPermutation("abcd", "cdab");
//		System.out.print(check);
		int letters[] = new int[2];
		char[] s_array = "abcdgeh".toCharArray();
		for(char c:s_array){
			letters[c]++;
		}
		System.out.println(letters['c']);
	}
}

