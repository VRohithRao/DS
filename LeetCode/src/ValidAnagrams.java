import java.util.Arrays;

/**
 * Created by Rohith Vallu on 10/6/2015.
 */
public class ValidAnagrams {
    public boolean isAnagram(String s, String t) {

        if(s == null && t == null)
            return true;
        if((s==null && t!=null) || (s!=null && t==null))
            return false;

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        s = String.valueOf(sArray);
        t = String.valueOf(tArray);

        return s.equals(t);

    }

    public static void main(String[] args) {
        ValidAnagrams va = new ValidAnagrams();
        System.out.print(va.isAnagram("abcde","ceab"));
    }
}
