/**
 * Created by Rohith Vallu on 10/19/2015.
 */
public class FlipGameII {

    public static boolean canWin(String s) {
        if(s.length() == 0 || s.length() == 1)
            return false;
        else if(s.length() == 3 || s.length() == 2)
            return true;
        int isContinuous = 0;
        int consecutiveCnt = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '+' && consecutiveCnt == 0){
                consecutiveCnt = 1;
            }else if(s.charAt(i) == '+' && consecutiveCnt != 2){
                consecutiveCnt ++ ;
            }else if(s.charAt(i) == '+' && consecutiveCnt == 2){
                consecutiveCnt = 1;
                isContinuous += 2;
            }else{
                consecutiveCnt = 0;
            }

        }
        if(isContinuous == 2)
            isContinuous += consecutiveCnt;
        if(isContinuous % 4 == 0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.print(canWin("++++"));
    }
}
