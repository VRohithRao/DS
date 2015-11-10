/**
 * Created by Rohith Vallu on 10/19/2015.
 */
public class FlipGameII {

    public static boolean canWin(String s) {
        int result = 0;
        int i =0;
        while(i<s.length()-1){
            if((s.charAt(i) == '+' && s.charAt(i+1) == s.charAt(i)) &&
                    !(canWin(s.substring(0,i)+"--"+s.substring(i+2)))){
                i++;
                return true;
            }
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canWin("++++"));
    }
}
