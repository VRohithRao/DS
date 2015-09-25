package yelp;

public class SplitParaIntoSentences {
	public static void main(String a[]){
		String para = "Is this how a paragraph is split into a sentence? "
				+ "But, there is a problem! My paragraph includes dates like Jan.13, 2014 , words like U.S and numbers like 2.2. "
				+ "They all got splitted by the above code.";
		
		String[] sentences = para.split("(?i)(?<=[.?!])\\s+(?=[a-z])");
		System.out.println(sentences.length);
		for(int i=0;i<sentences.length;i++)
			System.out.println(sentences[i]);
	}
}
