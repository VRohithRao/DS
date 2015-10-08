/**
 * Created by Rohith Vallu on 10/7/2015.
 */
public class ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int wordPos1 = -1;
        int wordPos2 = -1;
        int maxDist = Integer.MAX_VALUE;

        for(int i=0; i<words.length;i++){
            if(word1.equals(words[i])){
                wordPos1 = i;
            }else if(word2.equals(words[i])){
                wordPos2 = i;
            }

            if(wordPos1!=-1 && wordPos2 !=-1 && wordPos1!=wordPos2)
                maxDist = Math.min(maxDist,Math.abs(wordPos1-wordPos2));

            if(word1.equals(word2)){
                wordPos2 = wordPos1;
            }

        }
        return maxDist;
    }
}
