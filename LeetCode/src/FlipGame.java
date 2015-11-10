import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rohith Vallu on 11/1/2015.
 */
public class FlipGame {
    public static List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<String>();
        int i =0;
        while(i<s.length()-1){
            if(s.charAt(i) == '+' && s.charAt(i+1) == '+'){
                result.add(s.substring(0,i) + "--" + s.substring(i+2));
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        String chars = "--";
        List result = generatePossibleNextMoves(chars);
        for(Object s : result){
            System.out.println(s.toString());
        }
    }

}
