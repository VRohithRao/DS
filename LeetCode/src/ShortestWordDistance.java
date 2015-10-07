/**
 * Created by Rohith Vallu on 10/6/2015.
 */
public class ShortestWordDistance {
     public int shortestDistance(String[] words, String word1, String word2) {
        int wordPos1 = -1;
        int wordPos2 = -1;
        int maxDist = words.length;

        for(int i=0; i<words.length;i++){
            if(word1.equals(words[i])){
                wordPos1 = i;
            }
            if(word2.equals(words[i])){
                wordPos2 = i;
            }
            if(wordPos1!=-1 && wordPos2 !=-1)
                maxDist = Math.min(maxDist,Math.abs(wordPos1-wordPos2));
        }
        return maxDist;
    }
}
