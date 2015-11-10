import java.util.*;

/**
 * Created by Rohith Vallu on 11/1/2015.
 */
public class WordBreakII {

    public static List<String> wordBreaker(HashSet<String> dictionary, String str){
        int size = str.length();

        ArrayList<String> wb[] = new ArrayList[size+1];
        wb[0] = new ArrayList<String>();
        for (int i=0; i<size; i++) {
            if(wb[i] == null)
                continue;

            for(String s:dictionary){
                int len = s.length();
                int end = len+i;

                if(end<=str.length()){
                    if(str.substring(i,end).compareTo(s) == 0){
                        if(wb[end] == null){
                            wb[end] = new ArrayList<String>();
                        }
                        wb[end].add(s);
                    }
                }
            }

        }

        List<String> result = new LinkedList<String>();
        if(wb[str.length()] == null)
            return result;

        ArrayList<String> temp = new ArrayList<String>();
        dfs(wb, str.length(), result, temp);

        return result;
    }

    public static void dfs(List<String> dp[],int end,List<String> result, ArrayList<String> tmp){
        if(end <= 0){
            String path = tmp.get(tmp.size()-1);
            for(int i=tmp.size()-2; i>=0; i--){
                path += " " + tmp.get(i) ;
            }

            result.add(path);
            return;
        }

        for(String str : dp[end]){
            tmp.add(str);
            dfs(dp, end-str.length(), result, tmp);
            tmp.remove(tmp.size()-1);
        }
    }

    public static void main(String[] args) {
        HashSet<String> dictionary = new HashSet<String>();
        dictionary.add("cat");
        dictionary.add("cats");
        dictionary.add("and");
        dictionary.add("sand");
        dictionary.add("dog");

        wordBreaker(dictionary,"catsand");


    }
}
