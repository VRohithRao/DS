import java.io.*;
import java.util.Scanner;
public class ReverseString {

	
	
	    public static void main(String args[] ) throws Exception {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
	        
	        Scanner in  = new Scanner(System.in);
	        String givenString = in.next();
	        StringBuilder sb = new StringBuilder();
	        
	        if(givenString == null || givenString.isEmpty()){
	            System.out.println(givenString);
	            return;
	        }
	        String[] stringParts = givenString.split("\\s+");
	        
	        int partsLength = stringParts.length;
	        
	        for(int i = partsLength-1; i>0;i--){
	            sb.append(stringParts[i]).append(" ");
	        }
	        
	        sb.append(stringParts[0]);
	        
	        System.out.print(sb.toString());
	        
	    }
	}

