
public class UniqueString {
	
	public boolean uniqueString(String givenString){
		/* 	Assuming the character set is ASCII and in extended
			ASCII the unique string range is from 0 to 255 otherwise
			its 0 to 127. Ask the interviewer about it.
		*/		
		if (givenString.length() > 256)
			return false;
		
		boolean char_set[] = new boolean[256];
		for (int i = 0; i < givenString.length(); i++){
			int val = givenString.charAt(i);
			System.out.print(givenString.charAt(i));
			if(char_set[val]){
				return false;
			}
			char_set[val] = true;
		}
		
		return true;
	}
	
	public static void main(String arg[]){
		UniqueString uni = new UniqueString();
		boolean check = uni.uniqueString("abcdf");
		System.out.println(check);
	}
}
	/*	There is other version for implementing the same program to save the space 
		complexity. Refer CTC
	*/

