/*Solution for CTC V5 1.8*/


public class CheckRotationOfStringIsOther {
	public boolean isRotation(String s1, String s2){
		int len = s1.length();
		if(s2.length()>0 && len == s2.length()){
			String concate = s1+s1;
			return concate.contains(s2);
		}
		return false;
	}
	public static void main(String args[]){
		CheckRotationOfStringIsOther crso = new CheckRotationOfStringIsOther();
		boolean flag = crso.isRotation("waterbottle", "erbottlewat");
		System.out.print(flag);
	}
}
/*
	Assume you have a method isSubstring which checks if one word is a substring
	of another. Given two strings, si and s2, write code to check Ifs2 is a rotation 
	of s1 using only onecalltoisSubstring (e.g., "waterbottLe" is a rotation of "erbottLewat").
*/