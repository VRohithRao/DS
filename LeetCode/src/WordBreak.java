import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Rohith Vallu on 11/1/2015.
 */
public class WordBreak {

//    O(n^2)
    public static boolean wordBreaker(int start,HashSet<String> dictionary, String word){

        if(start == word.length())
            return true;

        for(String d:dictionary){
            int length = d.length();
            int end = start+length;

            if(end<=word.length())
                if(word.substring(start,end).equals(d))
                    if(wordBreaker(end,dictionary,word))
                        return true;
        }
        return false;
    }

//    my solution O(n^2)
    public static boolean wordBreaker2(HashSet<String> dictionary, String word){

        if(word.length() == 0)
            return true;

        for(int i = 1;i <= word.length();i++)
            if(dictionary.contains(word.substring(0,i)) && wordBreaker2(dictionary, word.substring(i,word.length())))
                return true;

        return false;
    }

    // pattern matcher, for build takes (2^m)and executing it takes O(n)
    public static boolean patternBreak(String word, HashSet<String> dictionary) {
        StringBuilder sb = new StringBuilder();

        for(String s: dictionary){
            sb.append(s + "|");
        }

        String pattern = sb.toString().substring(0, sb.length()-1);
        pattern = "(" + pattern + ")*";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(word);

        if (m.matches()){
            return true;
        }else
            return false;

    }

    // geek for geeks dp O(list size * word size)
    public static boolean wordBreakerDP(HashSet<String> dictionary, String str){
        int size = str.length();
        if(size==0)
            return true;

        boolean[] wb = new boolean[size+1];
        for (int i=1; i<=size; i++)
        {
            // if wb[i] is false, then check if current prefix can make it true.
            // Current prefix is "str.substr(0, i)"
            if (wb[i] == false && dictionary.contains(str.substring(0, i)))
                wb[i] = true;

            // wb[i] is true, then check for all substrings starting from
            // (i+1)th character and store their results.
            if (wb[i] == true)
            {
                // If we reached the last prefix
                if (i == size)
                    return true;

                for (int j = i+1; j <= size; j++)
                {
                    // Update wb[j] if it is false and can be updated
                    // Note the parameter passed to dictionaryContains() is
                    // substring starting from index 'i' and length 'j'
                    if (wb[j] == false && dictionary.contains(str.substring(i, j)))
                        wb[j] = true;

                    // If we reached the last character
                    if (j == size && wb[j] == true)
                        return true;
                }
            }
        }

    /* Uncomment these lines to print DP table "wb[]"
        for (int i = 1; i <= size; i++)
            System.out.print(" " + wb[i]);
    */
        // If we have tried all prefixes and none of them worked
        return false;

    }

//    leetcode DP O(list size * word size)

    public static boolean wordBreakDP2(String s, HashSet<String> dict) {
        boolean[] t = new boolean[s.length()+1];
        t[0] = true; //set first to be true, why?
        //Because we need initial state

        for(int i=0; i<s.length(); i++){
            //should continue from match position
            if(!t[i])
                continue;

            for(String a: dict){
                int len = a.length();
                int end = i + len;
                if(end > s.length())
                    continue;

                if(t[end]) continue;

                if(s.substring(i, end).equals(a)){
                    t[end] = true;
                }
            }
        }

        return t[s.length()];
    }

    public static void main(String[] args) {
        HashSet<String> dictionary = new HashSet<String>();
        dictionary.add("i");
        dictionary.add("like");
        dictionary.add("samsung");
        dictionary.add("icecream");
        dictionary.add("mango");
        dictionary.add("and");

//        System.out.println(wordBreaker(0,dictionary,"mangoand"));

  //      System.out.println(wordBreaker2(dictionary,"mangoand"));

//        patternBreak("mangoand",dictionary);

        System.out.println(wordBreakerDP(dictionary, "mangoandilike"));

        System.out.println(wordBreakDP2("mangoand", dictionary));
    }
}
