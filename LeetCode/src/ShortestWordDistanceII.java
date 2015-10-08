import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Rohith Vallu on 10/6/2015.
 */
public class ShortestWordDistanceII {
    private HashMap<String, List<Integer>> map = new HashMap<String,List<Integer>>();
    public ShortestWordDistanceII(String[] words) {
        addToMap(words);
    }

    public void addToMap(String[] words){
        for(int i = 0; i<words.length;i++){
            if(map.containsKey(words[i])){
                List pos = map.get(words[i]);
                pos.add(i);
                map.put(words[i],pos);
            }else{
                List<Integer> pos = new ArrayList<Integer>();
                pos.add(i);
                map.put(words[i],pos);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> mapA = map.get(word1);
        List<Integer> mapB = map.get(word2);
        int maxDist = Integer.MAX_VALUE;
        for(Integer i : mapA)
            for(Integer j : mapB)
                maxDist = Math.min(maxDist, Math.abs(i-j));

        return maxDist;
    }
}
