/**
 *
 */

/**
 * @author RamnathReddyMedikonda
 *
 */
public class ReverseString {

	static String givenString;
	static int stringLength;
	static StringBuilder sb = new StringBuilder();

	/**
	 *
	 */
	public ReverseString() {
		// TODO Auto-generated constructor stub
	}
	public String revWordsInStringMethod1() {
		if (givenString == null || givenString.isEmpty() || givenString.length() == 1)
			return givenString;

		String[] stringParts = givenString.split("\\s+");
		for (int i = 0; i < stringParts.length; i++)
			System.out.println(stringParts[i] + "+" + stringParts[i].length());

		int partsLength = stringParts.length;

		for (int i = partsLength - 1; i > 0; i--) {
			sb.append(stringParts[i]).append(" ");
		}
		System.out.println(stringParts[0].length());
		System.out.println(sb.length());
		sb.append(stringParts[0]);
		System.out.println(sb.length());
		return sb.toString();
	}

	public String reverseWords(String s) {
		if(s == null || s.length() == 0) return "";
		String[] arr = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i = arr.length-1; i >= 0; i--){
			if(!arr[i].equals(""))
				sb.append(arr[i]).append(" ");
		}
		// if(sb.length() == 0) return "";
		System.out.println(sb.toString());
		return sb.substring(0, sb.length()-1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		givenString = "ram       abc    nath   ";
		ReverseString myObject = new ReverseString();
		System.out.println("Result of '" + givenString + "' is: " + myObject.revWordsInStringMethod1());
		System.out.println("Result of '" + givenString + "' is: " + myObject.reverseWords(givenString));
	}

}
