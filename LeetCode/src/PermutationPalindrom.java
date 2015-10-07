import java.util.HashMap;

/**
 * Created by Rohith Vallu on 10/6/2015.
 */
public class PermutationPalindrom {

        public boolean canPermutePalindrome(String s) {
            if(s == null || s.length() <= 1 )
                return true;
            HashMap<Character, Integer> palindrom = new HashMap<Character, Integer>();


            for(int i=0;i<s.length();i++){
                char ch = s.charAt(i);
                if(palindrom.containsKey(ch))
                    palindrom.put(ch, palindrom.get(ch)+1);
                else
                    palindrom.put(ch, 1);
            }

            int oddFlag = 0;
            for(Integer value: palindrom.values()){
                if(value % 2 == 1)
                    oddFlag +=1;
            }
            if(s.length() % 2 == 0 && oddFlag == 0)
                return true;
            else if(s.length() % 2 == 1 && oddFlag == 1)
                return true;
            else
                return false;
        }


}
