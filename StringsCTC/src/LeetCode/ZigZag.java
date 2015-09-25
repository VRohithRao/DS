package LeetCode;

public class ZigZag {
	StringBuilder sb = new StringBuilder();
	
	public String convert(String text, int nRows){
		int threshold = (nRows - 1) * 2;
		int totalIter  = (int) Math.floor((text.length() / nRows)); 
		int i = 0, j = 0, counter = 0;
		while(j <= totalIter && counter < 3){
			if((threshold*i+j) < text.length()){
				int position = threshold*i+j;
				System.out.println(position);
				sb.append(text.charAt(position));
				i++;
				if(i == totalIter  && j < totalIter){
					i = 0;
					counter = 0;
					j++;
				}
			}else{
				counter += 1;
			}
		}
		System.out.println("About to exit");
		return sb.toString();
	}
	
	public static void main(String a[]){
		ZigZag zz = new ZigZag();
		System.out.println(zz.convert("PAYPALISHIRING", 3));
				
	}
}
